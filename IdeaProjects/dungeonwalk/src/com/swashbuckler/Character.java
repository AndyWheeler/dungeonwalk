package com.swashbuckler;

/**
 * Created by Andy on 11/24/15.
 */
abstract class Character {

    private int x;
    private int y;
    private char icon;

    public Character(int x, int y) {
        this.x = x;
        this.y = y;
        //no icon provided; generate random number, letter or symbol
        this.randomizeIcon();
    }

    public Character(int x, int y, char icon) {
        this.x = x;
        this.y = y;
        if (icon >= 33 && icon <= 126 && icon != 35) {
            this.icon = icon;
        } else {
            this.randomizeIcon();
        }
    }

    private void randomizeIcon() {
        this.icon = (char) ((int) (36 + Math.random() * 90));
    }

    public int getX() {
        return x;
    }

    private void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    private void setY(int y) {
        this.y = y;
    }

    public void move(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public char getIcon() {
        return icon;
    }

    public String getQuote() {
        return "";
    }

}
