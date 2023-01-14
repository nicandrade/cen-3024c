/* 
Create a class named Rectangle. This class should contain at minimum:
    fields for length and width
    setters and getters for the fields
    a constructor that accepts length and width as parameters
    an overloaded 0-arg constructor that sets field values to 0
    a method named computeArea that accepts no parameters and returns the area
*/

public class Rectangle {

    // Fields for Length and Width
    private double length;
    private double width;

    // Setter
    public void setLength(double setLengthValue) {
        length = setLengthValue;
    }

    public void setWidth(double setWidthValue) {
        length = setWidthValue;
    }

    // Getter
    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    // Constructor
    public Rectangle(double lengthValue, double widthValue) {
        length = lengthValue;
        width = widthValue;
    }

    // Overloaded Constructor
    public Rectangle() {
        length = 0;
        width = 0;
    }

    // Methods
    public double computeArea() {
        double result;
        result = length * width;
        return result;
    }

    public String toString() {
        String result;
        result = "Rectangle with sides " + length + " and " + width + " has area " + computeArea();
        return result;
    }
}
