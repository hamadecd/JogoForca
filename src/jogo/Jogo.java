package jogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {
        String palavra = "arara";
        Character tentativa;
        int chances = 6;
        List<String> letrasJogadas = new ArrayList();
        Scanner input = new Scanner(System.in);

        System.out.println("BEM VINDO AO JOGO DA FORCA");

        while (chances >= 1) {
            System.out.println("Você tem " + chances + " chances!\n");
            System.out.println("Informe uma letra ou adivinhe a palavra: ");
            tentativa = input.next().toLowerCase().charAt(0);

            if (letrasJogadas.contains(tentativa.toString())) {
                System.out.println("Caiu na tratativa");
                System.out.println(letrasJogadas);
                break;
            }
            System.out.println("você digitou: " + tentativa);

            if (palavra.contains(tentativa.toString())) {
                palavra = palavra.replaceAll(tentativa.toString(), "");
                System.out.println("Palavra depois de ter acertado uma letra: " + palavra);
                if (palavra.isEmpty()) {
                    System.out.println("Parabéns você acertou!");
                    break;
                }
            } else {
                chances--;
            }

            letrasJogadas.add(tentativa.toString());
            System.out.println(letrasJogadas);

        }

        input.close();
    }
}
