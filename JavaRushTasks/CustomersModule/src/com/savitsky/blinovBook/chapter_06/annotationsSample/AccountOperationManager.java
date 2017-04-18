package com.savitsky.blinovBook.chapter_06.annotationsSample;

/**
 * Created by esavitski on 18.04.2017.
 */
public interface AccountOperationManager {
    double depositInCash(int accountNumber, int amount);
    boolean withdraw(int accountNumber, int amount);
    boolean convert(double amount);
    boolean transfer(int accountNumber, int amount);
}
