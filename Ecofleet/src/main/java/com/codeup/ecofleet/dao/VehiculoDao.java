
package com.codeup.ecofleet.dao;


import com.codeup.ecofleet.modelo.Vehiculo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehiculoDao {
    
     private Connection conn;

    public VehiculoDao(Connection conn) {
        this.conn = conn;
    }
    public void insert(Vehiculo v) {
        String insertSql = "INSERT IGNORE INTO vehiculo( tipo, marca, modelo, placa, disponible) VAUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(insertSql)){
               ps.setString(1, v.getTipo());
               ps.setString(2, v.getMarca());
               ps.setString(3, v.getModelo());
               ps.setString(4, v.getPlaca());
               ps.setBoolean(5, v.getDisponible());
               
                int filas = ps.executeUpdate();
                
                if (filas == 0 ) {
                    System.out.println("este registro ya existe en la base de datos");
                } else {
                    System.out.println("las filas afectadas fueron: " + filas);
                }
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }
    
  
    public List<Vehiculo> listar() throws SQLException {
           String selectSql ="SELECT id, tipo, marca, modelo, placa, disponible FROM vehiculos";
            List<String> filas = new ArrayList<>();  
            try (Statement st = conn.createStatement();
                 ResultSet rs = st.executeQuery(selectSql)){
                
                while(rs.next()){
                    filas.add(
                            rs.getString("id") + " | " + 
                            rs.getString("tipo") + " | " + 
                            rs.getString("marca") + " | " + 
                            rs.getString("modelo") + " | " +
                            rs.getString("placa") + " | " +
                            rs.getBoolean("disponible") 
                    );
                }
            
            filas.forEach(System.out::println);
}
             return null;
}
     public void actualizar(Vehiculo vehiculo) {
        String sql = "UPDATE vehiculo SET tipo=?, marca=?, modelo=?, placa=?, disponible=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, vehiculo.getTipo());
            stmt.setString(2, vehiculo.getMarca());
            stmt.setString(3, vehiculo.getModelo());
            stmt.setString(4, vehiculo.getPlaca());
            stmt.setBoolean(5, vehiculo.getDisponible());
            stmt.executeUpdate();
            System.out.println("Vehiculo  actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM vehiculo WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("vehiculo eliminado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
