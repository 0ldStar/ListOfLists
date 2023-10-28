package com.mycompany.app;

import java.util.Date;

public class GPS implements Comparable<GPS> {
    public GPS(double latitude, double longitude, Date timestamp) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.timestamp = timestamp;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public double distanceTo(GPS otherLocation) {
        double earthRadius = 6371; // Средний радиус Земли в километрах

        double lat1 = Math.toRadians(this.latitude);
        double lon1 = Math.toRadians(this.longitude);
        double lat2 = Math.toRadians(otherLocation.getLatitude());
        double lon2 = Math.toRadians(otherLocation.getLongitude());

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(lat1) * Math.cos(lat2)
                        * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return earthRadius * c;
    }

    @Override
    public int compareTo(GPS otherLocation) {
        return Double.compare(this.latitude, otherLocation.getLatitude());
    }

    @Override
    public String toString() {
        return "Latitude: " + latitude + ", Longitude: " + longitude + ", Timestamp: " + timestamp;
    }

    private double latitude; // Широта
    private double longitude; // Долгота
    private Date timestamp; // Отметка времени

}
