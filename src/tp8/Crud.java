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

public class Crud {
    private Connection conexao;
    public Crud(Connection conexao){
        this.conexao = conexao;
    }
    public boolean createAluno(int matricula, String nome, int IRA, String curso){
       try{
        Statement statement = this.conexao.createStatement();
        statement.executeUpdate("INSERT INTO Aluno VALUES('"+nome+"', "+matricula+", "+IRA+", '"+curso+"')");
        
        return true;
    } catch(SQLException e){
        return false;
    }
}
    public boolean createCurso(String centro, String departamento, String nomeclatura, int codigo){
       try{
        Statement statement = this.conexao.createStatement();
        statement.executeUpdate("INSERT INTO Curso VALUES('"+centro+"', '"+departamento+"', '"+nomeclatura+"', "+codigo+")");
        
        return true;
    } catch(SQLException e){
        return false;
    }    
}
    public boolean readAluno(int matricula){
        try{
            Statement statement = this.conexao.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * From Aluno WHERE matricula = "+matricula+"");
            
            while (rs.next()){
                Integer id = rs.getInt("matricula");
                Integer ira = rs.getInt("IRA");
                String nome = rs.getString("nome");
                
                
                System.out.println(matricula + " - " + ira + " - " + nome);
            }
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean readCurso(int codigo){
        try{
            Statement statement = this.conexao.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * From Curso WHERE codigo = "+codigo);
            
            while (rs.next()){
                Integer id = rs.getInt("codigo");
                String centro = rs.getString("centro");
                String departamento = rs.getString("departamento");
                String nomeclatura = rs.getString("nomeclatura");
                
                
                System.out.println(codigo + " - " + centro + " - " + departamento + " - " + nomeclatura);
            }
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    public boolean updateAluno(int matricula, String nome, int IRA, int novaMatricula){
        try{
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("UPDATE aluno SET matricula = "+novaMatricula+", ira = "+IRA+", nome = '"+nome+"' WHERE matricula = "+matricula);
            
            return true;
           }catch(SQLException e){
               return false;
           }
    }
    
    public boolean updateCurso(int codigo, String nomeclatura, String centro, String departamento, int novoCodigo){
        try{
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("UPDATE curso SET codigo = "+novoCodigo+", nomeclatura = '"+nomeclatura+"', centro = '"+centro+"', departamento = '"+departamento+"' WHERE codigo = "+codigo);
            
            return true;
           }catch(SQLException e){
               return false;
           }    
    
}
    public boolean deleteAluno(int matricula){
        try{
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("DELETE from Aluno WHERE matricula = "+matricula+"");
            
            return true;
            }catch(SQLException e){
                return false;
            }
}
    public boolean deleteCurso(int codigo){
        try{
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("DELETE from Curso WHERE codigo = "+codigo+"");
            
            return true;
            }catch(SQLException e){
                return false;
            }
}
    public boolean registra5Aluno(int matricula1, String nome1, int IRA1, int matricula2, String nome2, int IRA2, int matricula3, String nome3, int IRA3, int matricula4, String nome4, int IRA4, int matricula5, String nome5, int IRA5){
       try{
        Statement statement = this.conexao.createStatement();
        statement.executeUpdate("INSERT INTO Aluno VALUES('"+nome1+"', "+matricula1+", "+IRA1+"),('"+nome2+"', "+matricula2+", "+IRA2+"),('"+nome3+"', "+matricula3+", "+IRA3+"),('"+nome4+"', "+matricula4+", "+IRA4+"),('"+nome5+"', "+matricula5+", "+IRA5+")");
        
        return true;
    } catch(SQLException e){
        return false;
    }
}
    public boolean registra5Curso(String centro1, String departamento1, String nomeclatura1, int codigo1, String centro2, String departamento2, String nomeclatura2, int codigo2, String centro3, String departamento3, String nomeclatura3, int codigo3, String centro4, String departamento4, String nomeclatura4, int codigo4, String centro5, String departamento5, String nomeclatura5, int codigo5){
       try{
        Statement statement = this.conexao.createStatement();
        statement.executeUpdate("INSERT INTO Curso VALUES('"+centro1+"', '"+departamento1+"', '"+nomeclatura1+"', "+codigo1+"),('"+centro2+"', '"+departamento2+"', '"+nomeclatura2+"', "+codigo2+"),('"+centro3+"', '"+departamento3+"', '"+nomeclatura3+"', "+codigo3+"),('"+centro4+"', '"+departamento4+"', '"+nomeclatura4+"', "+codigo4+"),('"+centro5+"', '"+departamento5+"', '"+nomeclatura5+"', "+codigo5+") ");
        
        return true;
    } catch(SQLException e){
        return false;
    }
    
    
       
}   
    public boolean procuraLike(String local, String indentificador){
        try{
            Statement statement = this.conexao.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * From Aluno, Curso WHERE "+local+" LIKE '%"+indentificador+"%'");
            
            while (rs.next()){
                Integer matricula = rs.getInt("matricula");
                Integer ira = rs.getInt("IRA");
                String nome = rs.getString("nome");
                Integer codigo = rs.getInt("codigo");
                String centro = rs.getString("centro");
                String departamento = rs.getString("departamento");
                String nomeclatura = rs.getString("nomeclatura");                
                
                System.out.println(matricula + " - " + ira + " - " + nome + " - " + codigo + " - " + centro + " - " + departamento + " - " + nomeclatura);
            }
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    public boolean procuraLikeAluno(String local, String indentificador){
        try{
            Statement statement = this.conexao.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * From Aluno WHERE "+local+" LIKE '"+indentificador+"'");
            
            while (rs.next()){
                Integer matricula = rs.getInt("matricula");
                Integer ira = rs.getInt("IRA");
                String nome = rs.getString("nome");
              
                
                System.out.println(matricula + " - " + ira + " - " + nome);
            }
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean likeRead(String local, int matricula){
        try{
            Statement statement = this.conexao.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * From Aluno WHERE "+local+" = "+matricula+"");
            
            while (rs.next()){
                Integer id = rs.getInt("matricula");
                Integer ira = rs.getInt("IRA");
                String nome = rs.getString("nome");
                
                
                System.out.println(matricula + " - " + ira + " - " + nome);
            }
            return true;
        }catch(SQLException e){
            return false;
        }
    }    
}