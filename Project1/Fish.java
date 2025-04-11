public class Fish extends Animal{
    public Fish(double weight, String name){
        super.name = name;
        super.weight = weight;
    }

    public void Sound(){
        System.out.println("Gulp!, Gulp!!");
    }
    public void Eat(){
        System.out.println("Eating Hikari Tropical Micro Pellets Fish Food");
    }
}
