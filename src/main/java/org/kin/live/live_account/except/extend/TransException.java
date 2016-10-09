package org.kin.live.live_account.except.extend;

import org.kin.live.live_account.except.BaseException;

/**
 * Created by kingsir on 16-9-26.
 */
public class TransException extends BaseException{

    private TransException() {
    }

    private TransException(String message) {
        super(message);
    }

    @Override
    public void throwThisException() throws BaseException {
        throw new TransException();
    }

    @Override
    public void throwThisException(String message) throws BaseException {
        throw new TransException(message);
    }

    public enum ExceptCode{
        NoLegalPayTime(1001,"支付时间不合法"),
        NoLegalTransAmt(1002,"支付金额不合法"),
        NoLegalPayerId(1003,"付款人不合法"),
        NoLegalShares(1004,"分摊人不合法");

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
