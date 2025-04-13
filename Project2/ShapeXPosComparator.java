/**
 * This class compares shapes based on their x-position
 * 
 * @Gary Milshteyn
 * @2.15.25
 */
import java.util.Comparator;
public class ShapeXPosComparator implements Comparator<Shape> {
    
    /**
     * Compares two shapes based on their x-position
     * 
     * @param s1:   The first shape
     * @param s2:   The second shape.
     * @return A negative integer if the first shape's x-position is less than the second's, zero if they are equal, or positive if it's greater
     */
    @Override
    public int compare(Shape s1, Shape s2){
        return Double.compare(s1.getX(), s2.getX());
    }
}