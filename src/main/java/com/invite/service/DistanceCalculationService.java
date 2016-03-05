package com.invite.service;

/**
 * Created by Amit
 */
public class DistanceCalculationService {

    /*
    Returns distance in KMs
    */
    public double distance(double latA, double latB, double lonA, double lonB) {

        final int radius = 6371; // Radius of the earth

        Double latDistance = Math.toRadians(latB - latA);
        Double lonDistance = Math.toRadians(lonB - lonA);
        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(latA)) * Math.cos(Math.toRadians(latB))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = radius * c;

        distance = Math.pow(distance, 2) + Math.pow(0, 2);

        return Math.sqrt(distance);
    }
}
