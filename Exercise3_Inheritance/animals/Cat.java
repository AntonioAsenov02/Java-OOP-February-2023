package Exercise3_Inheritance.animals;

public class Cat extends Animal{
    final static String Sound = "Meow meow";
    public Cat(String name, int age, String gender) {
        super(name, age, gender);
    }
    @Override
    public String produceSound(){
        return Sound;
    }
}
