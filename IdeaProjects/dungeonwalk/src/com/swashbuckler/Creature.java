package com.swashbuckler;

/**
 * Created by Andy on 11/24/15.
 */
public class Creature {

    private int x;
    private int y;
    private char icon;

    public Creature(int x, int y) {
        this.x = x;
        this.y = y;
        //no icon provided; generate random number, letter or symbol
        this.setRandomIcon();
    }
    public Creature(int x, int y, char icon) {
        this.x = x;
        this.y = y;
        if (icon >= 33 && icon <= 126 && icon != 35) {
            this.icon = icon;
        } else {
            this.setRandomIcon();
        }
    }

    private void setRandomIcon() {
        this.icon = (char) ( (int)(36+Math.random()*90) );
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void move(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public char getIcon() {
        return icon;
    }

    public void setIcon(char icon) {
        if ((int)icon >= 36 && icon <= 126) {
            this.icon = icon;
        }
    }

    public String getQuote(){
        return "";
    }

}
