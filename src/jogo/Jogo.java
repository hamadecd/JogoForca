package jogo;

import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {
        String palavra = "farol";
        String tentativa;
        int chances = 1;
        int acertos = palavra.length();
        Scanner input = new Scanner(System.in);

        while (chances <= 6) {
            System.out.println("Informe uma letra ou adivinhe a palavra: ");
            tentativa = input.nextLine();

            if (tentativa.equals(palavra)) {
                System.out.println("Parabéns você acertou!");
                break;
            } else if (palavra.contains(tentativa)) {
                acertos--;
                if (acertos == 0) {
                    System.out.println("Parabéns você acertou!");
                    break;
                }
            } else {
                chances++;
            }

        }

        input.close();
    }
}
