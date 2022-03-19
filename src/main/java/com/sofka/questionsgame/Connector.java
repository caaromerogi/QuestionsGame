package com.sofka.questionsgame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connector {
private String url = "jdbc:sqlite:src\\main\\database\\historico.db";
    Connection connect;
    PreparedStatement statement;
    
    public void connect(){
        try{
            connect = DriverManager.getConnection(url);
            if (connect!= null){
                System.out.println("Conexión exitosa");
            }
        }catch(SQLException ex){
            System.out.println("Error al conectar a la base de datos \n"+ ex.getMessage());
        }
    }
    
    public void close(){
        try {
            connect.close();
            System.out.println("Conección cerrada");
        }catch(SQLException ex){
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void save(Player p){
        try{ 
            statement = connect.prepareStatement("INSERT INTO puntajes(id, nombre, puntaje) values (null, ?,?)");
            statement.setString(1, p.getName());
            statement.setInt(2, p.getAccumulatedPrize());
            System.out.println("Se guardó el registro de " + p.getName() + ", su puntaje fue "+p.getAccumulatedPrize());
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public void savePlayer(Player p){
        connect();
        save(p);
        close();
    }
}
