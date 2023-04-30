package magicGame.models.magicians;

import magicGame.common.ExceptionMessages;
import magicGame.models.magics.Magic;

public abstract class MagicianImpl implements Magician {
    private String username;
    private int health;
    private int protection;
    private boolean isAlive;
    private Magic magic;

    protected MagicianImpl(String username, int health, int protection, Magic magic) {
        this.setUsername(username);
        this.setHealth(health);
        this.setProtection(protection);
        this.isAlive = true;
        this.setMagic(magic);
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    private void setUsername(String username) {
        if (username == null || username.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.INVALID_MAGICIAN_NAME);
        }
        this.username = username;
    }

    private void setHealth(int health) {
        if (health < 0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_HEALTH);
        }
        this.health = health;
    }

    private void setProtection(int protection) {
        if (protection < 0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_PROTECTION);
        }
        this.protection = protection;
    }

    private void setMagic(Magic magic) {
        if (magic == null){
            throw new NullPointerException(ExceptionMessages.INVALID_MAGIC);
        }
        this.magic = magic;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getProtection() {
        return this.protection;
    }

    @Override
    public Magic getMagic() {
        return this.magic;
    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }

    @Override
    public void takeDamage(int points) {
        this.protection -= points;
        if (protection < 0){
            health += this.protection;
        }

        if (health <= 0){
            isAlive = false;
        }
    }
}
