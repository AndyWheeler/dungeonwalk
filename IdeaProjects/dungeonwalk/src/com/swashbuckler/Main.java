package com.swashbuckler;

import java.util.*;


public class Main {

    private static final String map =
            "##########" +
            "#    #   #" +
            "#    # # #" +
            "#  #   # #" +
            "#  #   # #" +
            "#      # #" +
            "######## #" +
            "#        #" +
            "#        #" +
            "##########";

    private static final int width = 10;
    private static final int height = 10;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Use aswd to move. q to quit.");
        System.out.println("One letter at a time.");
        System.out.println("Walk into someone to chat.");
        System.out.print("Ready?");
        sc.nextLine();
        System.out.println("Enjoy your dungeon walk.");
        System.out.println();

        //initialize our room and fill with characters
        Room cavernOne = new Room(map, width, height);

        Character playerOne = new Player(2, 3, '@', cavernOne);
        Character npcOne = new Npc(1, 1, 'b', "Seek the %!");
        Character npcTwo = new Npc(6, 5);
        Character npcThree = new Npc(1, 7, '%', "Congrats. You found me.");

        cavernOne.add(playerOne);
        cavernOne.add(npcOne);
        cavernOne.add(npcTwo);
        cavernOne.add(npcThree);

        //initialize display/input loop
        String display;
        int targetX;
        int targetY;

        System.out.println(cavernOne.getView(playerOne));

        while (sc.hasNextLine()) {

            targetX = playerOne.getX();
            targetY = playerOne.getY();
            display = "";

            String input = sc.nextLine();
            char inputChar = 0;
            if (input.length() > 0) {
                inputChar = input.toLowerCase().charAt(0);
            }

            switch (inputChar) {
                case 'q':
                    System.exit(0);
                    break;
                case 'a':
                    targetX = playerOne.getX() - 1;
                    break;
                case 'w':
                    targetY = playerOne.getY() - 1;
                    break;
                case 'd':
                    targetX = playerOne.getX() + 1;
                    break;
                case 's':
                    targetY = playerOne.getY() + 1;
                    break;
                default:
            }

            //check for movement
            if (targetX != playerOne.getX() || targetY != playerOne.getY()) {
                char targetTile = cavernOne.tileAt(targetX, targetY);
                if (targetTile == ' ') { //move into empty space
                    playerOne.move(targetX, targetY);
                } else if (targetTile == '#') { //don't move; there's a wall there
                    display = "There is a wall there.";
                } else { //interact with person
                    Character targetCharacter = cavernOne.characterAt(targetX, targetY);
                    display = targetCharacter.getQuote();
                }
            }

            System.out.println(cavernOne.getView(playerOne));
            System.out.println(display);

        }
    }
}
