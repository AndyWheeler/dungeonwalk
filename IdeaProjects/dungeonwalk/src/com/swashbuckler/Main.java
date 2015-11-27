package com.swashbuckler;
import java.util.*;


public class Main {

    private static final String map =
            "#########" +
            "#   #   #" +
            "#   # # #" +
            "#     # #" +
            "#########";
    private static final int width = 9;
    private static final int height = 5;
    private static final int startx = 2;
    private static final int starty = 3;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enjoy your walk.");

        Room myRoom = new Room(map, width, height);

        Creature playerOne = new Player(startx, starty, '@');
        Creature npcOne = new Npc(1, 1, '$');
        Creature npcTwo = new Npc(7, 3);

        myRoom.add(playerOne);
        myRoom.add(npcOne);
        myRoom.add(npcTwo);

        String display = "";
        System.out.println(myRoom.getView(playerOne));

        int targetX;
        int targetY;
        while(sc.hasNextLine()) {
            System.out.println(myRoom.getView(playerOne));
            System.out.println(display);

            targetX = playerOne.getX();
            targetY = playerOne.getY();
            display = "";

            String input = sc.nextLine();
            char inputChar = (char)0;
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
                char targetTile = myRoom.tileAt(targetX, targetY);
                if (targetTile == ' ') { //move into empty space
                    myRoom.move(playerOne, targetX, targetY);
                } else if (targetTile == '#') { //try to move into wall space
                    display = "There is a wall there.";
                } else { //interact with creature
                    Creature targetCreature = myRoom.getCreatureAt(targetX, targetY);
                    display = targetCreature.getQuote();
                }
            }


        }
    }
}
