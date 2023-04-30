package Lab3_Inheritance.P03RandomArrayList;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class RandomArrayList<T> extends ArrayList<T> {

    public Object getRandomElement(){
       int index = ThreadLocalRandom.current().nextInt(0,super.size());
       return super.get(index);
    }
}
