package com.blockchain.exchange;

/**
 * @author zhangxu
 * @date 2020/7/9 16:41
 * @description
 */
public interface Player {
    /**
     *  用户名。
     */
    String getUsername();

    /**
     * 向玩家发送消息。
     */
    void write(String message);


    /**
     * 玩家是否掉线。
     */
    boolean isOffline();
}
