/**
 * Interface that has a method that executes a function using the providied message
 * 
 * @author Gary Milshteyn
 * @version 3.10.25
 */

import java.util.function.*;
@FunctionalInterface
public interface MyFunctionalInterface{
    void execute(String message);
}
