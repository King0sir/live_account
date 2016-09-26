package org.kin.live.live_account.except.extend;

import org.kin.live.live_account.except.BaseException;

/**
 * Created by kingsir on 16-9-26.
 */
public class UserException extends BaseException{

    private UserException() {
    }

    private UserException(String message) {
        super(message);
    }

    @Override
    public void throwThisException() throws BaseException {
        throw new UserException();
    }

    @Override
    public void throwThisException(String message) throws BaseException {
        throw new UserException(message);
    }

    public enum ExceptCode{
        NoUser(1001,"没有对应用户"),
        NoEnableUser(1002,"对应用户不可用");

        private int code;
        private String message;

        ExceptCode(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
