import java.util.Comparator;

public class ShapePerimeterComparator implements Comparator<Shape>{
    
    @Override
    public int compare(Shape s1, Shape s2){
        if (s1.ComputePerimeter() < s2.ComputePerimeter())
            return -1;
        else if (s1.ComputePerimeter() > s2.ComputePerimeter())
            return 1;
        else
            return 0;
    }
}