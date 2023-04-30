package Exercise3_Inheritance.animals;

public class Kitten extends Cat{
    final static String Sound = "Meow";
    final static String Gender = "Female";
    public Kitten(String name, int age) {
        super(name, age,Gender);
    }
    public String produceSound(){
        return Sound;
    }
}
