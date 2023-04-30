package Exercise3_Inheritance.animals;

public class Frog extends Animal{
    final static String Sound = "Ribbit";
    public Frog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound(){
        return Sound;
    }
}
