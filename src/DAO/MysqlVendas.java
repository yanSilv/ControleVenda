/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Conexao.Conexao_;
import Modelo.ModVendas;
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
public class MysqlVendas {
    
     Conexao_ conexao = new Conexao_();
    Connection conn = null;
    
    public boolean salvar (ModVendas v) {
        try {
            conn = DriverManager.getConnection(this.conexao.getUrl(), this.conexao.getUsuario(), this.conexao.getSenha());
            String sql = "INSERT INTO tbVenda (tbVendedor_vend_id ,ven_form_pagamento ,ven_opcao_pagamento ,ven_qtd_parcela ,ven_valor_venda ,ven_valor_pagamento ,ven_venda_status ,ven_desconto_percent ,ven_descon) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, v.getTbVendedor_vend_id().getVend_id());
            ps.setString(2, v.getVen_form_pagamento());
            ps.setString(3, v.getVen_opcao_pagamento());
            ps.setInt(4, v.getVen_qtd_parcela());
            ps.setDouble(5, v.getVen_valor_venda());
            ps.setDouble(6, v.getVen_valor_pagamento());
            ps.setDouble(7, v.getVen_venda_status());
            ps.setDouble(8, v.getVen_desconto_percent());
            ps.setDouble(9, v.getVen_descont());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MysqlProdutos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public boolean editar (ModVendas v) {
        try {
            conn = DriverManager.getConnection(this.conexao.getUrl(), this.conexao.getUsuario(), this.conexao.getSenha());
            String sql = "UPDATE tbVenda SET tbVendedor_vend_id = ? ,ven_form_pagamento = ? ,ven_opcao_pagamento = ? ,ven_qtd_parcela = ? ,ven_valor_venda = ? ,ven_valor_pagamento = ? ,ven_venda_status = ? ,ven_desconto_percent = ? ,ven_descont = ? WHERE ven_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, v.getTbVendedor_vend_id().getVend_id());
            ps.setString(2, v.getVen_form_pagamento());
            ps.setString(3, v.getVen_opcao_pagamento());
            ps.setInt(4, v.getVen_qtd_parcela());
            ps.setDouble(5, v.getVen_valor_venda());
            ps.setDouble(6, v.getVen_valor_pagamento());
            ps.setDouble(7, v.getVen_venda_status());
            ps.setDouble(8, v.getVen_desconto_percent());
            ps.setDouble(9, v.getVen_descont());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MysqlProdutos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public boolean deletar (ModVendas v) {
        try {
            conn = DriverManager.getConnection(this.conexao.getUrl(), this.conexao.getUsuario(), this.conexao.getSenha());
            String sql = "DELETE FROM tbVenda WHERE ven_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, v.getVen_id());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MysqlProdutos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
            
        return true;
    }
    
    public ArrayList<ModVendas> primeiro (ModVendas v) {
        String sql = "SELECT * FROM tbVendedor ORDER BY vend_id ASC LIMIT 1";
        ArrayList<ModVendas> resP = new ArrayList<ModVendas>();
        ResultSet rs;
        
        try {
            conn = DriverManager.getConnection(this.conexao.getUrl(), this.conexao.getUsuario(), this.conexao.getSenha());
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, v.getVen_id());
            rs = ps.executeQuery();
            if (rs.next()) {
                ModVendedor ven = new ModVendedor();
                ModVendas   vend = new ModVendas();
                ven.setVend_endereco(rs.getString("vend_endereco"));
                ven.setVend_id(rs.getInt("vend_id"));
                ven.setVend_login(rs.getString("vend_login"));
                ven.setVend_nome(rs.getString("vend_nome"));
                ven.setVend_senha(rs.getString("vend_senha"));
                ven.setVend_sex(rs.getString("vend_sexo"));
                ven.setVend_telefone(rs.getString("vend_telefone"));
                vend.setTbVendedor_vend_id(ven);
                vend.setVen_descont(rs.getDouble("ven_descont"));
                vend.setVen_desconto_percent(rs.getDouble("ven_desconto_percent"));
                vend.setVen_form_pagamento(rs.getString("ven_form_pagamento"));
                vend.setVen_id(rs.getInt("ven_id"));
                vend.setVen_opcao_pagamento(rs.getString("ven_opcao_pagamento"));
                vend.setVen_qtd_parcela(rs.getInt("ven_qtd_parcela"));
                vend.setVen_valor_pagamento(rs.getDouble("ven_valor_pagamento"));
                vend.setVen_valor_venda(rs.getDouble("ven_valor_pagamento"));
                vend.setVen_venda_status((char) rs.getDouble("ven_venda_status"));
                
                resP.add(vend);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MysqlProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resP;
    }
    
    public ArrayList<ModVendas> anterior (ModVendas v) {
        String sql = "SELECT * FROM tbVenda WHERE ven_id = (SELECT MAX(ven_id) FROM  tbVenda WHERE ven_id < ?)";
        ArrayList<ModVendas> resP = new ArrayList<ModVendas>();
        ResultSet rs;
        
        try {
            conn = DriverManager.getConnection(this.conexao.getUrl(), this.conexao.getUsuario(), this.conexao.getSenha());
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, v.getVen_id());
            rs = ps.executeQuery();
            if (rs.next()) {
                ModVendedor ven = new ModVendedor();
                ModVendas   vend = new ModVendas();
                ven.setVend_endereco(rs.getString("vend_endereco"));
                ven.setVend_id(rs.getInt("vend_id"));
                ven.setVend_login(rs.getString("vend_login"));
                ven.setVend_nome(rs.getString("vend_nome"));
                ven.setVend_senha(rs.getString("vend_senha"));
                ven.setVend_sex(rs.getString("vend_sexo"));
                ven.setVend_telefone(rs.getString("vend_telefone"));
                vend.setTbVendedor_vend_id(ven);
                vend.setVen_descont(rs.getDouble("ven_descont"));
                vend.setVen_desconto_percent(rs.getDouble("ven_desconto_percent"));
                vend.setVen_form_pagamento(rs.getString("ven_form_pagamento"));
                vend.setVen_id(rs.getInt("ven_id"));
                vend.setVen_opcao_pagamento(rs.getString("ven_opcao_pagamento"));
                vend.setVen_qtd_parcela(rs.getInt("ven_qtd_parcela"));
                vend.setVen_valor_pagamento(rs.getDouble("ven_valor_pagamento"));
                vend.setVen_valor_venda(rs.getDouble("ven_valor_pagamento"));
                vend.setVen_venda_status((char) rs.getDouble("ven_venda_status"));
                
                resP.add(vend);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MysqlProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resP;
    }
    
    public ArrayList<ModVendas> proximo (ModVendas v) {
         String sql = "SELECT * FROM tbVenda WHERE ven_id = (SELECT MAX(ven_id) FROM  tbVenda WHERE ven_id < ?)";
        ArrayList<ModVendas> resP = new ArrayList<ModVendas>();
        ResultSet rs;
        
        try {
            conn = DriverManager.getConnection(this.conexao.getUrl(), this.conexao.getUsuario(), this.conexao.getSenha());
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, v.getVen_id());
            rs = ps.executeQuery();
            if (rs.next()) {
                ModVendedor ven = new ModVendedor();
                ModVendas   vend = new ModVendas();
                ven.setVend_endereco(rs.getString("vend_endereco"));
                ven.setVend_id(rs.getInt("vend_id"));
                ven.setVend_login(rs.getString("vend_login"));
                ven.setVend_nome(rs.getString("vend_nome"));
                ven.setVend_senha(rs.getString("vend_senha"));
                ven.setVend_sex(rs.getString("vend_sexo"));
                ven.setVend_telefone(rs.getString("vend_telefone"));
                vend.setTbVendedor_vend_id(ven);
                vend.setVen_descont(rs.getDouble("ven_descont"));
                vend.setVen_desconto_percent(rs.getDouble("ven_desconto_percent"));
                vend.setVen_form_pagamento(rs.getString("ven_form_pagamento"));
                vend.setVen_id(rs.getInt("ven_id"));
                vend.setVen_opcao_pagamento(rs.getString("ven_opcao_pagamento"));
                vend.setVen_qtd_parcela(rs.getInt("ven_qtd_parcela"));
                vend.setVen_valor_pagamento(rs.getDouble("ven_valor_pagamento"));
                vend.setVen_valor_venda(rs.getDouble("ven_valor_pagamento"));
                vend.setVen_venda_status((char) rs.getDouble("ven_venda_status"));
                
                resP.add(vend);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MysqlProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resP;
    }
    
    public ArrayList<ModVendas> ultimo (ModVendas v) {
        String sql = "SELECT * FROM tbVenda ORDER BY ven_id DESC LIMIT 1";
        ArrayList<ModVendas> resP = new ArrayList<ModVendas>();
        ResultSet rs;
        
        try {
            conn = DriverManager.getConnection(this.conexao.getUrl(), this.conexao.getUsuario(), this.conexao.getSenha());
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, v.getVen_id());
            rs = ps.executeQuery();
            if (rs.next()) {
                ModVendedor ven = new ModVendedor();
                ModVendas   vend = new ModVendas();
                ven.setVend_endereco(rs.getString("vend_endereco"));
                ven.setVend_id(rs.getInt("vend_id"));
                ven.setVend_login(rs.getString("vend_login"));
                ven.setVend_nome(rs.getString("vend_nome"));
                ven.setVend_senha(rs.getString("vend_senha"));
                ven.setVend_sex(rs.getString("vend_sexo"));
                ven.setVend_telefone(rs.getString("vend_telefone"));
                vend.setTbVendedor_vend_id(ven);
                vend.setVen_descont(rs.getDouble("ven_descont"));
                vend.setVen_desconto_percent(rs.getDouble("ven_desconto_percent"));
                vend.setVen_form_pagamento(rs.getString("ven_form_pagamento"));
                vend.setVen_id(rs.getInt("ven_id"));
                vend.setVen_opcao_pagamento(rs.getString("ven_opcao_pagamento"));
                vend.setVen_qtd_parcela(rs.getInt("ven_qtd_parcela"));
                vend.setVen_valor_pagamento(rs.getDouble("ven_valor_pagamento"));
                vend.setVen_valor_venda(rs.getDouble("ven_valor_pagamento"));
                vend.setVen_venda_status((char) rs.getDouble("ven_venda_status"));
                
                resP.add(vend);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MysqlProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resP;
    }
    
    public ArrayList<ModVendas> todosProdutos (ModVendas v) {
        String sql = "SELECT * FROM tbVenda ORDER BY ven_id";
        ArrayList<ModVendas> resP = new ArrayList<ModVendas>();
        ResultSet rs;
        
        try {
            conn = DriverManager.getConnection(this.conexao.getUrl(), this.conexao.getUsuario(), this.conexao.getSenha());
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, v.getVen_id());
            rs = ps.executeQuery();
            if (rs.next()) {
                ModVendedor ven = new ModVendedor();
                ModVendas   vend = new ModVendas();
                ven.setVend_endereco(rs.getString("vend_endereco"));
                ven.setVend_id(rs.getInt("vend_id"));
                ven.setVend_login(rs.getString("vend_login"));
                ven.setVend_nome(rs.getString("vend_nome"));
                ven.setVend_senha(rs.getString("vend_senha"));
                ven.setVend_sex(rs.getString("vend_sexo"));
                ven.setVend_telefone(rs.getString("vend_telefone"));
                vend.setTbVendedor_vend_id(ven);
                vend.setVen_descont(rs.getDouble("ven_descont"));
                vend.setVen_desconto_percent(rs.getDouble("ven_desconto_percent"));
                vend.setVen_form_pagamento(rs.getString("ven_form_pagamento"));
                vend.setVen_id(rs.getInt("ven_id"));
                vend.setVen_opcao_pagamento(rs.getString("ven_opcao_pagamento"));
                vend.setVen_qtd_parcela(rs.getInt("ven_qtd_parcela"));
                vend.setVen_valor_pagamento(rs.getDouble("ven_valor_pagamento"));
                vend.setVen_valor_venda(rs.getDouble("ven_valor_pagamento"));
                vend.setVen_venda_status((char) rs.getDouble("ven_venda_status"));
                
                resP.add(vend);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MysqlProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resP;
    }
    
}
