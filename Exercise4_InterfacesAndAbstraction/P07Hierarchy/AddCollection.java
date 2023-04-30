package Exercise4_InterfacesAndAbstraction.P07Hierarchy;

public class AddCollection extends Collection implements Addable{

    @Override
    public int add(String item) {
        if (super.items.size() < super.maxSize){
            super.items.add(item);
        }
        return items.size() - 1;
    }
}
