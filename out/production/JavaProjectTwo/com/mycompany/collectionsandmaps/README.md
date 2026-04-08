# JavaProjectTwo

# @Autor: Miguel Medina – @MiguelDev5

# 📚 Java Colecciones: Mutabilidad, Hash y Casuísticas

Este proyecto demuestra el comportamiento de las distintas colecciones en Java, enfocándose en:

- 📌 Mutabilidad: si pueden modificar su contenido.
- 📌 Dirección de memoria (hash) antes y después de una operación.
- 📌 Casuísticas de error en colecciones inmutables o de tamaño fijo.

---

## 📦 Contenido

Incluye ejemplos de:

- `ArrayList` (mutable y dinámico)
- `HashSet` (mutable, sin duplicados)
- `LinkedList` (como `Queue`)
- `HashMap` (pares clave-valor mutables)
- `Array fijo `String[]`
- `List.of()` (inmutable)
- `Arrays.asList()` (mutable contenido, tamaño fijo)

---

## 📜 Estructura de Clases

- **`ColeccionesTest.java`**  
  Contiene los métodos con ejemplos de cada tipo de colección y sus casuísticas.

- **`MyApp.java`**  
  Contiene un menú interactivo por consola para ejecutar las pruebas de forma dinámica.

---

## 📋 Menú de opciones

Al ejecutar la aplicación, verás el siguiente menú por consola:

```
====== MENÚ DE EJEMPLOS ======
1. List mutable (ArrayList)
2. Set mutable (HashSet)
3. Queue mutable (LinkedList)
4. Map mutable (HashMap)
5. Array fijo []
6. List.of (inmutable)
7. Arrays.asList (mutable contenido, tamaño fijo)
0. Salir
```

### 📌 Detalle de comportamiento

- Cada opción muestra:
  - 📌 Hash antes de modificar.
  - 📌 Acción realizada (agregar, modificar elemento, o intento de hacerlo).
  - 📌 Hash después de modificar (para validar mutabilidad).
  - 📌 Contenido final.

- Las opciones `6` y `7` además prueban casuísticas:
  - `List.of()`:
    - Muestra contenido inicial.
    - Intenta agregar un elemento (lanza `UnsupportedOperationException`).
    - Intenta modificar contenido (lanza `UnsupportedOperationException`).
  - `Arrays.asList()`:
    - Muestra contenido inicial.
    - Modifica contenido existente (permitido).
    - Intenta agregar un nuevo elemento (lanza `UnsupportedOperationException`).

---

## 📖 Ejecución

Compilar:

```bash
javac CollectionsAndMaps.java ColeccionesTest.java
