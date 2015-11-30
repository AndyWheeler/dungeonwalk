package com.swashbuckler;

/**
 * Created by Andy on 11/23/15.
 */

import java.util.*;

public class Room {
    private List<Character> characters;
    private ArrayMap map;
    private final int viewX = 7;
    private final int viewY = 5;

    public Room(String mapText, int w, int h) {

        this.characters = new ArrayList<Character>();

        this.map = new ArrayMap(mapText, w, h);
    }

    public void shift(Character character, int newX, int newY) {
        this.map.clearTile(character.getX(), character.getY());
        this.map.placeTile(newX, newY, character.getIcon());
    }

    public void add(Character newCharacter) {
        this.characters.add(newCharacter);
        this.map.placeTile(newCharacter.getX(), newCharacter.getY(), newCharacter.getIcon());
    }

    public void remove(Character oldCharacter) {
        this.characters.remove(oldCharacter);
        int x = oldCharacter.getX();
        int y = oldCharacter.getY();
        this.map.clearTile(x, y);
    }

    public char tileAt(int x, int y) {
        return this.map.tileAt(x, y);
    }

    public Character characterAt(int x, int y) {
        for (Character c : this.characters) {
            if (c.getX() == x && c.getY() == y) {
                return c;
            }
        }
        return null;
    }

    public String toString() {
        return this.map.toString();
    }

    public String getView(Character p) {
        return getView(p.getX(), p.getY());
    }

    public String getView(int x, int y) {
        String view = "";

        //choose edges as either edge of view or edge of map, whichever's closer
        int leftEdge = Math.max(0, (x - (this.viewX / 2)));
        int topEdge = Math.max(0, (y - (this.viewY / 2)));
        int rightEdge = Math.min(this.map.getWidth(), (x + (this.viewX / 2) + 1));
        int bottomEdge = Math.min(this.map.getHeight(), (y + (this.viewY / 2) + 1));

        for (int j = topEdge; j < bottomEdge; j++) {
            for (int i = leftEdge; i < rightEdge; i++) {
                view += this.map.tileAt(i, j);
            }
            view += "\n";
        }

        return view;
    }
}
