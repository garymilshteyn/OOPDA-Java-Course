public class Dog extends Animal{
    public Dog(double weight, String name){
        super.name = name;
        super.weight = weight;
    }

    public void Sound(){
        System.out.println("Bark!, Bark!!");
    }
    public void Eat(){
        System.out.println("Eating Purina Pro Plan High Protein Dog Food");
    }
}
