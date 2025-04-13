/**
 * This class represents an abstract shape with a position in the x-y plane
 * 
 * @Gary Milshteyn
 * @2.15.25
 */

public abstract class Shape implements Comparable<Shape> {
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
    
    /**
     * Compares this shape with another shape based on their areas.
     *
     * @param other:    The other sbale to compare with.
     * @return A negative integer if this shape's area is less than the other shape's area,
     * zero if the areas are equal, or a positive integer if this shape's area is greater.
     */
    @Override
    public int compareTo(Shape other){
        if (this.ComputeArea() < other.ComputeArea())
            return -1;      //This shape is smaller
        else if (this.ComputeArea() > other.ComputeArea())
            return 1;       //This shape is larger
        else
            return 0; 
    }
}
