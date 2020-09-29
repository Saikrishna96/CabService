package com.example.UberService.HelperUtils;

import com.example.UberService.model.Location;

public class DistanceCalculator {

    public static int calculateDistance(Location l1, Location l2) {
        if (l1 != null && l2 != null) {
            int xDiff = Math.abs(l1.getX() - l2.getX());
            int xSquareSum = xDiff * xDiff;

            int yDiff = Math.abs(l1.getY() - l2.getY());
            int ySquareSum = yDiff * yDiff;
            System.out.println("distance : " + xSquareSum + ySquareSum);
            return xSquareSum + ySquareSum;

        }
        return Integer.MAX_VALUE;
    }
}
