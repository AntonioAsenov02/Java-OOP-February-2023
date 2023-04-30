package magicGame.models.region;

import magicGame.models.magicians.Magician;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class RegionImpl implements Region {

    @Override
    public String start(Collection<Magician> magicians) {
        List<Magician> wizardsList = magicians.stream()
                .filter(m -> m.getClass().getSimpleName().equals("Wizard"))
                .collect(Collectors.toList());

        List<Magician> blackWidowsList = magicians.stream()
                .filter(m -> m.getClass().getSimpleName().equals("BlackWidow"))
                .collect(Collectors.toList());

        while (!wizardsList.isEmpty() && !blackWidowsList.isEmpty()) {

            Magician wizard = wizardsList.get(0);
            Magician blackWidow = blackWidowsList.get(0);

            blackWidow.takeDamage(wizard.getMagic().fire());
            if (blackWidow.isAlive()) {

                wizard.takeDamage(blackWidow.getMagic().fire());
                if (!wizard.isAlive()) {
                    wizardsList.remove(wizard);
                }

            } else {
                blackWidowsList.remove(blackWidow);
            }
        }
        if (wizardsList.size() > blackWidowsList.size()) {
            return "Wizards win!";
        } else {
            return "Black widows win!";
        }
    }
}
