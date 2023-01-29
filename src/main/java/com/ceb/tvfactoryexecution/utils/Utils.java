package com.ceb.tvfactoryexecution.utils;

import lombok.experimental.UtilityClass;

import java.util.Random;

@UtilityClass
public class Utils {

    // Prices in EUR
    public static int TV_PRICE = 1;
    public static int ROBOT_PRICE = 3;

    // Times in Millisecond
    public static int ACTION_SWITCH_TIME = 5000;
    public static int PANEL_BUILDING_TIME = 1000;
    public static int MAIN_BOARD_BUILDING_TIME = new Random().nextInt(500, 2000);
    public static int ASSEMBLING_TIME = 2000;
    public static int SALES_TIME = 10000;
    public static int ROBOT_BUYING_TIME = 0;

    public static boolean isProductionEnd(int totalNumberOfRobots) {
        return totalNumberOfRobots > 29;
    }

    public String createRobotId(int number) {
        return "Robot-" + number;
    }
}
