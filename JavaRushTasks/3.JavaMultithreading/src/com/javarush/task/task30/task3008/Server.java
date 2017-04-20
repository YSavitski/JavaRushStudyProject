package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by 07ers on 4/20/2017.
 */
public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message){

        connectionMap.values().stream().forEach(connection -> {
            try {
                connection.send(message);
            } catch (IOException e) {
                e.printStackTrace();
                ConsoleHelper.writeMessage("Message not sent");
            }
        });
    }



    public static void main(String[] args){
        ConsoleHelper.writeMessage("Please, enter server's port: ");
        try(ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt())) {
            ConsoleHelper.writeMessage("Server is ran");

            while (true){
                //Listening
                Handler handler = new Handler(serverSocket.accept());
                handler.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Handler extends Thread{
        private Socket socket;

        public Handler(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Established connection with address: " + socket.getRemoteSocketAddress());
            String clientName = null;

            try(Connection connection = new Connection(socket)){
                clientName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, clientName));
                sendListOfUsers(connection, clientName);
                serverMainLoop(connection, clientName);
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("An error occurred while communicating with the remote address");
            } finally {
                if (clientName != null){
                    connectionMap.remove(clientName);
                }
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, clientName));
                ConsoleHelper.writeMessage("Connection to remote address is closed");
            }
        }

        private String serverHandshake(Connection connection)throws IOException, ClassNotFoundException{
            String name;
            while (true){
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message messageReceive = connection.receive();
                if(messageReceive.getType() != MessageType.USER_NAME)
                    continue;
                if(messageReceive.getData().isEmpty())
                    continue;
                name = messageReceive.getData();
                if(connectionMap.containsKey(name))
                    continue;
                connectionMap.put(name, connection);
                connection.send(new Message(MessageType.NAME_ACCEPTED));
                break;
            }
            return name;
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException{
            connectionMap.keySet().stream().forEach(name -> {
                if(!name.equals(userName)){
                    try {
                        connection.send(new Message(MessageType.USER_ADDED, name));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while (true){
                Message message_response = connection.receive();
                Message formattedMessage = null;
                if(message_response.getType() == MessageType.TEXT){
                    formattedMessage = new Message(MessageType.TEXT,
                            String.format("%s: %s", userName, message_response.getData()));
                    sendBroadcastMessage(formattedMessage);
                } else{
                    ConsoleHelper.writeMessage("Error");
                }
            }
        }
    }
}
