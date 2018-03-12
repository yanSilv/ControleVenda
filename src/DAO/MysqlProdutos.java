/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Conexao.Conexao_;
import Modelo.ModProdutos;
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
public class MysqlProdutos {
    
    Conexao_ conexao = new Conexao_();
    Connection conn = null;
    
    public boolean salvar (ModProdutos p) {
        try {
            conn = DriverManager.getConnection(this.conexao.getUrl(), this.conexao.getUsuario(), this.conexao.getSenha());
            String sql = "INSERT INTO tbProdutos (pro_descricao, pro_categoria, pro_valor_custo, pro_quantidade, pro_quantidade_brinde) VALUES (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getPro_descricao());
            ps.setString(2, p.getPro_categoria());
            ps.setDouble(3, p.getPro_valor_custo());
            ps.setInt(4, p.getPro_quantidade());
            ps.setInt(5, p.getPro_quantidade_brind());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MysqlProdutos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public boolean editar (ModProdutos p) {
        try {
            conn = DriverManager.getConnection(this.conexao.getUrl(), this.conexao.getUsuario(), this.conexao.getSenha());
            String sql = "UPDATE tbProdutos SET pro_descricao = ?, pro_categoria = ?, pro_valor_custo = ?, pro_quantidade = ?, pro_quantidade_brinde = ? WHERE pro_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getPro_descricao());
            ps.setString(2, p.getPro_categoria());
            ps.setDouble(3, p.getPro_valor_custo());
            ps.setInt(4, p.getPro_quantidade());
            ps.setInt(5, p.getPro_quantidade_brind());
            ps.setInt(6, p.getPro_id());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MysqlProdutos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public boolean deletar (ModProdutos p) {
        try {
            conn = DriverManager.getConnection(this.conexao.getUrl(), this.conexao.getUsuario(), this.conexao.getSenha());
            String sql = "DELETE FROM tbProdutos WHERE pro_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getPro_id());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MysqlProdutos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
            
        return true;
    }
    
    public ArrayList<ModProdutos> primeiro (ModProdutos p) {
        String sql = "SELECT * FROM tbProdutos ORDER BY pro_id ASC LIMIT 1";
        ArrayList<ModProdutos> resP = new ArrayList<ModProdutos>();
        ResultSet rs;
        
        try {
            conn = DriverManager.getConnection(this.conexao.getUrl(), this.conexao.getUsuario(), this.conexao.getSenha());
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getPro_id());
            rs = ps.executeQuery();
            if (rs.next()) {
                ModProdutos pro = new ModProdutos();
                pro.setPro_categoria(rs.getString("pro_categoria"));
                pro.setPro_descricao(rs.getString("pro_descricao"));
                pro.setPro_id(rs.getInt("pro_id"));
                pro.setPro_quantidade(rs.getInt("pro_quantidade"));
                pro.setPro_quantidade_brind(rs.getInt("pro_quantidade_brinde"));
                pro.setPro_valor_custo(rs.getDouble("pro_valor_custo"));
                resP.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MysqlProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resP;
    }
    
    public ArrayList<ModProdutos> anterior (ModProdutos p) {
        String sql = "SELECT * FROM tbProdutos WHERE pro_id = (SELECT MAX(pro_id) FROM  tbProdutos WHERE pro_id < ?)";
        ArrayList<ModProdutos> resP = new ArrayList<ModProdutos>();
        ResultSet rs;
        
        try {
            conn = DriverManager.getConnection(this.conexao.getUrl(), this.conexao.getUsuario(), this.conexao.getSenha());
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getPro_id());
            rs = ps.executeQuery();
            if (rs.next()) {
                ModProdutos pro = new ModProdutos();
                pro.setPro_categoria(rs.getString("pro_categoria"));
                pro.setPro_descricao(rs.getString("pro_descricao"));
                pro.setPro_id(rs.getInt("pro_id"));
                pro.setPro_quantidade(rs.getInt("pro_quantidade"));
                pro.setPro_quantidade_brind(rs.getInt("pro_quantidade_brinde"));
                pro.setPro_valor_custo(rs.getDouble("pro_valor_custo"));
                resP.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MysqlProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resP;
    }
    
    public ArrayList<ModProdutos> proximo (ModProdutos p) {
        String sql = "SELECT * FROM tbProdutos WHERE pro_id = (SELECT MAX(pro_id) FROM  tbProdutos WHERE pro_id < ?)";
        ArrayList<ModProdutos> resP = new ArrayList<ModProdutos>();
        ResultSet rs;
        
        try {
            conn = DriverManager.getConnection(this.conexao.getUrl(), this.conexao.getUsuario(), this.conexao.getSenha());
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getPro_id());
            rs = ps.executeQuery();
            if (rs.next()) {
                ModProdutos pro = new ModProdutos();
                pro.setPro_categoria(rs.getString("pro_categoria"));
                pro.setPro_descricao(rs.getString("pro_descricao"));
                pro.setPro_id(rs.getInt("pro_id"));
                pro.setPro_quantidade(rs.getInt("pro_quantidade"));
                pro.setPro_quantidade_brind(rs.getInt("pro_quantidade_brinde"));
                pro.setPro_valor_custo(rs.getDouble("pro_valor_custo"));
                resP.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MysqlProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resP;
    }
    
    public ArrayList<ModProdutos> ultimo (ModProdutos p) {
        String sql = "SELECT * FROM tbProdutos ORDER BY pro_id DESC LIMIT 1";
        ArrayList<ModProdutos> resP = new ArrayList<ModProdutos>();
        ResultSet rs;
        
        try {
            conn = DriverManager.getConnection(this.conexao.getUrl(), this.conexao.getUsuario(), this.conexao.getSenha());
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getPro_id());
            rs = ps.executeQuery();
            if (rs.next()) {
                ModProdutos pro = new ModProdutos();
                pro.setPro_categoria(rs.getString("pro_categoria"));
                pro.setPro_descricao(rs.getString("pro_descricao"));
                pro.setPro_id(rs.getInt("pro_id"));
                pro.setPro_quantidade(rs.getInt("pro_quantidade"));
                pro.setPro_quantidade_brind(rs.getInt("pro_quantidade_brinde"));
                pro.setPro_valor_custo(rs.getDouble("pro_valor_custo"));
                resP.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MysqlProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resP;
    }
    
    public ArrayList<ModProdutos> todosProdutos () {
        String sql = "SELECT * FROM tbProdutos ORDER BY pro_id";
        ArrayList<ModProdutos> resP = new ArrayList<ModProdutos>();
        ResultSet rs;
        
        try {
            conn = DriverManager.getConnection(this.conexao.getUrl(), this.conexao.getUsuario(), this.conexao.getSenha());
            PreparedStatement ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ModProdutos pro = new ModProdutos();
                pro.setPro_categoria(rs.getString("pro_categoria"));
                pro.setPro_descricao(rs.getString("pro_descricao"));
                pro.setPro_id(rs.getInt("pro_id"));
                pro.setPro_quantidade(rs.getInt("pro_quantidade"));
                pro.setPro_quantidade_brind(rs.getInt("pro_quantidade_brinde"));
                pro.setPro_valor_custo(rs.getDouble("pro_valor_custo"));
                resP.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MysqlProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resP;
    }
    
    public ArrayList<ModProdutos> nomeProdutos (ModProdutos p, int opcao) {
        
        String sql = "";
       
        if (opcao == 0)
            sql = "SELECT * FROM tbProdutos WHERE pro_descricao LIKE ? ORDER BY pro_id";
        else
            sql = "SELECT * FROM tbProdutos WHERE pro_id = ? ORDER BY pro_id";
            
        ArrayList<ModProdutos> resP = new ArrayList<ModProdutos>();
        ResultSet rs;
        System.out.println(p.getPro_id()+"  "+opcao+"  "+p.getPro_descricao());
        try {
            conn = DriverManager.getConnection(this.conexao.getUrl(), this.conexao.getUsuario(), this.conexao.getSenha());
            PreparedStatement ps = conn.prepareStatement(sql);
            if (opcao == 0)
                ps.setString(1, "%"+p.getPro_descricao()+"%");
            else 
                ps.setInt(1, p.getPro_id());
            
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("linha 232");
                ModProdutos pro = new ModProdutos();
                pro.setPro_categoria(rs.getString("pro_categoria"));
                pro.setPro_descricao(rs.getString("pro_descricao"));
                pro.setPro_id(rs.getInt("pro_id"));
                pro.setPro_quantidade(rs.getInt("pro_quantidade"));
                pro.setPro_quantidade_brind(rs.getInt("pro_quantidade_brinde"));
                pro.setPro_valor_custo(rs.getDouble("pro_valor_custo"));
                resP.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MysqlProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resP;
    }
}
