/**
 * This class represents an abstract shape with a position in the x-y plane
 * 
 * @Gary Milshteyn
 * @3.10.25
 */

public abstract class Shape {
    private double x;   // x-coordinate of the shape's position
    private double y;   // y-coordinate of the shape's position
    
    /**
     * Parametric constructor that initializes the shape's position
     * 
     * @param x: The x-coordinate of the shape's position
     * @param y: The y-coordinate of the shape's position
     */
    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Returns the x-coordinate of the shape's position
     * 
     * @return The x-coordinate of the shape's position
     */
    public double getX() {
        return x;
    }
    
    /**
     * Returns the y-coordinate of the shape's position
     * 
     * @return The y-coordinate of the shape's position
     */
    public double getY() {
        return y;
    }
    
    /**
     * Sets the x-coordinate of the shape's position
     * 
     * @param x: The new x-coordinate of the shape's position
     */
    public void setX(double x) {
        this.x = x;
    }
    
    /**
     * Sets the y-coordinate of the shape's position
     * 
     * @param y: The new y-coordinate of the shape's position
     */
    public void setY(double y){
        this.y = y;
    }
    
    /**
     * Computes the area of the shape
     * 
     * @return The area of the shape
     */
    public abstract double ComputeArea();
    
    /**
     * Computes the perimeter of the shape
     * 
     * @return The perimeter of the shape
     */
    public abstract double ComputePerimeter();
}
