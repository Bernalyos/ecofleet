
package com.codeup.ecofleet.dao;



import com.codeup.ecofleet.modelo.Usuarios;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private Connection conn;

    public UserDao(Connection conn) {
        this.conn = conn;
    }
    public void insert(Usuarios usuario ){
        String insertSql = "INSERT IGNORE INTO usuarios( nombre, email, telefono) VAUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(insertSql)){
               ps.setString(1, usuario.getNombre());
               ps.setString(1, usuario.getEmail());
               ps.setString(1, usuario.getTelefono());
               
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
    
  
    public List<Usuarios> listar() throws SQLException {
           String selectSql ="SELECT id, nombre, email, telefono FROM usuarios";
            List<String> filas = new ArrayList<>();  
            try (Statement st = conn.createStatement();
                 ResultSet rs = st.executeQuery(selectSql)){
                
                while(rs.next()){
                    filas.add(
                            rs.getString("id") + " | " + 
                            rs.getString("nombre") + " | " + 
                            rs.getString("email") + " | " + 
                            rs.getString("telefono")
                    );
                }
            
            filas.forEach(System.out::println);
}
             return null;
}
     public void actualizar(Usuarios usuario) {
        String sql = "UPDATE usuarios SET nombre=?, email=?, telefono=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getTelefono());
            stmt.setInt(4, usuario.getId());
            stmt.executeUpdate();
            System.out.println("Usuario actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM usuarios WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Usuario eliminado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
