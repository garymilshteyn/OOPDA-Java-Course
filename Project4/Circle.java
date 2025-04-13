/**
 * This class represents a circle shape with a given radius
 * 
 * @Gary Milshteyn
 * @3.10.25
 */
public class Circle extends Shape{
    private double radius;
    
    /**
     * Parametric constructor that initializes the circle's position and radius
     * 
     * @param x:        The x-coordinate of the circle's center
     * @param y:        The y-coordiante of the circle's center
     * @param radius:   The radius of the new circle
     */
    public Circle(double x, double y, double radius){
        super(x, y);
        this.radius = radius;
    }
    
    /**
     * Returns the radius of the circle
     * 
     * @return The radius of the circle
     */
    public double getRadius(){
        return radius;
    }
    
    /**
     * Sets the radius of the circle
     * 
     * @param radius:   The new radius of the circle
     */
    public void setRadius(double radius){
        this.radius = radius;
    }
    
    /**
     * Computes the area of the circle
     * 
     * @return The area of the circle.
     */
    @Override
    public double ComputeArea(){
        return Math.PI * radius * radius;
    }
    
    /**
     * Computes the circumference of the circle.
     * 
     * @reutrn The circumference of the circle
     */
    @Override
    public double ComputePerimeter(){
        return 2 * Math.PI * radius;
    }
    
    /**
     * Returns the details of the circle
     */
    @Override
    public String toString(){
        return "Circle, radius = " + getRadius() + ", position: " + super.getX() + " " + super.getY() + ", Area = " + ComputeArea() + ", Perimeter = " + ComputePerimeter();
    }
}