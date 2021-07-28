package com.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static String[] value = new String[9];
    public static void main(String[] args) {

        System.out.println("© created by aymenchikeb");
        System.out.print(Color.ANSI_RED);
        System.out.println("+------------------------+");
        System.out.println("| Welcome to TIC TAC TOE |");
        System.out.println("+------------------------+");
        System.out.print(Color.ANSI_RESET);


        System.out.println(Color.ANSI_YELLOW+"+-----Game has started------+"+Color.ANSI_RESET);

        boolean win = false;
        String player = "O";

        Arrays.fill(value, "?");


        while (!win){
            System.out.print("Enter "+ player +" to your placement (1-9) and press [ENTER]:");
            Scanner sc = new Scanner(System.in);
            int place = sc.nextInt();
            if(place<=0 || place>9){
                continue;
            }else{

                if(value[place-1].equals("?")){
                    value[place-1] = player;
                    printGameBoard();
                    win = checkWon();
                    player =((player.equals("O")) ? "X" : "O");
                }else{
                    System.out.println("i Enter "+ player +" to another placement");
                }


            }
        }

        if(win){
            System.out.println(Color.ANSI_GREEN+"\uD83E\uDD29 CONGRATULATION \uD83D\uDC4F \uD83E\uDD29"+Color.ANSI_RESET);
        }




    }

    public static void printGameBoard(){
        for (int i = 0; i < value.length; i++) {
            if((i+1)%3==0){
                System.out.print(value[i]);
                System.out.println();
                System.out.println("-+-+-");
            }else{
                System.out.print(value[i]+"|");
            }
        }
    }

    public static boolean checkWon(){
        return checkDiagonal() || checkVertical() || checkHorizontal();
    }


    public static boolean checkDiagonal(){
        if(!value[0].equals("?")){

            return value[0].equals(value[4]) && value[4].equals(value[8]);

        }
        if(!value[2].equals("?")) {

            return value[2].equals(value[4]) && value[4].equals(value[6]);

        }

        return false;


    }

    public static boolean checkHorizontal(){
        for (int i = 0; i < 3; i++) {
            //System.out.println(i);

            if(!value[i].equals("?")){

                if(value[i].equals(value[i + 3]) && value[i + 3].equals(value[i + 6])){
                    return true;
                }

            }

        }

        return false;
    }

    public static boolean checkVertical(){
        for (int i = 0; i < value.length; i++) {
            //System.out.println(i);

            if(!value[i].equals("?")){

                if(value[i].equals(value[i + 1]) && value[i + 1].equals(value[i + 2])){
                    return true;
                }
                else{
                    i = i+2;
                }

            }

        }

        return false;
    }
}
