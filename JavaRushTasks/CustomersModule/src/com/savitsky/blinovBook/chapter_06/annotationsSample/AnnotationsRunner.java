package com.savitsky.blinovBook.chapter_06.annotationsSample;

/**
 * Created by esavitski on 18.04.2017.
 */
public class AnnotationsRunner {
    public static void main(String[] args){
        AccountOperationManager account = new AccountOperationManagerImpl();
        AccountOperationManager securityAccount = SecurityFactory.createSecurityObject(account);
        securityAccount.depositInCash(10128336, 6);
        securityAccount.withdraw(64092376, 2);
        securityAccount.convert(200);
        securityAccount.transfer(64092376, 300);
    }
}
