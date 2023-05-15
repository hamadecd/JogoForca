package jogo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Jogo {
    public static void main(String[] args) throws IOException {

        Random random = new Random();

        int categoria = random.nextInt(1, 4);
        String arquivo = "src\\dicionario" + categoria + ".txt";

        // Abre o arquivo e envolve o fluxo de bytes com um InputStreamReader
        FileInputStream fileStream = new FileInputStream(arquivo);
        InputStreamReader inputReader = new InputStreamReader(fileStream);

        // Envolve o InputStreamReader com um BufferedReader para ler as linhas do arquivo
        BufferedReader reader = new BufferedReader(inputReader);

        // Lê as linhas do arquivo e as armazena em uma lista
        List<String> lines = reader.lines().collect(Collectors.toList());

        // Gera um número aleatório entre 0 e o número de linhas na lista
        int randomIndex = random.nextInt(lines.size());

        // Seleciona a linha aleatória da lista
        String palavra = lines.get(randomIndex).toLowerCase();

        int tamanhoPalavra = palavra.length();
        List<String> letrasJogadas = new ArrayList();
        Scanner input = new Scanner(System.in);
        String palavraCopia = palavra;
        Character tentativa = null;

        String[] palavraOculta = new String[tamanhoPalavra];
        for (int i = 0; i < palavraOculta.length; i++) {
            palavraOculta[i] = "_ ";
        }

        String palavraCategoria = "";

        switch (categoria) {
            case 1:
                palavraCategoria = "Comidas e Bebidas";
                break;
            case 2:
                palavraCategoria = "Esportes";
                break;
            case 3:
                palavraCategoria = "Animais";
                break;
        }

        System.out.println("\nBEM VINDO AO JOGO DA FORCA" +
                "\nCATEGORIA: " + palavraCategoria);
        int chances = 6;

        while (chances >= 1) {
            System.out.println("Suas chances restantes: " + chances);
            for (String s : palavraOculta) {
                System.out.print(s);
            }
            System.out.println();
            System.out.println("Informe uma letra: ");
            tentativa = input.next().toLowerCase().charAt(0);

            if (!tentativa.toString().matches("([a-z])")) {
                System.out.println("Informe somente uma letra válida!");
                continue;
            } else if (letrasJogadas.contains(tentativa.toString())) {
                continue;
            }

            if (palavra.contains(tentativa.toString())) {
                palavra = palavra.replaceAll(tentativa.toString(), "");

                for (int i = 0; i < palavraCopia.length(); i++) {
                    if (palavraCopia.charAt(i) == tentativa) {
                        palavraOculta[i] = tentativa.toString() + " ";
                    }
                }

                if (palavra.isEmpty()) {
                    System.out.println("Parabéns você acertou!");
                    for (String s : palavraOculta) {
                        System.out.print(s);
                    }
                    System.out.println();
                    chances = 0;
                }
            } else {
                chances--;
            }

            letrasJogadas.add(tentativa.toString());
            System.out.println("Letras jogadas " + letrasJogadas);
        }

        input.close();
    }
}
