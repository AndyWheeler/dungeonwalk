package com.swashbuckler;

/**
 * Created by Andy on 11/24/15.
 */
public class Player extends Creature {

    private String name;

    public Player(int x, int y, char icon) {
        super(x, y, icon);
        this.name = "Oh";
    }

    public Player(int x, int y, char icon, String name) {
        super(x, y, icon);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuote() {
        return "My name is " + this.name + ".";
    }

}
