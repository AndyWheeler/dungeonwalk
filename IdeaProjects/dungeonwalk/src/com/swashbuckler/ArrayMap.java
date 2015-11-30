package com.swashbuckler;

/**
 * Created by Andy on 11/30/15.
 */
class ArrayMap {
    private char[][] map;
    private final int width;
    private final int height;

    public ArrayMap(String textMap, int width, int height) {
        this.width = width;
        this.height = height;
        this.map = new char[width][height];
        int i = 0;
        for (int k = 0; k < height; k++) {
            for (int j = 0; j < width; j++) {
                this.map[j][k] = textMap.charAt(i);
                i++;
            }
        }
    }

    public void placeTile(int x, int y, char tileFace) {
        if (x < this.map.length && y < this.map[0].length) {
            this.map[x][y] = tileFace;
        }
    }

    public void clearTile(int x, int y) {
        if (x < this.map.length && y < this.map[0].length) {
            this.map[x][y] = ' ';
        }
    }

    public char tileAt(int x, int y) {
        if (0 <= x && x < width && 0 <= y && y < height) {
            return this.map[x][y];
        }
        return 0;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String toString() {
        String mapText = "";
        for (int j = 0; j < this.height; j++) {
            for (int i = 0; i < this.width; i++) {
                mapText += this.tileAt(i, j);
            }
            mapText += "\n";
        }
        return mapText;
    }

}