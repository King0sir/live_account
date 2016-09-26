package org.kin.live.live_account.except;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by kingsir on 16-9-25.
 */
public abstract class BaseException extends Exception{
    public BaseException() {
        super();
    }
    public BaseException(String message){
        super(message);
    }
    public abstract void throwThisException() throws BaseException;
    public abstract void throwThisException(String message) throws BaseException;

    public static <T extends BaseException> T getException(Class<T> tClass)
            throws IllegalAccessException, InstantiationException {
        return tClass.newInstance();
    }

    public static <T extends BaseException> void throwExcept(Class<T> tClass,String message)
            throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Method throwThisException = tClass.getMethod("throwThisException",message.getClass());
        throwThisException.invoke(tClass.newInstance(),message);
    }

    public static <T extends BaseException> void throwExcept(Class<T> tClass)
            throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Method throwThisException = tClass.getMethod("throwThisException");
        throwThisException.invoke(tClass.newInstance());
    }
}
