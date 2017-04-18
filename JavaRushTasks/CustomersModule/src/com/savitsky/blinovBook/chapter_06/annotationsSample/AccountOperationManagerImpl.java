package com.savitsky.blinovBook.chapter_06.annotationsSample;

/**
 * Created by esavitski on 18.04.2017.
 */
public class AccountOperationManagerImpl implements AccountOperationManager {
    @BankingAnnotation(securityLevel = SecurityLevelEnum.HIGH)
    @Override
    public double depositInCash(int accountNumber, int amount) {
        return 0;
    }

    @BankingAnnotation(securityLevel = SecurityLevelEnum.HIGH)
    @Override
    public boolean withdraw(int accountNumber, int amount) {
        return false;
    }

    @BankingAnnotation(securityLevel = SecurityLevelEnum.LOW)
    @Override
    public boolean convert(double amount) {
        return false;
    }

    @BankingAnnotation
    @Override
    public boolean transfer(int accountNumber, int amount) {
        return false;
    }
}
