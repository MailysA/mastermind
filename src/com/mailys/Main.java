package com.mailys;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        /* initialise du secret */
        int Min = 0;
        int Max = 9;
        int number1secret =  Min + (int)(Math.random() * ((Max - Min) + 1));
        int number2secret =  Min + (int)(Math.random() * ((Max - Min) + 1));
        int number3secret = Min + (int)(Math.random() * ((Max - Min) + 1));
        int number4secret =  Min + (int)(Math.random() * ((Max - Min) + 1));

        /* generation du secret */
        int[] secret = new int[]{number1secret,number2secret,number3secret,number4secret};
        System.out.println("Generation du secret: " + number1secret + " " + number2secret + " " + number3secret + " " + number4secret);

        System.out.println("Veuillez entrer 4 chiffres entiers:");
        BufferedReader playerChoiceReader = new BufferedReader(new InputStreamReader(System.in));
        if(playerChoiceReader == null) {
            System.out.println("Il faut renseigner une suite de 4 chiffres.");
        }else {
            String currentResult = "";
            while(currentResult != secret.toString()) {
                /* Choix du joueur */
                String playerChoice = playerChoiceReader.readLine().trim();
                System.out.println("Choix du joueur: " + playerChoice);

                /* controle du choix du joueur */
                while (playerChoice.length() != 4) {
                    if (playerChoice.length() < 4 || playerChoice.length() > 4) {
                        System.out.println("Il faut rentrer 4 nombres, réessayez:");
                        playerChoiceReader = new BufferedReader(new InputStreamReader(System.in));
                        playerChoice = playerChoiceReader.readLine().trim();
                    }
                }

                char[] playerChoiceArray = playerChoice.toCharArray();
                for (int i = 0; i <= playerChoiceArray.length; i++) {
                    System.out.println("choix joueur: " + playerChoiceArray[i]);
                    for (int j = 0; j <= secret.length; j++) {
                        if (playerChoiceArray[i] == secret[j]) {
                            currentResult += "+";
                        } else if (Arrays.asList(secret).contains(playerChoiceArray[i])) {
                            currentResult += "-";
                        } else {
                            currentResult += "";
                        }
                    }
                }
                System.out.println("résultat: " + currentResult);
            }
            System.out.println("Bien joué! vous avez trouvé la combinaison secrète" + currentResult);

        }
	/*
	 Pour chaque partie faire
	    random secret 4 caracteres à chaque partie
        proposition joueur en input
        comparaison du secret et de l'input (tableau indexé)
        tant que secret match pas avec input du joueur alors
        Pour chaque matching d'index
            si le nombre est le meme alors
                log "+"
            sinon si le nombre est contenu dans le tableau alors
            log "-"
            sinon
            log "vide"
            fin si
        fin pour
    fin pour
	 */
    }
}
