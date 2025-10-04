
package com.codeup.ecofleet.dao;

import com.codeup.ecofleet.modelo.Alquiler;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlquilerDao {

    private Connection conn;

    public AlquilerDao(Connection conn) {
        this.conn = conn;
    }

    // Insertar un alquiler
    public void insert(Alquiler a) {
        String insertSql = "INSERT INTO alquileres(usuario_id, vehiculo_id, fecha_inicio, fecha_fin, km_recorridos, costo_total) " +
                           "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(insertSql)) {
            ps.setInt(1, a.getUsuarioId());
            ps.setInt(2, a.getVehiculoId());

            if (a.getFechaInicio() != null) {
                ps.setTimestamp(3, Timestamp.valueOf(a.getFechaInicio()));
            } else {
                ps.setNull(3, Types.TIMESTAMP);
            }

            if (a.getFechaFin() != null) {
                ps.setTimestamp(4, Timestamp.valueOf(a.getFechaFin()));
            } else {
                ps.setNull(4, Types.TIMESTAMP);
            }

            ps.setDouble(5, a.getKmRecorridos());
            ps.setDouble(6, a.getCostoTotal());

            int filas = ps.executeUpdate();
            if (filas == 0) {
                System.out.println("⚠ No se insertó el alquiler (posiblemente ya exista).");
            } else {
                System.out.println("✅ Alquiler insertado. Filas afectadas: " + filas);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Listar alquileres con formato en consola
    public List<String> listar() throws SQLException {
        String selectSql = "SELECT id, usuario_id, vehiculo_id, fecha_inicio, fecha_fin, km_recorridos, costo_total FROM alquileres";
        List<String> filas = new ArrayList<>();

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(selectSql)) {

            while (rs.next()) {
                String fila = rs.getInt("id") + " | "
                        + rs.getInt("usuario_id") + " | "
                        + rs.getInt("vehiculo_id") + " | "
                        + rs.getTimestamp("fecha_inicio") + " | "
                        + rs.getTimestamp("fecha_fin") + " | "
                        + rs.getDouble("km_recorridos") + " | "
                        + rs.getDouble("costo_total");
                filas.add(fila);
            }

            filas.forEach(System.out::println);
        }
        return null; // igual que en tu UserDao
    }

    // Actualizar un alquiler
    public void actualizar(Alquiler a) {
        String sql = "UPDATE alquileres SET usuario_id=?, vehiculo_id=?, fecha_inicio=?, fecha_fin=?, km_recorridos=?, costo_total=? WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, a.getUsuarioId());
            ps.setInt(2, a.getVehiculoId());

            if (a.getFechaInicio() != null) {
                ps.setTimestamp(3, Timestamp.valueOf(a.getFechaInicio()));
            } else {
                ps.setNull(3, Types.TIMESTAMP);
            }

            if (a.getFechaFin() != null) {
                ps.setTimestamp(4, Timestamp.valueOf(a.getFechaFin()));
            } else {
                ps.setNull(4, Types.TIMESTAMP);
            }

            ps.setDouble(5, a.getKmRecorridos());
            ps.setDouble(6, a.getCostoTotal());
            ps.setInt(7, a.getId());

            ps.executeUpdate();
            System.out.println("✅ Alquiler actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar un alquiler
    public void eliminar(int id) {
        String sql = "DELETE FROM alquileres WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("🗑 Alquiler eliminado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}