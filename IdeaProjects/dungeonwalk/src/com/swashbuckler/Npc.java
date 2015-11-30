package com.swashbuckler;

/**
 * Created by Andy on 11/24/15.
 */
public class Npc extends Character {

    private String quote;

    public Npc(int x, int y) {
        super(x, y);
        this.quote = "I am proud to be a " + this.getIcon() + ".";
    }

    public Npc(int x, int y, char icon) {
        super(x, y, icon);
        this.quote = "I am a proud " + icon + ".";
    }

    public Npc(int x, int y, char icon, String quote) {
        super(x, y, icon);
        this.quote = quote;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
