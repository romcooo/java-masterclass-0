package com.romco.structural.bridge;

abstract class Shape2 {
    protected ThisRenderer thisRenderer;
    protected String name;

    
    public Shape2(ThisRenderer thisRenderer) {
        this.thisRenderer = thisRenderer;
    }
    
    public String toString() {
        String s = String.format("Drawing %s as %s", name, thisRenderer.whatToRenderAs());
        return s;
    }
}
interface ThisRenderer {
    public String whatToRenderAs();
}

class VectorRenderer2 implements ThisRenderer {
    @Override
    public String whatToRenderAs() {
        return "lines";
    }
}

class RasterRenderer2 implements ThisRenderer {
    @Override
    public String whatToRenderAs() {
        return "pixels";
    }
}

class Triangle extends Shape2
{
    public Triangle(ThisRenderer thisRenderer) {
        super(thisRenderer);
        name = "Triangle";
    }

}

class Square extends Shape2
{
    public Square(ThisRenderer thisRenderer) {
        super(thisRenderer);
        name = "Square";
    }
    

}

public class Challenge {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(new VectorRenderer2());
        Triangle triangle1 = new Triangle(new RasterRenderer2());
        
        Square square = new Square(new VectorRenderer2());
        Square square1 = new Square(new RasterRenderer2());
        
        System.out.println(triangle);
        System.out.println(triangle1);
        System.out.println(square);
        System.out.println(square1);
    }
}