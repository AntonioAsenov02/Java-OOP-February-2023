package Exercise4_InterfacesAndAbstraction.P07Hierarchy;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {
    protected int maxSize;
    protected List<String> items;

    public Collection() {
        this.maxSize = 100;
        items = new ArrayList<>();
    }
}
