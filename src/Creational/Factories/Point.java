package Creational.Factories;

public class Point {
    public static void main(String[] args) {
        Cordinates cartesian = CordinatesFactory.cartesianFactory(4, 5);
        Cordinates polar = CordinatesFactory.polarFactory(4, 6);
    }
}

class CordinatesFactory {
    public static Cordinates cartesianFactory(double x, double y) {
        return new Cordinates(x, y); 
    }

    public static Cordinates polarFactory(double rho, double theta) {
        return new Cordinates(rho * Math.cos(theta), rho * Math.sin(theta)); 
    }
}


class Cordinates {
    private Double a;
    private Double b;
  
    public Cordinates(Double a, Double b) {
        this.a = a;
        this.b = b;
    }

    public Double getA() {
        return a;
    }

    public void setA(Double a) {
        this.a = a;
    }

    public Double getB() {
        return b;
    }

    public void setB(Double b) {
        this.b = b;
    }

    
}