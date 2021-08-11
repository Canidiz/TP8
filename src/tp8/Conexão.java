/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexão {
    private Connection connection;
    public Conexão(){
        this.connection = null;
    }
    private void SetConnection(Connection connection){
        this.connection = connection;
    }
    public Connection getConnection(){
        return this.connection;
    }
    public boolean abrirConexao(){
        try
        {
            connection = DriverManager.getConnection("jdbc:sqlite:E:/Documentos/TP-8.db");
            this.SetConnection(connection);
            return true;
        }
        catch(SQLException e)
        {
           return false; 
        }
    }
    public boolean fecharConexao(){
        try
        {
            if(this.getConnection() != null)
                this.getConnection().close();
                return true;
        }
        catch(SQLException e)
        {
            return false;
        }
    }
    
}

