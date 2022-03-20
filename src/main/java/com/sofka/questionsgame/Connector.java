package com.sofka.questionsgame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Connector {

    private String url = "jdbc:sqlite:historico.db";
    Connection connect;
    PreparedStatement statement;

    public void connect() {
        try {
            connect = DriverManager.getConnection(url);
            if (connect != null) {
                System.out.println("Conexión exitosa");
            }
        } catch (SQLException ex) {
            System.out.println("Error al conectar a la base de datos \n" + ex.getMessage());
        }
    }

    public void close() {
        try {
            connect.close();
            System.out.println("Conección cerrada");
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void save(Player p) {
        statement = null;
        try {
            statement = connect.prepareStatement("INSERT INTO puntajes(id, nombre, puntaje) values (null, ?,?)");
            statement.setString(1, p.getName());
            statement.setInt(2, p.getAccumulatedPrize());
            statement.executeUpdate();
            System.out.println("Se guardó el registro de " + p.getName() + ", su puntaje fue " + p.getAccumulatedPrize());
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void savePlayer(Player p) {
        connect();
        save(p);
        close();
    }

    public void getDataBase(JTable t1) {
        statement = null;
        try {
            statement = connect.prepareStatement("SELECT * FROM puntajes");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String id = String.valueOf(rs.getInt(1));
                String nombre = rs.getString(2);
                String puntaje = String.valueOf(rs.getInt(3));

                String[] tData = {id, nombre, puntaje};

                DefaultTableModel tblModel = (DefaultTableModel) t1.getModel();

                tblModel.addRow(tData);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void showDataBase(JTable t1) {
        connect();
        getDataBase(t1);
        close();
    }

}
