package com.swashbuckler;

/**
 * Created by Andy on 11/24/15.
 */
public class Player extends Character {

    private String name;
    private Room currentRoom;

    public Player(int x, int y, char icon, Room r) {
        super(x, y, icon);
        this.currentRoom = r;
        this.name = "Oh";
    }

    public Player(int x, int y, char icon, Room r, String name) {
        super(x, y, icon);
        this.currentRoom = r;
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

    public void move(int x, int y) {
        this.currentRoom.shift(this, x, y);
        super.move(x, y);
    }

}
