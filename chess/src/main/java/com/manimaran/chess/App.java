package com.manimaran.chess;

import java.util.*;


public class App {
    public static void main(String[] args) {


        int select;
        do {

            System.out.println("\n\n\n\n");
            System.out.println("Chess Demo");
            System.out.println("1- New Game , 2- Exit");

            Scanner scanner = new Scanner(System.in);
            select = scanner.nextInt();

            switch (select) {
                case 1:

                    Game game = new Game();
                    game.startGame();

                    break;

                default:
                    break;

            }

        } while (select != 2);


    }


}
