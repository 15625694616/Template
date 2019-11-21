package com.template.demos.utils;
import org.apache.log4j.Logger;

/**
 * 自定义异常
 *
 * @author com
 */
public class RRException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private Logger logger = Logger.getLogger(getClass());
    private String msg;
    private int code = 400;

    public RRException(String msg) {
        super(msg);
        logger.warn(msg);
        this.msg = msg;
    }

    public RRException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
        logger.warn(msg,e);
    }

    public RRException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
        logger.warn(msg+code);
    }

    public RRException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
        logger.warn(msg+code,e);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


}
