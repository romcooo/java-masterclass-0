package com.romco.structural.adapter;

import java.util.ArrayList;

class Point {
    public int x, y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Line {
    public Point start, end;
    
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }
}

class VectorObject extends ArrayList<Line> {

}

class VectorRectangle extends VectorObject {
    public VectorRectangle(int x, int y, int width, int height) {
    
    }
}

public class AdapterDemo {
    
    public static void main(String[] args) {
    
    }
}
