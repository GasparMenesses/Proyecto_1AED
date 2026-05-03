package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.example.model.Model;
import org.example.service.ModelService;

public class Main {

    public static void main(String[] args) throws Exception {

        // BuuferedReader para leer desde consola
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Variable nombre archivo
        String archivo = args.length > 0 ? args[0] : "models.txt";

        // Inicialización de variable int para opciones 
        int option = 0;

        // Inicialización de Modelo
        ModelService MdService = new ModelService();

        while (option != 4) {

            System.out.println("\nGESTION DE MODELOS");
            System.out.println("1. Cargar modelos desde archivo");
            System.out.println("2. Listar modelos existentes");
            System.out.println("3. Eliminar un modelo");
            System.out.println("4. Salir");

            option = Integer.parseInt(br.readLine());

            switch (option) {

                case 1:

                    cargarModelos(MdService, archivo);
                    MdService.PrintModels();
                    break;

                case 2:
                    // if (modelos.isEmpty()) {
                    //     System.out.println("No hay modelos.");
                    // } else {
                    //     for (Model m : modelos) {
                    //         System.out.println(m);
                    //     }
                    // }
                    break;

                case 3:
                    // System.out.println("Ingrese el ID:");
                    // String idEliminar = br.readLine();

                    // modelos.removeIf(m -> m.getId().equals(idEliminar));
                    // System.out.println("Modelo eliminado (si existía).");
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void cargarModelos(ModelService MdService, String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty() || linea.startsWith("#")) {
                    continue;
                }
                String[] partes = linea.split(";");
                if (partes.length < 4) {
                    continue;
                }
                try {
                    int id = Integer.parseInt(partes[0].trim());
                    String name = partes[1].trim();
                    String type = partes[2].trim();
                    String parameters = partes[3].trim();
                    MdService.registerModel(new Model(id, name, type, parameters));
                } catch (IllegalArgumentException ex) {
                    System.err.println("Línea inválida: " + linea);
                }
            }
        } catch (IOException e) {
            System.err.println("No se pudo leer " + archivo + ": " + e.getMessage());
        }

    }
}
