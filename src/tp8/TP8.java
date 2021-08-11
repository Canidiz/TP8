/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp8;
import java.sql.Statement;
import java.sql.SQLException;



public class TP8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexão conexao = new Conexão();
        conexao.abrirConexao();
        Crud crud = new Crud(conexao.getConnection());
        //Populando db:
        

     
        
        
        
        conexao.fecharConexao();
    }
    
    
}
