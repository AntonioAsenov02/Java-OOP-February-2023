package football.entities.field;

import football.common.ConstantMessages;
import football.common.ExceptionMessages;
import football.entities.player.Player;
import football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseField implements Field {
    private String name;
    private int capacity;
    Collection<Supplement> supplements;
    Collection<Player> players;

    protected BaseField(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.supplements = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    @Override
    public int sumEnergy() {
        return supplements.stream().mapToInt(Supplement::getEnergy).sum();
    }

    @Override
    public void addPlayer(Player player) {
        if (players.size() < capacity){
            players.add(player);
        }else {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY);
        }
    }

    @Override
    public void removePlayer(Player player) {
        players.remove(player);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        supplements.add(supplement);
    }

    @Override
    public void drag() {
        for (Player player : players) {
            player.stimulation();
        }
    }

    @Override
    public String getInfo() {
        StringBuilder builder = new StringBuilder();

        builder.append(String.format("%s (%s):",this.name,getClass().getSimpleName()));
        builder.append(System.lineSeparator());
        if (players.isEmpty()){
            builder.append("Player: none").append(System.lineSeparator());
        }else {
            builder.append(players.stream().map(Player::getName).collect(Collectors.joining(" ")));
            builder.append(System.lineSeparator());
        }

        builder.append(String.format("Supplements: %d",supplements.size())).append(System.lineSeparator());
        builder.append(String.format("Energy: %d",this.sumEnergy())).append(System.lineSeparator());

        return builder.toString().trim();
    }

    @Override
    public Collection<Player> getPlayers() {
        return this.players;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return this.supplements;
    }

    @Override
    public String getName() {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY);
        }
        return this.name;
    }
}
