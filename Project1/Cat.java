public class Cat extends Animal{
    public Cat(double weight, String name){
        super.name = name;
        super.weight = weight;
    }

    @Override
    public void Sound(){
        System.out.println("Meow!, Meow!!");
    }

    @Override
    public void Eat(){
        System.out.println("Eating Friskies Seafood Sensations cat food");
    }
}
