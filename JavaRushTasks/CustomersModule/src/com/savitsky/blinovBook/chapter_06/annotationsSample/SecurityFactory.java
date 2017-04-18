package com.savitsky.blinovBook.chapter_06.annotationsSample;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by esavitski on 18.04.2017.
 */
public class SecurityFactory {
    public static AccountOperationManager createSecurityObject(AccountOperationManager targetObject){
        return (AccountOperationManager)Proxy.newProxyInstance(
                targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(),
                new SecurityInvokationHandler(targetObject)
                );
    }

    private static class SecurityInvokationHandler implements InvocationHandler{
        private Object targetObject;

        public SecurityInvokationHandler(Object targetObject) {
            this.targetObject = targetObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            SecurityLogic logic = new SecurityLogic();
            Method realMethod = targetObject.getClass().getMethod(method.getName(), (Class[]) method.getGenericParameterTypes());
            BankingAnnotation annotation = realMethod.getAnnotation(BankingAnnotation.class);
            if(annotation != null){
                logic.onInvoke(annotation.securityLevel(), realMethod, args);
                try {
                    return method.invoke(targetObject, args);
                }
                catch (InvocationTargetException ex){
                    System.out.println(annotation.securityLevel());
                    throw ex.getCause();
                }
            }
            else{
                throw new InvocationTargetException(null, "Method " + realMethod + "should be annotated ");
            }
        }
    }
}
