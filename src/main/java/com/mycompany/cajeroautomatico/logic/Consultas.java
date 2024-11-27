package com.mycompany.cajeroautomatico.logic;

import com.mycompany.cajeroautomatico.basededatos.ConexionM;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consultas {
    private ConexionM conexion; 
    
    public Connection getConnection() {
        try{
            Connection conn = conexion.connect();
            return conn;
        } catch (Exception e) {
            System.out.println("Error de consulta: " + e.getMessage());
            return null;
        }
    }
    
    // Consulta para obtener el nombre de un usuario basado en el número de tarjeta
    public String name(String numCard) {
        String queryName = "SELECT name FROM user WHERE num_card = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(queryName)) {
            pstmt.setString(1, numCard);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
               return rs.getString("name");
            } else {
                return "No encontrado";
            }
        } catch (SQLException e) {
            System.out.println("Error de consulta: " + e.getMessage());
            return "";
        }  
    }
    
    // Consulta para obtener el saldo de un usuario
    public double money(String numCard) {
        String queryMoney = "SELECT money FROM user WHERE num_card = ?"; 
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(queryMoney)) {
            pstmt.setString(1, numCard);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("money");
            } else {
                System.out.println("Usuario no encontrado.");
                return 0;
            }
        } catch (SQLException e) {
            System.out.println("Error de consulta: " + e.getMessage());
            return 0;
        }
    }
    
    // Método para realizar un retiro
    public void retiro(String numCard, double amount) {
        String query = "UPDATE user SET money = money - ? WHERE num_card = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setDouble(1, amount);
            pstmt.setString(2, numCard);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Retiro realizado con éxito.");
            } else {
                System.out.println("Error en el retiro o usuario no encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Error de consulta: " + e.getMessage());
        }
    }
    
    // Método para realizar un depósito
    public void depositar(String numCard, double amount) {
        String query = "UPDATE user SET money = money + ? WHERE num_card = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setDouble(1, amount);
            pstmt.setString(2, numCard);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Depósito realizado con éxito.");
            } else {
                System.out.println("Error en el depósito o usuario no encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Error de consulta: " + e.getMessage());
        }
    }
    
    // Método para realizar una transferencia entre dos usuarios
    public void transferencia(String fromCard, String toCard, double amount) {
        String queryWithdraw = "UPDATE user SET money = money - ? WHERE num_card = ?";
        String queryDeposit = "UPDATE user SET money = money + ? WHERE num_card = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmtWithdraw = conn.prepareStatement(queryWithdraw);
             PreparedStatement pstmtDeposit = conn.prepareStatement(queryDeposit)) {
            
            // Retirar dinero del primer usuario
            pstmtWithdraw.setDouble(1, amount);
            pstmtWithdraw.setString(2, fromCard);
            int rowsAffectedWithdraw = pstmtWithdraw.executeUpdate();
            
            // Depositar dinero al segundo usuario
            pstmtDeposit.setDouble(1, amount);
            pstmtDeposit.setString(2, toCard);
            int rowsAffectedDeposit = pstmtDeposit.executeUpdate();

            if (rowsAffectedWithdraw > 0 && rowsAffectedDeposit > 0) {
                System.out.println("Transferencia realizada con éxito.");
            } else {
                System.out.println("Error en la transferencia.");
            }
        } catch (SQLException e) {
            System.out.println("Error de consulta: " + e.getMessage());
        }
    }
    
    public boolean verificacion(String num_card, String pin) {
    String queryLogin = "SELECT num_card FROM user WHERE num_card = ? AND pin = ?"; 
    
        try (Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(queryLogin)) {
        
            pstmt.setString(1, num_card); 
            pstmt.setString(2, pin);    
        
            // Ejecutar la consulta
            ResultSet rs = pstmt.executeQuery();
        
            // Procesar el resultado
            if (rs.next()) {
                return true;
            } else {
               return false;
            }
        
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta: " + e.getMessage());
        }
        return false;
    }
}
