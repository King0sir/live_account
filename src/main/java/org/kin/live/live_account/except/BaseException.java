package org.kin.live.live_account.except;

/**
 * Created by kingsir on 16-9-25.
 */
public class BaseException extends Exception{
    public BaseException() {
        super();
    }
    public BaseException(String message){
        super(message);
    }
//    public abstract void throwThisException();

    //TODO：？需要解决：想要传入类的继承
//    public void throwException(Object<? extend BaseException>  clazz){
//
//    }
}
