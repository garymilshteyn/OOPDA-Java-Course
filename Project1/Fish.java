public class Fish extends Animal{
    public Fish(double weight, String name){
        super.name = name;
        super.weight = weight;
    }

    @Override
    public void Sound(){
        System.out.println("Gulp!, Gulp!!");
    }
    
    @Override
    public void Eat(){
        System.out.println("Eating Hikari Tropical Micro Pellets Fish Food");
    }
}
