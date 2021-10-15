package com.mailys;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {

        int[] secret = getSecret();
        ArrayDeque result;
        StringBuilder showResult = null;
        boolean endGame = false;
        while(!endGame) {
            showResult = new StringBuilder();
            System.out.println("Veuillez entrer 4 chiffres:");
            BufferedReader playerChoiceReader = new BufferedReader(new InputStreamReader(System.in));
            if(playerChoiceReader == null) {
                System.out.println("Il faut renseigner une suite de 4 chiffres.");
            } else {
                result = new ArrayDeque<>();
                /* Choix du joueur */
                String playerChoice = playerChoiceReader.readLine().trim();
                System.out.println("Choix du joueur: " + playerChoice);

                /* controle du choix du joueur */
                while (playerChoice.length() != 4) {
                    System.out.println("Il faut rentrer 4 chiffres, réessayez:");
                    playerChoiceReader = new BufferedReader(new InputStreamReader(System.in));
                    playerChoice = playerChoiceReader.readLine().trim();
                }

                char[] playerChoiceArray = playerChoice.toCharArray();
                for(int i = 0; i < 4; i++) {
                    int currentDigitPlayer = Character.getNumericValue(playerChoiceArray[i]);
                        if (currentDigitPlayer == secret[i]) {
                            result.addFirst("+");
                        } else if (IntStream.of(secret).anyMatch(x -> x == currentDigitPlayer)) {
                            result.addLast("-");
                        } else {
                            result.addLast("");
                        }
                    }

                StringBuilder finalShowResult = showResult;
                result.stream().forEach(x -> finalShowResult.append(x));
                System.out.println("résultat: " + finalShowResult);
                if(result.stream().allMatch( x -> x == "+")){
                    endGame = true;
                }
             }
        }
        System.out.println("Bien joué! vous avez trouvé la combinaison secrète " +  showResult);
        System.out.println("Merci d'avoir joué au Mastermind !");
    }

    private static int[] getSecret() {
        /* initialise secret */
        int Min = 0;
        int Max = 9;
        int number1secret =  Min + (int)(Math.random() * ((Max - Min) + 1));
        int number2secret =  Min + (int)(Math.random() * ((Max - Min) + 1));
        int number3secret = Min + (int)(Math.random() * ((Max - Min) + 1));
        int number4secret =  Min + (int)(Math.random() * ((Max - Min) + 1));

        /* generate secret */
        int[] secret = new int[]{number1secret,number2secret,number3secret,number4secret};
        System.out.println("Generation du secret: " + number1secret + " " + number2secret + " " + number3secret + " " + number4secret);
        return secret;
    }
}
