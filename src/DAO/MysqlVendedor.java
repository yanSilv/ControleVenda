/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Conexao.Conexao_;
import Modelo.ModVendedor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jaguar
 */
public class MysqlVendedor {
    
    Conexao_ conexao = new Conexao_();
    Connection conn = null;
    
    public boolean salvar (ModVendedor v) {
        try {
            conn = DriverManager.getConnection(this.conexao.getUrl(), this.conexao.getUsuario(), this.conexao.getSenha());
            String sql = "INSERT INTO tbVendedor (vend_nome , vend_endereco , vend_sexo, vend_telefone , vend_login , vend_senha ) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, v.getVend_nome());
            ps.setString(2, v.getVend_endereco());
            ps.setString(3, String.valueOf(v.getVend_sex()));
            ps.setString(4, v.getVend_telefone());
            ps.setString(5, v.getVend_login());
            ps.setString(6, v.getVend_senha());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MysqlProdutos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public boolean editar (ModVendedor v) {
        try {
            conn = DriverManager.getConnection(this.conexao.getUrl(), this.conexao.getUsuario(), this.conexao.getSenha());
            String sql = "UPDATE tbVendedor SET vend_nome = ?, vend_endereco = ?, vend_sexo = ?, vend_telefone = ?, vend_login = ?, vend_senha = ? WHERE vend_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, v.getVend_nome());
            ps.setString(2, v.getVend_endereco());
            ps.setString(3, v.getVend_sex());
            ps.setString(4, v.getVend_telefone());
            ps.setString(5, v.getVend_login());
            ps.setString(6, v.getVend_senha());
            ps.setInt(7, v.getVend_id());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MysqlProdutos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public boolean deletar (ModVendedor v) {
        try {
            conn = DriverManager.getConnection(this.conexao.getUrl(), this.conexao.getUsuario(), this.conexao.getSenha());
            String sql = "DELETE FROM tbVendedor WHERE vend_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, v.getVend_id());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MysqlProdutos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
            
        return true;
    }
    
    public ArrayList<ModVendedor> primeiro (ModVendedor v) {
        String sql = "SELECT * FROM tbVendedor ORDER BY vend_id ASC LIMIT 1";
        ArrayList<ModVendedor> resP = new ArrayList<ModVendedor>();
        ResultSet rs;
        
        try {
            conn = DriverManager.getConnection(this.conexao.getUrl(), this.conexao.getUsuario(), this.conexao.getSenha());
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, v.getVend_id());
            rs = ps.executeQuery();
            if (rs.next()) {
                ModVendedor ven = new ModVendedor();
                ven.setVend_endereco(rs.getString("vend_endereco"));
                ven.setVend_id(rs.getInt("vend_id"));
                ven.setVend_login(rs.getString("vend_login"));
                ven.setVend_nome(rs.getString("vend_nome"));
                ven.setVend_senha(rs.getString("vend_senha"));
                ven.setVend_sex(rs.getString("vend_sexo"));
                ven.setVend_telefone(rs.getString("vend_telefone"));
                resP.add(ven);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MysqlProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resP;
    }
    
    public ArrayList<ModVendedor> anterior (ModVendedor v) {
        String sql = "SELECT * FROM tbVendedor WHERE vend_id = (SELECT MAX(vend_id) FROM  tbVendedor WHERE vend_id < ?)";
        ArrayList<ModVendedor> resP = new ArrayList<ModVendedor>();
        ResultSet rs;
        
        try {
            conn = DriverManager.getConnection(this.conexao.getUrl(), this.conexao.getUsuario(), this.conexao.getSenha());
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, v.getVend_id());
            rs = ps.executeQuery();
            if (rs.next()) {
                ModVendedor ven = new ModVendedor();
                ven.setVend_endereco(rs.getString("vend_endereco"));
                ven.setVend_id(rs.getInt("vend_id"));
                ven.setVend_login(rs.getString("vend_login"));
                ven.setVend_nome(rs.getString("vend_nome"));
                ven.setVend_senha(rs.getString("vend_senha"));
                ven.setVend_sex(rs.getString("vend_sexo"));
                ven.setVend_telefone(rs.getString("vend_telefone"));
                resP.add(ven);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MysqlProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resP;
    }
    
    public ArrayList<ModVendedor> proximo (ModVendedor v) {
        String sql = "SELECT * FROM tbVendedor WHERE vend_id = (SELECT MAX(vend_id) FROM  tbVendedor WHERE vend_id < ?)";
        ArrayList<ModVendedor> resP = new ArrayList<ModVendedor>();
        ResultSet rs;
        
        try {
            conn = DriverManager.getConnection(this.conexao.getUrl(), this.conexao.getUsuario(), this.conexao.getSenha());
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, v.getVend_id());
            rs = ps.executeQuery();
            if (rs.next()) {
                ModVendedor ven = new ModVendedor();
                ven.setVend_endereco(rs.getString("vend_endereco"));
                ven.setVend_id(rs.getInt("vend_id"));
                ven.setVend_login(rs.getString("vend_login"));
                ven.setVend_nome(rs.getString("vend_nome"));
                ven.setVend_senha(rs.getString("vend_senha"));
                ven.setVend_sex(rs.getString("vend_sexo"));
                ven.setVend_telefone(rs.getString("vend_telefone"));
                resP.add(ven);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MysqlProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resP;
    }
    
    public ArrayList<ModVendedor> ultimo (ModVendedor v) {
        String sql = "SELECT * FROM tbVendedor ORDER BY vend_id DESC LIMIT 1";
        ArrayList<ModVendedor> resP = new ArrayList<ModVendedor>();
        ResultSet rs;
        
        try {
            conn = DriverManager.getConnection(this.conexao.getUrl(), this.conexao.getUsuario(), this.conexao.getSenha());
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, v.getVend_id());
            rs = ps.executeQuery();
            if (rs.next()) {
                ModVendedor ven = new ModVendedor();
                ven.setVend_endereco(rs.getString("vend_endereco"));
                ven.setVend_id(rs.getInt("vend_id"));
                ven.setVend_login(rs.getString("vend_login"));
                ven.setVend_nome(rs.getString("vend_nome"));
                ven.setVend_senha(rs.getString("vend_senha"));
                ven.setVend_sex(rs.getString("vend_sexo"));
                ven.setVend_telefone(rs.getString("vend_telefone"));
                resP.add(ven);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MysqlProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resP;
    }
    
    public ArrayList<ModVendedor> todosVendedores () {
        String sql = "SELECT * FROM tbVendedor";
        ArrayList<ModVendedor> resP = new ArrayList<ModVendedor>();
        ResultSet rs;
        
        try {
            conn = DriverManager.getConnection(this.conexao.getUrl(), this.conexao.getUsuario(), this.conexao.getSenha());
            PreparedStatement ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ModVendedor ven = new ModVendedor();
                ven.setVend_endereco(rs.getString("vend_endereco"));
                ven.setVend_id(rs.getInt("vend_id"));
                ven.setVend_login(rs.getString("vend_login"));
                ven.setVend_nome(rs.getString("vend_nome"));
                ven.setVend_senha(rs.getString("vend_senha"));
                ven.setVend_sex(rs.getString("vend_sexo"));
                ven.setVend_telefone(rs.getString("vend_telefone"));
                resP.add(ven);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MysqlProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(resP.size());
        return resP;
    }

    public ArrayList<ModVendedor> vendedores(ModVendedor vend, int opcao) {
        
        String sql;
        ArrayList<ModVendedor> resP = new ArrayList<ModVendedor>();
        ResultSet rs;
            sql = "SELECT * FROM tbVendedor";
        try {
            conn = DriverManager.getConnection(this.conexao.getUrl(), this.conexao.getUsuario(), this.conexao.getSenha());
            PreparedStatement ps; 
            if(opcao == 0) {
                sql = "SELECT * FROM tbVendedor WHERE vend_id = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, vend.getVend_id());
            } else {
                sql = "SELECT * FROM tbVendedor WHERE vend_nome LIKE ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, vend.getVend_nome());
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                ModVendedor ven = new ModVendedor();
                ven.setVend_endereco(rs.getString("vend_endereco"));
                ven.setVend_id(rs.getInt("vend_id"));
                ven.setVend_login(rs.getString("vend_login"));
                ven.setVend_nome(rs.getString("vend_nome"));
                ven.setVend_senha(rs.getString("vend_senha"));
                ven.setVend_sex(rs.getString("vend_sexo"));
                ven.setVend_telefone(rs.getString("vend_telefone"));
                resP.add(ven);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MysqlProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(resP.size());
        return resP;
    }

    public ModVendedor login(ModVendedor vend) {
        String sql = "SELECT * FROM tbVendedor WHERE vend_login = ? AND vend_senha = ?";
        ModVendedor resP = new ModVendedor();
        ResultSet rs;
        
        try {
            conn = DriverManager.getConnection(this.conexao.getUrl(), this.conexao.getUsuario(), this.conexao.getSenha());
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, vend.getVend_login());
            ps.setString(2, vend.getVend_senha());
            rs = ps.executeQuery();
            if (rs.next()) {
                resP.setVend_endereco(rs.getString("vend_endereco"));
                resP.setVend_id(rs.getInt("vend_id"));
                resP.setVend_login(rs.getString("vend_login"));
                resP.setVend_nome(rs.getString("vend_nome"));
                resP.setVend_senha(rs.getString("vend_senha"));
                resP.setVend_sex(rs.getString("vend_sexo"));
                resP.setVend_telefone(rs.getString("vend_telefone"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MysqlProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resP;
    }
    
}
