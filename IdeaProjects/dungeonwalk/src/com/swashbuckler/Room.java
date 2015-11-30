package com.swashbuckler;

/**
 * Created by Andy on 11/23/15.
 */

import java.util.*;

public class Room {
    private List<Creature> creatures;
    private ArrayMap map;
    private int viewX = 7;
    private int viewY = 5;

    public Room(String mapText, int w, int h) {

        this.creatures = new ArrayList<Creature>();

        this.map = new ArrayMap(mapText, w, h);
    }

    public void move(Creature creature, int newX, int newY) {
        this.remove(creature);
        creature.move(newX, newY);
        this.add(creature);
    }

    public void add(Creature newCreature) {
        this.creatures.add(newCreature);
        int x = newCreature.getX();
        int y = newCreature.getY();
        this.map.placeTile(x, y, newCreature.getIcon());
    }

    public void remove(Creature oldCreature) {
        this.creatures.remove(oldCreature);
        int x = oldCreature.getX();
        int y = oldCreature.getY();
        this.map.clearTile(x, y);
    }

    public char tileAt(int x, int y) {
        return this.map.tileAt(x, y);
    }


    public String toString() {
        return this.map.toString();
    }

    public String getView(Creature p) {
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

    public Creature getCreatureAt(int x, int y) {
        for (Creature c : this.creatures) {
            if (c.getX() == x && c.getY() == y) {
                return c;
            }
        }
        return null;
    }
}
