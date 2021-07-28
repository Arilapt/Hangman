package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        char[] letterArray= CreateCharArray(ChooseMovie());
        char[] visLetterArray= new char[letterArray.length];
        Scanner keyboardInput = new Scanner(System.in);
        int nrOfTries = 10;

        for (int i = 0; i < letterArray.length; i++) {
            if (Character.toString(letterArray[i]).equals(" ")) visLetterArray[i] = " ".charAt(0);
        }

        while (true) {
            if (Arrays.equals(letterArray, visLetterArray)) {
                System.out.println();
                System.out.println("You Won!");
                System.exit(0);
            }

            System.out.println();
            for (char letter : visLetterArray) {
                System.out.print(letter);
            }

            System.out.println();
            System.out.println("You have " + nrOfTries + " tries left");

            if (TakeInputAndCheck(keyboardInput, letterArray, visLetterArray)) nrOfTries++;

            if(nrOfTries <= 1) {
                System.out.println("You Lost!");
                System.exit(0);
            }

            nrOfTries--;
        }
    }



    public static String ChooseMovie() throws FileNotFoundException{
        String[] movielist = new String[22];
        File file = new File("D:\\csh\\qwert\\movies.txt");
        Scanner filesc = new Scanner(file);
        int i = 0;

        //create movie array
        while (filesc.hasNextLine()) {
            String currMovieName = filesc.nextLine();
            while (movielist[i] == null) {
                movielist[i] = currMovieName;
            }
            i++;
        }

        //choose random movie
        return movielist[(int) (Math.random() * 100 + 1) / 4]; //hard codding pog
    }

    public static char[] CreateCharArray(String movie){
        char[] ltArrayV = new char[movie.length()];
        for (int i = 0; i < movie.length(); i++) {
            if (movie.charAt(i) != (" ".charAt(0))) {
                ltArrayV[i] = movie.charAt(i);
            }
            else {
                ltArrayV[i] = " ".charAt(0);
            }
        }
        return ltArrayV;
    }

    public static boolean TakeInputAndCheck(Scanner kbIn, char[] ltAr, char[] visLtAr) {
        System.out.print("Choose a letter: ");
        String inp = kbIn.nextLine();
        int check = 0;
        for (int i = 0, ltArLength = ltAr.length; i < ltArLength; i++) {
            if (inp.equals(Character.toString(ltAr[i]))) {
                visLtAr[i] = ltAr[i];
                check = 1;
            }
        }
        return check != 0;
    }

}

