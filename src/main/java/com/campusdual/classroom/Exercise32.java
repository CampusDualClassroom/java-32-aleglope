package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Exercise32 {

    public static void main(String[] args) {
        // Obtener la cadena ya sea de un parámetro o solicitando al usuario
        String textToSave = generateStringToSave(null);

        // Escribir el texto en el archivo
        printToFile(textToSave);
    }

    /**
     * Genera la cadena a guardar. Si recibe una cadena no nula, la devuelve. Si es nula, llama a generateUserInputToSave().
     *
     * @param string Cadena a comprobar.
     * @return La cadena a guardar.
     */
    public static String generateStringToSave(String string) {
        if (string != null) {
            return string; // Si se pasa una cadena, devolverla
        }
        // Si la cadena es nula, pedir al usuario que ingrese texto
        return generateUserInputToSave();
    }

    /**
     * Solicita al usuario la entrada de texto y lo guarda en una cadena.
     *
     * @return La cadena con el texto ingresado por el usuario.
     */
    private static String generateUserInputToSave() {
        StringBuilder sb = new StringBuilder();
        System.out.println("Escribe debajo el texto que quieras. Pulsa \"ENTER\" 2 veces seguidas para finalizar:");
        String string;
        while (!(string = Utils.string()).isEmpty()) {
            sb.append(string).append(System.lineSeparator());
        }
        return sb.toString();
    }

    /**
     * Imprime la cadena proporcionada en un archivo de texto.
     *
     * @param string Cadena a escribir en el archivo.
     */
    public static void printToFile(String string) {
        // Ruta al archivo
        String filePath = "src/main/resources/data.txt";
        File file = new File(filePath);

        // Verificar si la ruta del directorio existe, si no, crearla
        File directory = file.getParentFile();
        if (!directory.exists()) {
            directory.mkdirs(); // Crear los directorios necesarios
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            // Escribir la cadena en el archivo
            writer.write(string);
            System.out.println("Texto guardado en el archivo.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
