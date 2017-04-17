package com.savitsky.blinovBook.chapter_05.samples.anonymous;

/**
 * Created by esavitski on 17.04.2017.
 */
public class RunnerWraper {
    public static void main(String[] args){
        String testStr = "qweRtyRR";
        System.out.println(testStr);

        WrapperString wsFirst = new WrapperString(testStr);
        System.out.println(wsFirst.replace('R','F'));


        WrapperString wsLast = new WrapperString(testStr){
            @Override
            public String replace(char oldChar, char newChar) {
                char[] array = new char[getStr().length()];
                getStr().getChars(0, getStr().length(), array, 0);
                for(int i=array.length-1; i >= 0; i--){
                    if(array[i]==oldChar){
                        array[i]=newChar;
                        break;
                    }
                }
                return new String(array);
            }
        };
        System.out.println(wsLast.replace('R','F'));


        WrapperString ws_2_position = new WrapperString(testStr){
            private int position = 2;

            @Override
            public String replace(char oldChar, char newChar) {
                int counter = 0;
                char[] array = new char[getStr().length()];
                getStr().getChars(0, getStr().length(), array, 0);
                if (verify(oldChar, array)) {
                    for (int i = 0; i < array.length; i++) {
                        if (array[i] == oldChar) {
                            counter++;
                            if (counter == position) {
                                array[i] = newChar;
                                break;
                            }
                        }
                    }
                }

                return new String(array);
            }

            public boolean verify(char oldChar, char[] array){
                int counter = 0;
                for (char c : array) {
                    if (c == oldChar) {
                        counter++;
                    }
                }
                return counter >= position;
            }
        };
        System.out.println(ws_2_position.replace('R','F'));

    }
}
