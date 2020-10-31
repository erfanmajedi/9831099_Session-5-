package com.company;



import java.text.DecimalFormat;
import java.util.Objects;
import java.util.ArrayList;

/**
 * A code that we want to show how we calculate the area , perimeter and do another things for shapes.
 * @author Erfan Majedi
 * @since 2020.28.10
 */
class Paint{
    //An ArrayList of rectangles
    private ArrayList<Rectangle> rectangle;
    //An ArrayList of triangles
    private ArrayList<Triangle> triangle;
    //An ArrayList of circles
    private ArrayList<Circle> circle;

    public Paint()
    {
        rectangle=new ArrayList<Rectangle>();
        triangle = new ArrayList<Triangle>();
        circle = new ArrayList<Circle>();
    }
    /**
     * add rectangles to its arraylist
     * @param rec
     */
    public void addRectangle(Rectangle rec)
    {
        rectangle = new ArrayList<>();
        rectangle.add(rec);
    }

    /**
     * add triangles to its arraylist
     * @param tri
     */
    public void addTriangle(Triangle tri)
    {
        triangle = new ArrayList<>();
        triangle.add(tri);
    }

    /**
     * add circles to its arraylist
     * @param cir
     */
    public void addCircle(Circle cir)
    {
        circle = new ArrayList<>();
        circle.add(cir);
    }

    /**
     * show all of the arraylists
     */
    public void drawAll()
    {
        for(Rectangle rec : rectangle)
        {
            rec.draw();
        }
        for(Triangle tri : triangle)
        {
           tri.draw();
        }
        for(Circle cir : circle)
        {
            cir.draw();
        }
    }

    /**
     * print all the arraylists base on their tostring() methods
     */
    public void printAll()
    {
        for(Rectangle rec: rectangle)
        {
            System.out.println(rec.toString());
            System.out.println();
        }
        for(Triangle tri : triangle)
        {
            System.out.println(tri.toString());
            System.out.println();
        }
        for(Circle cir : circle)
        {
            System.out.println(cir.toString());
            System.out.println();
        }
    }

}
    class Rectangle{
    // ArrayList of sides
    private ArrayList<Integer> sides;

        /**
         * constructor of rectangle class
         * @param s1
         * @param s2
         * @param s3
         * @param s4
         */
    public Rectangle(int s1 , int s2 , int s3 , int s4)
    {
        sides= new ArrayList<Integer>();
        sides.add(s1);
        sides.add(s2);
        sides.add(s3);
        sides.add(s4);
    }

        /**
         * getter for sides
         * @return sides
         */
    public ArrayList<Integer> getSides()
    {
        return sides;
    }

        /**
         * check if the numbers are match with being a square or not
         * @return false if it's not square and true if it is
         */
    public boolean isSquare()
    {
        if (sides.get(0) == sides.get(1) && sides.get(0) == sides.get(3))
            return true;
        else
            return false;
    }

        /**
         * calculate the perimeter of rectangle
         * @return
         */
    public double calculatePerimeter()
    {
        double perimeter=0;
        for(int i=0;i<sides.size();i++)
        {
            if(!isSquare())
            {
                perimeter += sides.get(i);
            }
            if(isSquare())
            {
                perimeter  = 4 * sides.get(i);
            }
        }
        return perimeter;
    }

        /**
         * calculate area of rectangle
         * @return area
         */
    public double calculateArea()
    {
        double area=0;
        for(int i=0 ; i<sides.size();i++)
        {
            if(!isSquare())
            {
                area+= sides.get(i)*sides.get(i+1);
            }
            if(isSquare())
            {
                area=sides.get(i)*sides.get(i);
            }
        }
        return area;
    }

        /**
         * show the states of the rectangle or a square
         */
    public void draw()
    {
        System.out.println();
        System.out.println("The shape is a Rectangle. ");
        System.out.println("--------------------------");
        System.out.println("Perimeter : " + calculatePerimeter());
        System.out.println("Area : " + calculateArea());
        System.out.println("is Square : " + isSquare());
        System.out.println();
    }

        /**
         * equals method that check if its a rectangle or not
         * @param o
         * @return
         */
    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (!(o instanceof Rectangle))
            return false;
        Rectangle that = (Rectangle) o;
        return Objects.equals(sides, that.sides);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sides);
    }

        /**
         * we use it to show the sides of the rectangle
         * @return the sides of rectangle
         */
    @Override
    public String toString()
    {
        return "Rectangle - sides : side1 =" + sides.get(0) + " |side2 = " + sides.get(1) + " |side3 = " + sides.get(2) + " |side4 = " + sides.get(3);
    }
}
    class Triangle{
        private static DecimalFormat df2 = new DecimalFormat("#.##");
    // ArrayList of sides
    private ArrayList<Integer> sides;

        /**
         * constructor for triangle class
         * @param side1
         * @param side2
         * @param side3
         */
    public Triangle(int side1, int side2 , int side3)
    {
        sides= new ArrayList<>();
        sides .add(side1);
        sides .add(side2);
        sides .add(side3);
    }

        /**
         * getter for sides
         * @return sides
         */
    public ArrayList getSides()
    {
        return sides;
    }

        /**
         * check if all the three sides are equal or not
         * @return true if three sides are equal and false if it's not
         */
    public boolean isEquilateral()
    {
        if(sides.get(0) == sides.get(1) && sides.get(0) == sides.get(2))
            return true;

        return false;
    }

        /**
         * calculate triangle's perimeter
         * @return the perimeter
         */
    public double calculatePerimeter()
    {
        double perimeter=0;
        for(int i=0;i<sides.size();i++)
            perimeter += sides.get(i);
        return perimeter;
    }

        /**
         * calculate triangle's area
         * @return
         */
    public double calculateArea()
    {
        double p = calculatePerimeter() / 2;
        return Math.sqrt(p * (p - sides.get(0)) * (p - sides.get(1)) * (p - sides.get(2)));
    }

        /**
         * show the states of triangle
         */
    public void draw()
    {
        System.out.println();
        System.out.println("The shape is a Triangle. ");
        System.out.println("-------------------------");
        System.out.println("Perimeter : " + calculatePerimeter());
        System.out.println("Area : " + df2.format(calculateArea()));
        System.out.println("is Equilateral : " + isEquilateral());
        System.out.println();
    }
    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(sides, triangle.sides);
    }
    @Override
    public String toString() {
        return "Triangle - sides : side 1 = " + sides.get(0) + " | side 2= " + sides.get(1) + " | side 3 = " + sides.get(2);
    }
    @Override
    public int hashCode() {
        return Objects.hash(sides);
    }
}
    class Circle{
        private static final DecimalFormat df2 = new DecimalFormat("#.##");
    // field for circle's radius
        private double radius;

        /**
         * constructor for circle class
         * @param radius
         */
        public Circle(double radius)
        {
            this.radius=radius;
        }

        /**
         * getter for radius
         * @return radius
         */
        public double getRadius()
        {
            return radius;
        }

        /**
         * calculate perimeter for circle using its radius
         * @return perimeter
         */
        public double calculatePerimeter()
        {
            double perimeter=0;
            perimeter=2*3.14*radius;
            return perimeter;
        }

        /**
         * calculate area for circle using its radius
         * @return area
         */
        public double calculateArea()
        {
            double area=0;
            area=3.14*radius*radius;
            return area;
        }

        /**
         * show states of the circle
         */
        public void draw()
        {
            System.out.println();
            System.out.println("The shape is a Circle ");
            System.out.println("-------------------------");
            System.out.println("Perimeter : " + calculatePerimeter());
            System.out.println("Area : " + df2.format(calculateArea()));
            System.out.println();
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Circle circle = (Circle) o;
            return Double.compare(circle.radius, radius) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(radius);
        }

        @Override
        public String toString() {
            return  "Circle - radius : " +radius;
        }
    }

public class Main {

    public static void main(String[] args) {
        Circle circle1 = new Circle(19);
        Circle circle2 = new Circle(3);

        //3 instances for Rectangle class.
        Rectangle rect1 = new Rectangle(1, 4, 1, 4);
        Rectangle rect2 = new Rectangle(8, 5, 8, 5);
        Rectangle rect3 = new Rectangle(6, 6, 6, 6);

        //2 instances for Triangle class.
        Triangle tri1 = new Triangle(2, 2, 2);
        Triangle tri2 = new Triangle(4, 4, 6);

        //instance of Paint class.
        Paint paint = new Paint();

        //add circles.
        paint.addCircle(circle1);
        paint.addCircle(circle2);

        //add rectangles.
        paint.addRectangle(rect1);
        paint.addRectangle(rect2);
        paint.addRectangle(rect3);

        //add triangles.
        paint.addTriangle(tri1);
        paint.addTriangle(tri2);

        //draw shapes.
        paint.drawAll();
        paint.printAll();

        //check equals and hashcode methods.
        System.out.println();
        Rectangle rectangle1 = new Rectangle(2,5,2,5);
        Rectangle rectangle2 = new Rectangle(2,5,2,5);
        System.out.println("Check equals for two Rectangles : "+rectangle1.equals(rectangle2));

        System.out.println();
        Triangle triangle1 =new Triangle(2,5,6);
        Triangle triangle2 =new Triangle(2,5,6);
        System.out.println("Check equals for two Triangles : "+triangle1.equals(triangle2));
    }

}
