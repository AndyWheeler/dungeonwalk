package com.swashbuckler;

/**
 * Created by Andy on 11/24/15.
 */
public class Npc extends Creature {

    private String quote;

    public Npc(int x, int y) {
        super(x, y);
        this.quote = "I look like " + this.getIcon() + ".";
    }

    public Npc(int x, int y, char icon) {
        super(x, y, icon);
        this.quote = "I look like a " + icon + ".";
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
