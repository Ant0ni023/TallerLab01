import java.util.Scanner;
import java.util.Random;

public class GestorDeMatriz {

    public static void main(String[] args) {
        // El método main solo invoca al menú
        mostrarMenuPrincipal();
    }

    // Método para ejecutar el menú principal
    public static void mostrarMenuPrincipal() {
        int opcion;
        int[][] matriz = null; // Declarar la matriz al inicio

        do {
            mostrarOpciones(); // Mostrar opciones del menú
            opcion = capturarOpcion(); // leer la opción del usuario
            matriz = procesarOpcion(opcion, matriz); // Procesar la opción seleccionada
        } while (opcion != 4); // Repetir hasta que el usuario seleccione salir
    }

    // Método para mostrar las opciones del menú
    public static void mostrarOpciones() {
        System.out.println("\n--- Menú de opciones ---");
        System.out.println("1. Crear matriz");
        System.out.println("2. Llenar matriz");
        System.out.println("3. Mostrar fila específica");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // Método para capturar la opción seleccionada por el usuario
    public static int capturarOpcion() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    // Método para procesar la opción seleccionada mediante la llamada de los metodos que ejecutan estas opciones
    public static int[][] procesarOpcion(int opcion, int[][] matriz) {
        switch (opcion) {
            case 1:
                matriz = crearMatriz(); // Crear matriz
                System.out.println("Matriz creada exitosamente.");
                break;
            case 2:
                if (matriz != null) {
                    matriz = llenarMatriz(matriz); // Llenar matriz
                    System.out.println("Matriz llenada.");
                } else {
                    System.out.println("Primero debe crear la matriz.");
                }
                break;
            case 3:
                if (matriz != null) {
                    mostrarFilaEspecifica(matriz); // Mostrar fila específica
                } else {
                    System.out.println("Primero debe crear la matriz.");
                }
                break;
            case 4:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
        return matriz;
    }

    // Método para crear la matriz
    public static int[][] crearMatriz() {
        int[] dimensiones = capturarDimensiones();
        if (validarDimensiones(dimensiones[0], dimensiones[1])) {
            return new int[dimensiones[0]][dimensiones[1]]; // Retorna una matriz vacía
        } else {
            System.out.println("Dimensiones no válidas. Deben ser mayores a 0.");
            return null; // Retorna null si las dimensiones no son válidas
        }
    }

    // Método para validar las dimensiones de la matriz
    public static boolean validarDimensiones(int filas, int cols) {
        return filas > 0 && cols > 0;
    }

    // Método para capturar las dimensiones ingresadas por el usuario
    public static int[] capturarDimensiones() {
        Scanner scanner = new Scanner(System.in);
        int[] dimensiones = new int[2];

        System.out.print("Ingrese el número de filas: ");
        dimensiones[0] = scanner.nextInt();

        System.out.print("Ingrese el número de columnas: ");
        dimensiones[1] = scanner.nextInt();

        return dimensiones;
    }

    // Método para llenar la matriz con números aleatorios entre 0 y 9
    public static int[][] llenarMatriz(int[][] matriz) {
        Random random = new Random();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = random.nextInt(10); // Llenar con valores entre 0 y 9
            }
        }
        return matriz;
    }

    // Método para mostrar una fila específica de la matriz
    public static void mostrarFilaEspecifica(int[][] matriz) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el número de fila a mostrar: ");
        int fila = sc.nextInt();

        if (fila >= 0 && fila < matriz.length) {
            for (int j = 0; j < matriz[fila].length; j++) {
                System.out.print(matriz[fila][j] + " ");
            }
            System.out.println();
        } else {
            System.out.println("Número de fila no válido.");
        }
    }






}
