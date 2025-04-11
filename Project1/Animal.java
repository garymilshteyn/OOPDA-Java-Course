/**
 * Animal Superclass that takes the parameters for all animals' name and weight
 * 
 * @author Gary Milshteyn
 * @version 2/3/2025
 */

public abstract class Animal {
    public String name;
    public double weight;

    /**
     * A method that returns the name of the animal.
     * @return
     *  The name of the animal
     */
    public String getName(){
        return this.name;
    }

    /**
     * A method that returns the weight of the animal
     * @return
     *  The weight of the animal
     */
    public double getWeight(){
        return this.weight;
    }

    /**
     * A method that changes the weight of the animal
     * @param weight
     *  The number that is going to be stored in the weight
     */
    public void setWeight(double weight){
        this.weight = weight;
    }

    /**
     * An abstract method that prints out what a certain animal Eats, depending on the subclass
     */
    public abstract void Eat();
    
    /**
     * An abstract method that prints out the sound a certain animal makes, depending on the subclass.
     */
    public abstract void Sound();

}
