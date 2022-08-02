package com.labs.designpattern.chain;

/**
 * 处理接口
 *
 * @author tanyun.zheng
 */
public interface Handler {
    /**
     * 请求处理
     *
     * @param number
     */
    void handleRequest(String number);

    /**
     * 下一个处理器
     *
     * @param handler
     */
    void setNextHandler(Handler handler);
}
