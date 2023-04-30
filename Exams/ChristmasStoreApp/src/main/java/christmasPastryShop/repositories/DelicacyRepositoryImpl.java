package christmasPastryShop.repositories;

import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

import java.util.ArrayList;
import java.util.Collection;

public class DelicacyRepositoryImpl implements DelicacyRepository<Delicacy> {

    private Collection<Delicacy> models;

    public DelicacyRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public Delicacy getByName(String name) {
        return models.stream()
                .filter(m -> m.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Delicacy> getAll() {
        return this.models;
    }

    @Override
    public void add(Delicacy delicacy) {
        this.models.add(delicacy);
    }
}
