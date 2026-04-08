package com.mycompany.collectionsandmaps.src.main.java.mypackage.lambdas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class MisLambdas {
    public static void lambasExamples(){
        // Interfaz funcional = @FunctionalInterface (1 método abstracto)

        // Predicate<T>  → T → boolean
        Predicate<String> esLargo = s -> s.length() > 5;
        esLargo.test("Hola");     // false
        esLargo.test("Alberto");  // true

        // Function<T, R>  → T → R
        Function<String, Integer> longitud = String::length;
        longitud.apply("Java");   // 4

        // Consumer<T>  → T → void
        Consumer<String> imprimir = System.out::println;
        imprimir.accept("Hola!");

        // Supplier<T>  → () → T
        Supplier<List<String>> nuevaLista = ArrayList::new;
        List<String> lista = nuevaLista.get();

        // BiFunction<T, U, R>  → (T, U) → R
        BiFunction<Integer, Integer, Integer> sumar = (a, b) -> a + b;
        sumar.apply(3, 4);  // 7

        // Comparator (interfaz funcional muy usada)
        List<String> nombres = new ArrayList<>(List.of("Eva", "Ana", "Luis"));
        nombres.sort(Comparator.naturalOrder());
        nombres.sort(Comparator.reverseOrder());
        nombres.sort(Comparator.comparingInt(String::length));

        // Composición de funciones
        Function<Integer, Integer> duplicar = x -> x * 2;
        Function<Integer, Integer> sumarDiez = x -> x + 10;
        Function<Integer, Integer> duplicarLuegoSumar = duplicar.andThen(sumarDiez);
        duplicarLuegoSumar.apply(5);  // (5*2)+10 = 20

        // Method references — alternativa compacta a lambdas
        List<String> names = List.of("Ana", "Luis");
        names.forEach(System.out::println);   // Referencia a método de instancia
        names.stream().map(String::toUpperCase); // Referencia a método de instancia
        names.stream().map(Integer::parseInt);   // No aplica aquí, solo ejemplo
    }
}
