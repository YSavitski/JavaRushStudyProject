package com.savitski.thinkingInJava.chapter_16.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

/**
 * Created by esavitski on 23.01.2017.
 */
public class OrderByteBuffer {
    private static final int BSIZE = 100;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileIn = reader.readLine();

        FileChannel inChannel = new FileInputStream(fileIn).getChannel();
        StringBuilder reaultReading = new StringBuilder();
        ByteBuffer inBuffer = ByteBuffer.allocateDirect(100);
        inChannel.read(inBuffer);
        inBuffer.flip();
        //inBuffer.order(ByteOrder.BIG_ENDIAN);
        inBuffer.order(ByteOrder.LITTLE_ENDIAN);
        while (inBuffer.hasRemaining()) {
            reaultReading.append((char) inBuffer.get());
        }

        /*ByteBuffer bb = ByteBuffer.wrap(new byte[BSIZE]);
        bb.asCharBuffer().put(reaultReading.toString());
        System.out.println(Arrays.toString(bb.array()));
        bb.rewind();
        bb.order(ByteOrder.BIG_ENDIAN);
        bb.asCharBuffer().put(reaultReading.toString());
        System.out.println(Arrays.toString(bb.array()));
        bb.rewind();
        bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.asCharBuffer().put(reaultReading.toString());
        System.out.println(Arrays.toString(bb.array()))*/
        ;

        /*System.out.print(Arrays.toString(inBuffer.array()));*/

        /*ByteBuffer bb = ByteBuffer.wrap(new byte[12]);
        bb.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(bb.array()));
        bb.rewind();
        bb.order(ByteOrder.BIG_ENDIAN);
        bb.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(bb.array()));
        bb.rewind();
        bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(bb.array()));*/

        char[] data = reaultReading.toString().toCharArray();
        ByteBuffer byteBuffer = ByteBuffer.allocate(data.length*2);
        CharBuffer charBuffer = byteBuffer.asCharBuffer();
        charBuffer.put(data);
        System.out.println(charBuffer.rewind());
        System.out.println(symmetricScramble(charBuffer).rewind());
        System.out.println(symmetricScramble(charBuffer).rewind());


    }

    private static CharBuffer symmetricScramble(CharBuffer buffer) {
        buffer.mark();
        char c1 = buffer.get();
        char c2 = buffer.get();
        buffer.reset();
        buffer.put(c2).put(c1);
        return buffer;
    }

}




