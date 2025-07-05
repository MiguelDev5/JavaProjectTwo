/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.collectionsandmaps;

/**
 *
 * @author MSI
 */

import java.util.*;

public class CollectionsTest {
    public static void ejemploList() {
        List<String> lista = new ArrayList<>();
        System.out.println("List -> hash antes: " + System.identityHashCode(lista));
        System.out.println("Se agregó un item: Hola");
        lista.add("Hola");
        System.out.println("List -> hash después: " + System.identityHashCode(lista));
        System.out.println("Contenido: " + lista);
    }

    public static void ejemploSet() {
        Set<String> conjunto = new HashSet<>();
        System.out.println("Set -> hash antes: " + System.identityHashCode(conjunto));
        System.out.println("Se agregó un item: Hola");
        conjunto.add("Hola");
        System.out.println("Set -> hash después: " + System.identityHashCode(conjunto));
        System.out.println("Contenido: " + conjunto);
    }

    public static void ejemploQueue() {
        Queue<String> cola = new LinkedList<>();
        System.out.println("Queue -> hash antes: " + System.identityHashCode(cola));
        System.out.println("Se agregó un item: Hola");
        cola.add("Hola");
        System.out.println("Queue -> hash después: " + System.identityHashCode(cola));
        System.out.println("Contenido: " + cola);
    }

    public static void ejemploMap() {
        Map<String, String> mapa = new HashMap<>();
        System.out.println("Map -> hash antes: " + System.identityHashCode(mapa));
        System.out.println("Se agregó un par clave=valor");
        mapa.put("clave", "valor");
        System.out.println("Map -> hash después: " + System.identityHashCode(mapa));
        System.out.println("Contenido: " + mapa);
    }

    public static void ejemploArray() {
        String[] arreglo = new String[2];
        System.out.println("Array -> hash antes: " + System.identityHashCode(arreglo));
        System.out.println("Se agregó un item: Hola en posición 0");
        arreglo[0] = "Hola";
        System.out.println("Array -> hash después: " + System.identityHashCode(arreglo));
        System.out.println("Contenido: " + Arrays.toString(arreglo));
    }

    public static void ejemploListOf() {
        System.out.println("Creando List.of (inmutable)");
        List<String> lista = List.of("uno", "dos");
        System.out.println("Contenido inicial: " + lista);
        System.out.println("Intentando agregar item...");

        try {
            lista.add("tres");
        } catch (UnsupportedOperationException e) {
            System.out.println("❌ No se puede agregar elemento: " + e);
        }

        try {
            lista.set(0, "UNO");
        } catch (UnsupportedOperationException e) {
            System.out.println("❌ No se puede modificar contenido: " + e);
        }

        System.out.println("Contenido final: " + lista);
    }

    public static void ejemploAsList() {
        System.out.println("Creando Arrays.asList (mutable contenido, tamaño fijo)");
        List<String> lista = Arrays.asList("uno", "dos");
        System.out.println("Contenido inicial: " + lista);

        System.out.println("Modificando elemento en posición 0 a 'UNO'");
        lista.set(0, "UNO");
        System.out.println("Contenido tras modificación: " + lista);

        System.out.println("Intentando agregar item...");
        try {
            lista.add("tres");
        } catch (UnsupportedOperationException e) {
            System.out.println("❌ No se puede agregar elemento: " + e);
        }

        System.out.println("Contenido final: " + lista);
    }
}
