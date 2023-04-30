package Exercise4_InterfacesAndAbstraction.P07Hierarchy;

public class AddRemoveCollection extends Collection implements AddRemovable{
    @Override
    public String remove() {

        return super.items.remove(items.size() - 1);
    }

    @Override
    public int add(String item) {
        if (super.items.size() < super.maxSize){
            super.items.add(0,item);
        }
        return 0;
    }
}
