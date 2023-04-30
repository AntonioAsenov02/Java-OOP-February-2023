package Exercise3_Inheritance.animals;

public class Tomcat extends Cat{
    final static String Sound = "MEOW";
    final static String Gender = "Male";
    public Tomcat(String name, int age) {
        super(name, age, Gender);
    }
    public String produceSound(){
        return Sound;
    }
}
