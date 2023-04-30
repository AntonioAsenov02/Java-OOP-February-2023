package Exercise3_Inheritance.animals;

public class Dog extends Animal{
    final static String Sound = "Woof!";
    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }
    @Override
    public String produceSound(){
        return Sound;
    }
}
