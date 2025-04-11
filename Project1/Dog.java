public class Dog extends Animal{
    public Dog(double weight, String name){
        super.name = name;
        super.weight = weight;
    }

    @Override
    public void Sound(){
        System.out.println("Bark!, Bark!!");
    }

    @Override
    public void Eat(){
        System.out.println("Eating Purina Pro Plan High Protein Dog Food");
    }
}
