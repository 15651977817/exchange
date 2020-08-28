package com.blockchain.exchange;

import java.util.stream.IntStream;

/**
 * @author zhangxu
 * @date 2020/7/9 17:07
 * @description
 */
public class Test {

    public static void main(String[] args) {
        PlayerManager playerManager = new PlayerManagerImpl();
        IntStream.range(0, 100).forEach(value -> {
            boolean flag = true;
            if (value % 2 == 0) {
                flag = false;
            }
            Player player = new PlayerImpl(String.valueOf(value), flag);
            System.out.println(player);
            playerManager.addPlayer(player);
            System.out.println(playerManager.getPlayer(String.valueOf(value)));
        });
    }
}
