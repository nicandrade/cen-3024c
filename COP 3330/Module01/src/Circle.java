/* 
Create a class named Circle. This class should contain at minimum:
    a field for radius
    setters and getters for the field(s)
    a constructor that accepts radius as a parameter
    an overloaded 0-arg constructor that sets field values to 0
    a method named computeArea that accepts no parameters and returns the area
*/

public class Circle {
    
    // Fields for Radius
    private double radius;

    // Setter
    public void setRadius(double setRadiusValue) {
        radius = setRadiusValue;
    }

    // Getter
    public double getRadius() {
        return radius;
    }

    // Constructor
    public Circle(double radiusValue) {
        radius = radiusValue;
    }

    // Overloaded Constructor
    public Circle() {
        radius = 0;
    }

    // Methods
    public double computeArea(){
        double result;
        result=Math.PI*radius*radius;
        return result;
    }

    public String toString() {
        String result;
        result = "Circle with radius " + radius + " has area " + computeArea();
        return result;
    }
}
