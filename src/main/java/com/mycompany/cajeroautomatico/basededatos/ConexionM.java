package com.mycompany.cajeroautomatico.basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionM {
    private static final String URL = "jdbc:mariadb://localhost:3307/cuentas";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "C0smopolis.";
    private static Connection conn = null;

    // Constructor privado para evitar la creación de instancias
    private ConexionM() {
    }

    // Método para obtener la conexión a la base de datos (Singleton)
    public static Connection connect() {
            try {
                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("Conexión exitosa a la base de datos.");
                return conn;
            } catch (SQLException e) {
                System.out.println("Error al conectar a la base de datos: " + e.getMessage());
                return conn;
            }
    }

    // Método para cerrar la conexión (si está abierta)
    public static void close() {
      if (conn != null) {
            try {
                conn.close();
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
    
}
