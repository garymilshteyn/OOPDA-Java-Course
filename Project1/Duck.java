public class Duck extends Animal{
    public Duck(double weight, String name){
        super.name = name;
        super.weight = weight;
    }

    @Override
    public void Sound(){
        System.out.println("Quack!, Quack!!");
    }

    @Override
    public void Eat(){
        System.out.println("Eating Mazuri Waterfowl Layer duck food");
    }
}
