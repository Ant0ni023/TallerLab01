import java.util.Scanner;
import java.util.Random;

public class GestorDeMatriz {

    public static void main(String[] args) {
        // El método main solo llama al metodo mostrarMenuPrincipal
        mostrarMenuPrincipal();
    }

    // Declaramos el metodo mostrarMenuPrincipal que se encarga de controlar la interaccion del usuario con el menu.
    public static void mostrarMenuPrincipal() {
        int opcion;
        int[][] matriz = null;// Declara una matriz sin asignarle ningun valor por eso se inicializa con el null
        do {
            mostrarOpciones(); //llamamos al metodo mostrarOpciones
            opcion = capturarOpcion(); //llamamos al metodo capturarOpcion que captura o lee la opcion seleccionada por el usuario
            matriz = procesarOpcion(opcion, matriz); //llamamos al metodo de procesarOpcion de manera que sea procesada la opcion seleccionada
        } while (opcion != 5); // Repite la aparicion del menu hasta que el usuario seleccione el numero 5 que es la opcion para salir
    }

    // Declaramos el metodo mostrarOpciones que se encarga de mostrar las opciones del menu.
    public static void mostrarOpciones() {
        System.out.println("\n--- Menú de opciones ---");
        System.out.println("1. Crear matriz");
        System.out.println("2. Llenar matriz");
        System.out.println("3. Mostrar fila específica");
        System.out.println("4. Verificar si la matriz es de Tipo CERO");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    /*
    Declaramos el metodo capturarOpcion que obtiene el número ingresado por el usuario.
    Lo guarda temporalmente en una variable y lo retorna al método que lo llamó.
     */
    public static int capturarOpcion() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    // Declaramos el metodo procesarOpcion que se encarga de ejecutar la accion que haya sido seleccionada por el usuario.
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
                if (matriz != null) {
                    boolean esCero = matrizCero(matriz); // Verificar si es de Tipo CERO
                    if (esCero) {
                        System.out.println("La matriz es de Tipo CERO.");
                    } else {
                        System.out.println("La matriz no es de Tipo CERO.");
                    }
                } else {
                    System.out.println("Primero debe crear y llenar la matriz.");
                }
                break;
            case 5:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
        return matriz;
    }

    /*
    Declaramos el método crearMatriz que inicializa la matriz con las dimensiones ingresadas.
    Retorna la matriz vacía si las dimensiones son válidas o null si no lo son.
     */
    public static int[][] crearMatriz() {
        int[] dimensiones = capturarDimensiones();
        if (validarDimensiones(dimensiones[0], dimensiones[1])) {
            return new int[dimensiones[0]][dimensiones[1]]; // Retorna una matriz vacía
        } else {
            System.out.println("Dimensiones no válidas. Deben ser mayores a 0.");
            return null; // Retorna null si las dimensiones no son válidas
        }
    }

    // Declaramos el metodo validarDimensiones para asegurarnos que las dimensiones sean válidas.
    public static boolean validarDimensiones(int filas, int cols) {
        return filas > 0 && cols > 0;
    }

    // Método para capturar las dimensiones ingresadas por el usuario
    public static int[] capturarDimensiones() {
        Scanner sc = new Scanner(System.in);
        int[] dimensiones = new int[2];

        System.out.print("Ingrese el número de filas: ");
        dimensiones[0] = sc.nextInt();

        System.out.print("Ingrese el número de columnas: ");
        dimensiones[1] = sc.nextInt();

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
        System.out.print("Ingrese el número de fila a mostrar (entre 0 y " + (matriz.length - 1) + "): ");
        int fila = sc.nextInt();

        if (fila >= 0 && fila < matriz.length) {
            for (int j = 0; j < matriz[fila].length; j++) {
                System.out.print(matriz[fila][j] + " ");
            }
            System.out.println();
        } else {
            System.out.println("Número de fila no válido. Debe estar entre 0 y " + (matriz.length - 1));
        }
    }

    /*
    Declaramos el método matrizCero que verifica si más del 50% de los valores de la matriz son ceros.
    Retorna true si la matriz es de Tipo CERO, de lo contrario retorna false.
    */
    public static boolean matrizCero(int[][] matriz) {
        int totalElementos = matriz.length * matriz[0].length;
        int contadorCeros = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 0) {
                    contadorCeros++;
                }
            }
        }
        return contadorCeros > totalElementos / 2;
    }
}
