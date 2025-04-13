/**
 * This class represents a rectangle shape with a given length and width
 * 
 * @Gary Milshteyn
 * @2.15.25
 */
import java.util.Collections;
import java.util.LinkedList;
import java.util.*;
public class Rectangle extends Shape implements Comparable<Shape>{
    private double length;
    private double width;
    
    /**
     * Parametric constructor that initializes the rectangle's position, length, and width
     * 
     * @param x:        The x-coordiante of the bottom-left corner of the rectangle
     * @param y:        The y-coordinate of the bottom-left corner of the rectangle
     * @param length:   The length of the rectangle.
     * @param width:    The width of the rectangle.
     */
    public Rectangle(double x, double y, double length, double width) {
        super(x, y);
        this.length = length;
        this.width = width;
    }
    
    /**
     * Returns the length of the rectangle
     * 
     * @return The length of the rectangle
     */
    public double getLength() {
        return length;
    }
    
    /**
     * Sets the length of the rectangle
     * 
     * @param length:   The new length of the rectangle
     */
    public void setLength(double length){
        this.length = length;
    }
    
    /**
     * Returns the width of the rectangle
     * 
     * @return The width of the rectangle
     */
    public double getWidth(){
        return width;
    }
    
    /**
     * Sets the width of the rectangle
     * 
     * @param width:    The new width of the rectangle
     */
    public void setWidth(double weight){
        this.width = width;
    }
    
    /**
     * Computes the area of the rectangle
     * 
     * @return The area of the rectangle
     */
    @Override
    public double ComputeArea(){
        return length * width;
    }
    
    /**
     * Computes the perimeter of the rectangle
     * 
     * @reutrn The perimeter of the rectangle
     */
    @Override
    public double ComputePerimeter(){
        return 2 * (length + width);
    }
    
    /**
     * Returns the details of the rectangle
     */
    @Override
    public String toString(){
        return "Rectangle, length = " + getLength() + ", width = " + getWidth() + ", position: " + super.getX() + " " + super.getY() + ", Area = " + ComputeArea() + ", Perimeter = " + ComputePerimeter();
    }
}