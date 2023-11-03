package Ejercicio;

import java.util.Scanner;

public class MutantDetector {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dna = new String[6];

        //Se solicita el ingreso las 6 filas de ADN
        for (int i = 0; i < 6; i++) {
            System.out.println("Ingresa la fila " + (i + 1) + " de ADN (6 letras de A, C, G o T):");
            dna[i] = scanner.nextLine();

            //Se verifica que la fila ingresada tiene exactamente 6 letras
            if (dna[i].length() != 6 || !dna[i].matches("[ACGT]+")) {
                System.out.println("Entrada inválida. Debe contener exactamente 6 letras de A, C, G o T.");
                i--;  //Caso contrario, se solicita nuevamente la entrada para la fila en cuestión
            }
        }

        boolean isMutantResult = isMutant(dna);

        System.out.println("Es un mutante: " + isMutantResult);

        //Se imprime la 'matriz' de ADN
        System.out.println("Matriz de ADN:");
        printDNASequence(dna);
    }

    public static boolean isMutant(String[] dna) {
        int numRows = dna.length;
        int numCols = dna[0].length();

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                char currentChar = dna[i].charAt(j);

                //Verificación horizontal
                if (j + 3 < numCols &&
                    currentChar == dna[i].charAt(j + 1) &&
                    currentChar == dna[i].charAt(j + 2) &&
                    currentChar == dna[i].charAt(j + 3)) {
                    return true;
                }

                // Verificación vertical
                if (i + 3 < numRows &&
                    currentChar == dna[i + 1].charAt(j) &&
                    currentChar == dna[i + 2].charAt(j) &&
                    currentChar == dna[i + 3].charAt(j)) {
                    return true;
                }

                if (i + 3 < numRows && j + 3 < numCols) {
                    // Verificación diagonal hacia la derecha y abajo
                    if (currentChar == dna[i + 1].charAt(j + 1) &&
                        currentChar == dna[i + 2].charAt(j + 2) &&
                        currentChar == dna[i + 3].charAt(j + 3)) {
                        return true;
                    }
                }

                if (i + 3 < numRows && j - 3 >= 0) {
                    // Verificación diagonal hacia la izquierda y abajo
                    if (currentChar == dna[i + 1].charAt(j - 1) &&
                        currentChar == dna[i + 2].charAt(j - 2) &&
                        currentChar == dna[i + 3].charAt(j - 3)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void printDNASequence(String[] dna) {
        for (String row : dna) {
            System.out.println(row);
        }
    }
}