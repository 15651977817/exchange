package com.blockchain.exchange;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.MINUTES;

/**
 * @author zhangxu
 * @date 2020/7/9 16:50
 * @description
 */
public class PlayerManagerImpl implements PlayerManager {

    private Map<String, Player> stringMap = new ConcurrentHashMap<>();

    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);

    @Override
    public void addPlayer(Player player) {
        if (getPlayer(player.getUsername()) != null) {
            return;
        }
        stringMap.put(player.getUsername(), player);
        HearTeatTask hearTeatTask = new HearTeatTask(player);
        executorService.scheduleAtFixedRate(hearTeatTask, 1, 1, MINUTES);
    }

    @Override
    public Player getPlayer(String username) {
        return stringMap.get(username);
    }

    @Override
    public void broadcast(String message) {
        stringMap.forEach((username, player) -> {
            player.write(message);
        });
    }

    class HearTeatTask extends Thread {

        private Player player;

        public HearTeatTask(Player player) {
            this.player = player;
        }

        @Override
        public void run() {
            if (player.isOffline()) {
                stringMap.remove(player.getUsername());
                this.interrupt();
                System.out.println("#### 程序结束 ####");
            }
        }
    }
}
