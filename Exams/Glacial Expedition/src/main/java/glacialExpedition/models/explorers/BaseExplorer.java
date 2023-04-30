package glacialExpedition.models.explorers;

import glacialExpedition.common.ConstantMessages;
import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.suitcases.Carton;
import glacialExpedition.models.suitcases.Suitcase;

import static glacialExpedition.common.ConstantMessages.*;

public abstract class BaseExplorer implements Explorer{
    private String name;
    private double energy;
    private Suitcase suitcase;

    public BaseExplorer(String name, double energy) {
        this.setName(name);
        this.setEnergy(energy);
        suitcase = new Carton();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.EXPLORER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setEnergy(double energy) {
        if (energy < 0){
            throw new IllegalArgumentException(ExceptionMessages.EXPLORER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getEnergy() {
        return this.energy;
    }

    @Override
    public boolean canSearch() {
        return energy > 0;
    }

    @Override
    public Suitcase getSuitcase() {
        return suitcase;
    }

    @Override
    public void search() {
        if (energy - 15 < 0){
            this.setEnergy(0);
        }else {
            this.setEnergy(energy - 15);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

            builder.append(String.format(FINAL_EXPLORER_NAME,getName()));
            builder.append(System.lineSeparator());
            builder.append(String.format(FINAL_EXPLORER_ENERGY,getEnergy()));
            builder.append(System.lineSeparator());
            if (getSuitcase().getExhibits().isEmpty()){

                builder.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS,"None"));
            }else {
                builder.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS,
                        String.join(FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER,getSuitcase().getExhibits())));
            }

            return builder.toString();
    }
}
