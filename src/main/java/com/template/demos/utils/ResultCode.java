package com.template.demos.utils;

/**
 * 枚举了一些常用API操作码
 */
public enum ResultCode implements IErrorCode {
    /**
     * 操作成功
     */
    SUCCESS(200, "操作成功"),
    /**
     * 操作失败
     */
    FAILED(400, "操作失败"),
    /*
    * 授权
    * */
    GAVE(401,"授权"),

    STOCK(300, "数量超出剩余库存范围了"),
    /**
     * 参数校验
     */
    VALIDATE_FAILED(404, "参数检验失败"),
    /**
     * 登陆相关
     */
    UNAUTHORIZED(401, "暂未登录或身份信息已经过期"),
    /**
     * 权限相关
     */
    FORBIDDEN(403, "没有相关权限"),

    /**
     * 第三方登陆,未绑定会员账号
     */
    THIRD_LOGIN(250, "第三方登陆,未绑定会员账号"),

    /**
     * 超级管理员登陆. 选择商城id
     */
    SUPER_ADMIN(255,"超级管理员登陆,进入商城页面"),



    WECHAT_USER_INFO_NOT_EXISTS(410, "此微信用户没有绑定手机");
    /**
     *
     */
    private int code;
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {

        return message;
    }
}
