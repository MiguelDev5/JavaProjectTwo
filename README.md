# JavaProjectTwo

# @Autor: Miguel Medina – @MiguelDev5

# 📚 Java Colecciones: Mutabilidad, Hash y Casuísticas

Este proyecto demuestra el comportamiento de las distintas colecciones en Java, enfocándose en:

- 📌 Mutabilidad: si pueden modificar su contenido.
- 📌 Dirección de memoria (hash) antes y después de una operación.
- 📌 Casuísticas de error en colecciones inmutables o de tamaño fijo.
- 
---

## 1 - Contenido 📦

Incluye ejemplos de:

- `ArrayList` (mutable y dinámico)
- `HashSet` (mutable, sin duplicados)
- `LinkedList` (como `Queue`)
- `HashMap` (pares clave-valor mutables)
- `Array fijo `String[]`
- `List.of()` (inmutable)
- `Arrays.asList()` (mutable contenido, tamaño fijo)

---
## 2 - Colecciones

<pre>
Iterable
└── Collection
    ├── List         → Ordenada, permite duplicados
    │   ├── ArrayList    ← 90% de los casos (acceso rápido por índice)
    │   └── LinkedList   ← Inserción/eliminación frecuente al inicio/fin
    ├── Set          → Sin duplicados
    │   ├── HashSet      ← Más rápido, sin orden
    │   └── TreeSet      ← Ordenado naturalmente
    └── Queue
        └── PriorityQueue

Map (no extiende Collection)
├── HashMap      ← Más rápido, sin orden garantizado
├── LinkedHashMap ← Mantiene orden de inserción
└── TreeMap      ← Ordenado por clave
</pre>

# 📚 Cheat Sheet: Colecciones y Estructuras en Java

Resumen del comportamiento de las principales implementaciones de la Java Collections Framework basado en pruebas de mutabilidad y polimorfismo.

| Estructura | Interfaz / Tipo | Acceso (Get) | Inserción (Add) | ¿Tamaño Fijo? | ¿Modificable? | Nota Técnica |
| :--- | :--- | :---: | :---: | :---: | :---: | :--- |
| **ArrayList** | `List` | $O(1)$ | $O(1)*$ | No | ✅ Sí | Basado en arreglos. Rápido para lectura. |
| **LinkedList** | `List` / `Queue` | $O(n)$ | $O(1)$ | No | ✅ Sí | Basado en nodos. Rápido para insertar/eliminar. |
| **HashSet** | `Set` | $O(1)$ | $O(1)$ | No | ✅ Sí | No permite duplicados. Sin orden garantizado. |
| **HashMap** | `Map` | $O(1)$ | $O(1)$ | No | ✅ Sí | Almacena pares `K, V`. No es `Collection`. |
| **Array** | `T[]` | $O(1)$ | N/A | **Sí** | ✅ Sí | Estructura nativa de bajo nivel. |
| **List.of()** | `List` | $O(1)$ | ❌ | **Sí** | ❌ No | **Inmutable**. Lanza `UnsupportedOperationException`. |
| **Arrays.asList()**| `List` | $O(1)$ | ❌ | **Sí** | ✅ Sí | El tamaño es fijo, pero permite `set()`. |

> **$O(1)*$ en ArrayList:** La inserción es constante a menos que el arreglo interno se llene y deba redimensionarse (copiarse), en cuyo caso es $O(n)$ puntualmente.

---

## 🧠 Conceptos Clave Demostrados

### 1. Polimorfismo de Interfaz
Declarar `List<String> lista = new ArrayList<>();` permite cambiar la implementación interna sin afectar a los métodos que consumen la lista. Programamos para el **contrato** (`List`), no para el **detalle** (`ArrayList`).

### 2. Identidad vs. Estado
Como observamos con `System.identityHashCode()`, añadir elementos **no cambia la dirección de memoria** del objeto contenedor. El objeto es el mismo, su estado interno es el que muta.

### 3. El Contrato de Inmutabilidad
- **`List.of()`**: Diseñado para seguridad y programación funcional. Nadie puede alterar la colección una vez creada.
- **`Arrays.asList()`**: Es un "wrapper" sobre un array. Como los arrays tienen tamaño in
---


## 3 - Estructura de Clases 📜

- **`ColeccionesTest.java`**  
  Contiene los métodos con ejemplos de cada tipo de colección y sus casuísticas.

- **`MyApp.java`**  
  Contiene un menú interactivo por consola para ejecutar las pruebas de forma dinámica.

---

## 4 - Menú de opciones 📋

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

### 5 - Detalle de comportamiento

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

## 6 - Ejecución 📖

Compilar:

```bash
javac CollectionsAndMaps.java ColeccionesTest.java
