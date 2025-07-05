/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.collectionsandmaps;

import java.util.Scanner;

/**
 *
 * @author MSI
 */
public class CollectionsAndMaps {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n====== MENÚ DE EJEMPLOS ======");
            System.out.println("1. List mutable (ArrayList)");
            System.out.println("2. Set mutable (HashSet)");
            System.out.println("3. Queue mutable (LinkedList)");
            System.out.println("4. Map mutable (HashMap)");
            System.out.println("5. Array fijo []");
            System.out.println("6. List.of (inmutable)");
            System.out.println("7. Arrays.asList (mutable contenido, tamaño fijo)");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();
            System.out.println();

            System.out.println("/************************** RESULTADO **************************\\");
            
            switch (opcion) {
                case 1:
                    CollectionsTest.ejemploList();
                    break;
                case 2:
                    CollectionsTest.ejemploSet();
                    break;
                case 3:
                    CollectionsTest.ejemploQueue();
                    break;
                case 4:
                    CollectionsTest.ejemploMap();
                    break;
                case 5:
                    CollectionsTest.ejemploArray();
                    break;
                case 6:
                    CollectionsTest.ejemploListOf();
                    break;
                case 7:
                    CollectionsTest.ejemploAsList();
                    break;
                case 0:
                    System.out.println("Hasta luego.");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
            System.out.println("\\************************** RESULTADO **************************/");
        } while (opcion != 0);

        sc.close();
        
    }
}
