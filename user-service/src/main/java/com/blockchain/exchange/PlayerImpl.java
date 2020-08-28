package com.blockchain.exchange;

/**
 * @author zhangxu
 * @date 2020/7/9 16:49
 * @description
 */
public class PlayerImpl implements Player {

    private String username;

    private boolean isOffline;

    public PlayerImpl() {
    }

    public PlayerImpl(String username, boolean isOffline) {
        this.username = username;
        this.isOffline = isOffline;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void write(String message) {
        System.out.println(message);
    }

    @Override
    public boolean isOffline() {
        return isOffline;
    }

    @Override
    public String toString() {
        return "PlayerImpl{" +
                "username='" + username + '\'' +
                ", isOffline=" + isOffline +
                '}';
    }
}
