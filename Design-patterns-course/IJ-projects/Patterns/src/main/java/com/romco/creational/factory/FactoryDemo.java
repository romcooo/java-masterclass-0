package com.romco.creational.factory;

enum CoordinateSystem {
    CARTESIAN, POLAR;
}

class Point {
    private double x, y;
    
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    private Point(boolean q) {
        this(1, 2);
    }
    
//    public static Point newCartesianPoint(double x, double y) {
//        return new Point(x, y);
//    }
//
//    public static Point newPolarPoint(double rho, double theta) {
//        return new Point(rho*Math.cos(theta),
//                         rho*Math.sin(theta));
//    }
    
    public static class Factory {
        public static Point newCartesianPoint(double x, double y) {
            return new Point(x, y);
        }
        
        public static Point newPolarPoint(double rho, double theta) {
            return new Point(rho*Math.cos(theta),
                             rho*Math.sin(theta));
        }
    }
}

class PointFactory {
    public static Point newCartesianPoint(double x, double y) {
        return new Point(x, y);
    }
    
    public static Point newPolarPoint(double rho, double theta) {
        return new Point(rho*Math.cos(theta),
                         rho*Math.sin(theta));
    }
}

public class FactoryDemo {
    public static void main(String[] args) {
        Point point = Point.Factory.newCartesianPoint(1, 2); //this way, constructor can remain private
        Point point2 = PointFactory.newCartesianPoint(3, 4); //here it needs to be at least package-private
    }
}
