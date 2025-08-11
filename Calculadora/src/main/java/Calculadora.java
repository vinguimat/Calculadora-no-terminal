/*
 * JDK 17+
 * Calculadora simples em Java
 * Permite operações: +, -, *, /
 * Observação: Digite "sair" para encerrar o programa.
 */

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Calcule: ");
        try {
            while (true) {
                System.out.print("> ");
                String entrada = scanner.nextLine().replaceAll("\\s+", "");
                if (entrada.equalsIgnoreCase("sair")) break;

                String[] partes = entrada.split("(?<=[-+*/])|(?=[-+*/])");

                double primeiroNumero;
                try {
                    primeiroNumero = Double.parseDouble(partes[0]);
                } catch (NumberFormatException e){
                    System.out.println("Formato inválido, digite números e operadores.");
                    continue;
                }

                for (int i = 1; i < partes.length; i += 2) {
                    char operador = partes[i].charAt(0);
                    double proximoNumero;

                    try {
                        proximoNumero = Double.parseDouble(partes[i + 1]);
                    } catch (NumberFormatException e) {
                        System.out.println("Número inválido: " + partes[i + 1]);
                        continue;
                    }

                    switch (operador) {
                        case '+':
                            primeiroNumero += proximoNumero;
                            break;
                        case '-':
                            primeiroNumero -= proximoNumero;
                            break;
                        case '*':
                            primeiroNumero *= proximoNumero;
                            break;
                        case '/':
                            if (proximoNumero == 0) {
                                System.out.println("Zero não é divisível");
                                continue;
                            }
                            primeiroNumero /= proximoNumero;
                            break;
                        default:
                            System.out.println("Operador inválido");
                    }
                }
                System.out.println(primeiroNumero);
            }
        } catch (NumberFormatException e){
            System.out.println("Digite números ex: 1+2");
        }
    }
}