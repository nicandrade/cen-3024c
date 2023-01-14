/*
In a separate class, write an application to neatly output, with descriptive text:
    the area of two rectangles having sides (4, 5) and (5.7, 8.1) respectively
    use each Rectangle constructor once
    the area of two circles having radius 4.2 and 3 respectively
    use each Circle constructor once
 */


public class App {
    public static void main(String[] args) throws Exception {
        Rectangle rectangleOne = new Rectangle(4,5);
        Rectangle rectangleTwo = new Rectangle(5.7,8.1);
        Circle circleOne = new Circle(4.2);
        Circle circleTwo = new Circle(3);

        System.out.println(rectangleOne.toString());
        System.out.println(rectangleTwo.toString());
        System.out.println(circleOne.toString());
        System.out.println(circleTwo.toString());
    }

}

