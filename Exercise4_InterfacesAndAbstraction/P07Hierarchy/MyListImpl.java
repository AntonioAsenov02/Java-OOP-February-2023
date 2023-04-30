package Exercise4_InterfacesAndAbstraction.P07Hierarchy;

public class MyListImpl extends Collection implements MyList {
    @Override
    public String remove() {
        return super.items.remove(0);
    }

    @Override
    public int add(String item) {
        if (super.items.size() < super.maxSize) {
            super.items.add(0, item);
        }
        return 0;
    }

    @Override
    public int getUsed() {
        return super.items.size();
    }
}