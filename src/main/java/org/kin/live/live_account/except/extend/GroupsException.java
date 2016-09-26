package org.kin.live.live_account.except.extend;

import org.kin.live.live_account.except.BaseException;

/**
 * Created by kingsir on 16-9-26.
 */
public class GroupsException extends BaseException{

    private GroupsException() {
    }

    private GroupsException(String message) {
        super(message);
    }

    @Override
    public void throwThisException() throws BaseException {
        throw new GroupsException();
    }

    @Override
    public void throwThisException(String message) throws BaseException {
        throw new GroupsException(message);
    }

    public enum ExceptCode{
        NoGroup(1001,"没有对应小组"),
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
