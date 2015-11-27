package com.swashbuckler;

/**
 * Created by Andy on 11/23/15.
 */
import java.util.*;

public class Room {

    private int width;
    private int height;
    private List<Creature> creatures;
    private char[][] map;
    private int viewX = 7;
    private int viewY = 5;

    public Room(String mapText, int w, int h) {

        this.width = w;
        this.height = h;

        this.creatures = new ArrayList<Creature>();

        // convert mapText to a 2D array of chars
        this.map = new char[width][height];
        int i = 0;
        for (int k = 0; k < height; k++)
            for (int j = 0; j < width; j++) {
                this.map[j][k] = mapText.charAt(i);
                i++; }
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
        map[x][y] = newCreature.getIcon();
    }

    public void remove(Creature oldCreature) {
        this.creatures.remove(oldCreature);
        int x = oldCreature.getX();
        int y = oldCreature.getY();
        map[x][y] = ' ';
    }

    public String toString() {
        String mapText = "";
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                mapText += this.map[i][j]; }
            mapText += "\n"; }
        return mapText;
    }

    public String getView(Creature p) {
        return getView(p.getX(), p.getY());
    }

    public String getView(int x, int y) {
        String view = "";

        //choose edges as either edge of view or edge of map, whichever's closer
        int leftEdge = Math.max(0, (x-(this.viewX/2)));
        int topEdge = Math.max(0, (y-(this.viewY/2)));
        int rightEdge = Math.min(this.width, (x+(this.viewX/2)+1));
        int bottomEdge = Math.min(this.height, (y+(this.viewY/2)+1));

        for (int j = topEdge; j < bottomEdge; j++) {
            for (int i = leftEdge; i < rightEdge; i++) {
                view += this.map[i][j]; }
            view += "\n"; }

        return view;
    }

    public char tileAt(int x, int y){
        if ( 0 <= x && x < width && 0 <= y && y < height) {
            return map[x][y];
        }
        else return 0;
    }

    public Creature getCreatureAt(int x, int y) {
        for (Creature c : this.creatures) {
            if (c.getX() == x && c.getY() == y) {
                return c;
            }
        }
        return new Creature(x, y);
    }

}
