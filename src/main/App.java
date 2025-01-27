package main;

import config.Settings;
import config.Statistic;
import entity.island.Island;

public class App {
    public static void main(String[] args) {

        Island island = new Island(Settings.ROWS, Settings.COLUMNS);
        Statistic statistic = new Statistic(island);
        statistic.run();
//        CircleLife circleLife = new CircleLife(island);
//        circleLife.run();

        //island.start();

//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        // island.shutdown();
    }

}