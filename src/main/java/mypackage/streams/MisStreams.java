package com.mycompany.collectionsandmaps.src.main.java.mypackage.streams;

import java.util.*;
import java.util.stream.Collectors;

public class MisStreams {

    public static void streamExamples(){
        List<String> nombres = List.of("Ana", "Luis", "Eva", "Alberto", "Lucia");

        // Pipeline: source → intermediate operations → terminal operation

        // filter + map + collect
        List<String> resultado = nombres.stream()
                .filter(n -> n.startsWith("A"))      // ["Ana", "Alberto"]
                .map(String::toUpperCase)            // ["ANA", "ALBERTO"]
                .sorted()                            // ["ALBERTO", "ANA"]
                .collect(Collectors.toList());

        // count
        long cantidad = nombres.stream()
                .filter(n -> n.length() > 3)
                .count();  // 3

        // reduce — combina todos los elementos
        int suma = List.of(1, 2, 3, 4, 5).stream()
                .reduce(0, Integer::sum);  // 15

        // findFirst / findAny
        Optional<String> primero = nombres.stream()
                .filter(n -> n.startsWith("L"))
                .findFirst();  // Optional["Luis"]

        // anyMatch / allMatch / noneMatch
        boolean algunoConA = nombres.stream().anyMatch(n -> n.startsWith("A")); // true
        boolean todosCortos = nombres.stream().allMatch(n -> n.length() < 10);  // true

        // map a otro tipo
        List<Integer> longitudes = nombres.stream()
                .map(String::length)
                .collect(Collectors.toList());  // [3, 4, 3, 7, 5]

        // flatMap — "aplanar" listas de listas
        List<List<Integer>> listas = List.of(List.of(1, 2), List.of(3, 4));
        List<Integer> plana = listas.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());  // [1, 2, 3, 4]

        // Collectors avanzados
        Map<Integer, List<String>> agrupadosPorLongitud = nombres.stream()
                .collect(Collectors.groupingBy(String::length));
        // {3=[Ana, Eva], 4=[Luis], 7=[Alberto], 5=[Lucia]}

        String unido = nombres.stream()
                .collect(Collectors.joining(", "));  // "Ana, Luis, Eva, Alberto, Lucia"

        // Streams con objetos de dominio
        record Producto(String nombre, double precio, String categoria) {}

        List<Producto> productos = List.of(
                new Producto("Laptop", 999.0, "Tech"),
                new Producto("Mouse", 29.0, "Tech"),
                new Producto("Silla", 199.0, "Muebles")
        );

        // Precio promedio de productos Tech
        OptionalDouble promedio = productos.stream()
                .filter(p -> p.categoria().equals("Tech"))
                .mapToDouble(Producto::precio)
                .average();  // OptionalDouble[514.0]

        // Agrupar por categoría
        Map<String, List<Producto>> porCategoria = productos.stream()
                .collect(Collectors.groupingBy(Producto::categoria));
    }
}
