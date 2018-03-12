/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Conexao;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Junior
 */
public class Conexao_ {

    public Connection conexao;
    public Statement statemet;
    public ResultSet resultset;
    public PreparedStatement prestatement;
    private  String driver = "org.gjt.mm.mysql.Driver";
    private  String url = "jdbc:mysql://localhost/controle_venda";
    private  String usuario = "root";
    private  String senha = "";

    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public boolean conecta_(){
        try{
            conexao = DriverManager.getConnection(url,usuario,senha);
            statemet = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
            
          } catch(Exception ex){
            return false;
      }
        return true;
    }

    public boolean desconecta(){
        
        try{
            conexao.close();
            JOptionPane.showMessageDialog(null, "Banco fechado");
        }catch(SQLException erroSQL){
            JOptionPane.showMessageDialog(null, "Não foi possivel" +"fechar o banco de dados:" +erroSQL.getMessage());
            return false;
        }
        
        return true;
    }

    public boolean execulteSQL(String sql){
        try{
            statemet = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = statemet.executeQuery(sql);
        }catch(SQLException sqlex){
            JOptionPane.showMessageDialog(null, "Não foi possivel\n" +"execultar o comando sql" +sqlex +"\no sql passado foi:\n" +sql);
            return false;
        }
        
        return true;

    }
}

