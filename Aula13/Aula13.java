package Aula13;

import java.util.Scanner;

public class Aula13 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quantidade de alunos");
        int qtdAlunos = scanner.nextInt();
        scanner.nextLine();

        String[] nomes = new String[qtdAlunos];
        double[][] notas = new double[qtdAlunos][];
        double[][] pesos = new double[qtdAlunos][];
        double[] media = new double[qtdAlunos];

        for (int x = 0; x < qtdAlunos; x++) {
            System.out.println("nome" + (x + 1));
            nomes[x] = scanner.nextLine();

            System.out.println("Quantidade de notas " + nomes[x]);
            int qtdnotas = scanner.nextInt();
            scanner.nextLine();

            notas[x] = new double[qtdnotas];
            pesos[x] = new double[qtdnotas];

            double somNotas = 0;
            double somPesos = 0;

            for (int y = 0; y < qtdnotas; y++) {
                System.out.println("nota " + (y + 1));
                double nota = scanner.nextDouble();
                System.out.println("peso da nota " + (y + 1));
                double peso = scanner.nextDouble();

                notas[x][y] = nota;
                pesos[x][y] = peso;

                somNotas += nota * peso;
                somPesos += peso;
            }

            media[x] = somNotas / somPesos;
            System.out.println("A média " + nomes[x] + " é: " + media[x]);
            scanner.nextLine();
        }

        while (true) {
            System.out.println("Quer consultar a nota de um aluno? (s/n)");
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("s")) {
                System.out.println("nome do aluno");
                String nomeAluno = scanner.nextLine();
                boolean achAluno = false;

                for (int x = 0; x < qtdAlunos; x++) {
                    if (nomes[x].equalsIgnoreCase(nomeAluno)) {
                        achAluno = true;
                        System.out.println("Notas e pesos " + nomes[x] + ":");
                        for (int i = 0; i < notas[x].length; i++) {
                            System.out.println("Nota " + (i + 1) + ": " + notas[x][i] + ", Peso: " + pesos[x][i]);
                        }
                        System.out.println("media: " + media[x]);
                        break;
                    }
                }
                if (!achAluno) {
                    System.out.println("Não tem o aluno");
                }
            } else {
                break;
            }
        }
        scanner.close();
    }
}
