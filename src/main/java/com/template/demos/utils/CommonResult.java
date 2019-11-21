package com.template.demos.utils;


import io.swagger.annotations.ApiModelProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 通用返回对象
 */

public class CommonResult<T> {
    protected static Logger logger = LoggerFactory.getLogger(CommonResult.class);
    private int code;
    private String message;
    @ApiModelProperty(value = "返回对象")
    private T data;

    protected CommonResult() {
    }

    protected CommonResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> CommonResult<T> successData(T data) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回消息
     *
     * @param message 消息
     */
    public static <T> CommonResult<T> successMsg(String message) {
        return success(null,message);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     * @param  message 提示信息
     */
    public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     */
    public static <T> CommonResult<T> failed(IErrorCode errorCode) {
        return new CommonResult<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }
    /**
     * 失败返回结果
     * @param errorCode 错误码
     */
    public static <T> CommonResult<T> failed(IErrorCode errorCode,T date) {
        return new CommonResult<T>(errorCode.getCode(), errorCode.getMessage(), date);
    }
    /**
     * 失败返回结果和数据
     */
    public static <T> CommonResult<T> failedDate(IErrorCode errorCode,T date){
        return new CommonResult<T>(ResultCode.STOCK.getCode(), errorCode.getMessage(), date);
    }

    /**
     * 失败返回结果
     * @param message 提示信息
     */
    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<T>(ResultCode.FAILED.getCode(), message, null);
    }


    public static <T> CommonResult<T> gave(String message,T date){
        return new CommonResult<T>(ResultCode.GAVE.getCode(), message, date);
    }
    public static <T> CommonResult<T> failed(String message, int code) {
        return new CommonResult<T>(code, message, null);
    }

    /**
     * 失败返回结果
     */
    public static <T> CommonResult<T> failed() {
        return failed(ResultCode.FAILED);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> CommonResult<T> validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     * @param message 提示信息
     */
    public static <T> CommonResult<T> validateFailed(String message) {
        return new CommonResult<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> CommonResult<T> unauthorized(T data) {
        return new CommonResult<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> CommonResult<T> forbidden(T data) {
        return new CommonResult<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }

    /**
     *  第三方登陆,但是无绑定会员返回结果
     * @return
     */
    public static <T> CommonResult<T> thirdLogin(T data) {
        return new CommonResult<T>(ResultCode.THIRD_LOGIN.getCode(), ResultCode.THIRD_LOGIN.getMessage(), data);
    }


    public static <T> CommonResult<T> superLogin(T data) {
        return new CommonResult<T>(ResultCode.SUPER_ADMIN.getCode(), ResultCode.SUPER_ADMIN.getMessage(), data);
    }



    /**
     *
     * @return
     */

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
