/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.Conexao_;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jaguar
 */
public class ControleVendaDB {

    Conexao_ conexao = new Conexao_();
    Connection conn = null;
    Statement stm = null;

    public void criaDB() {
        String sql = "";
        String url = "jdbc:mysql://localhost/";
        try {
            conn = DriverManager.getConnection(url, this.conexao.getUsuario(), this.conexao.getSenha());
            stm = conn.createStatement();

            sql = "CREATE DATABASE controle_venda";

            stm.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ControleVendaDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Verifique se o serviços do MySql esta em execução!!!");
            System.exit(0);
        }

    }

    public void construirBD() {

        String produtos = "CREATE TABLE tbProdutos (\n"
                + "  pro_id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,\n"
                + "  pro_descricao VARCHAR(255) NULL,\n"
                + "  pro_categoria VARCHAR(255) NULL,\n"
                + "  pro_valor_custo DECIMAL NULL,\n"
                + "  pro_quantidade INTEGER UNSIGNED NULL,\n"
                + "  pro_quantidade_brinde INTEGER UNSIGNED NULL,\n"
                + "  PRIMARY KEY(pro_id)\n"
                + ");";

        String vendas = "CREATE TABLE tbVenda (\n"
                + "  ven_id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,\n"
                + "  tbVendedor_vend_id INTEGER UNSIGNED NOT NULL,\n"
                + "  ven_form_pagamento VARCHAR(45) NULL,\n"
                + "  ven_opcao_pagamento CHAR NULL,\n"
                + "  ven_qtd_parcela INTEGER UNSIGNED NULL,\n"
                + "  ven_valor_venda DECIMAL NULL,\n"
                + "  ven_valor_pagamento DECIMAL NULL,\n"
                + "  ven_venda_status CHAR NULL,\n"
                + "  ven_desconto_percent DOUBLE NULL,\n"
                + "  ven_desconto DECIMAL NULL,\n"
                + "  PRIMARY KEY(ven_id),\n"
                + "  INDEX tbVenda_FKIndex1(tbVendedor_vend_id)\n"
                + ");";

        String vendedor = "CREATE TABLE tbVendedor (\n"
                + "  vend_id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,\n"
                + "  vend_nome VARCHAR(255) NULL,\n"
                + "  vend_endereco VARCHAR(255) NULL,\n"
                + "  vend_sexo CHAR NULL,\n"
                + "  vend_telefone VARCHAR(45) NULL,\n"
                + "  vend_login VARCHAR(45) NULL,\n"
                + "  vend_senha VARCHAR(255) NULL,\n"
                + "  PRIMARY KEY(vend_id)\n"
                + ");";

        String produtos_vendas = "CREATE TABLE tbProdutos_has_tbVenda (\n"
                + "  tbProdutos_pro_id INTEGER UNSIGNED NOT NULL,\n"
                + "  tbVenda_ven_id INTEGER UNSIGNED NOT NULL,\n"
                + "  PRIMARY KEY(tbProdutos_pro_id, tbVenda_ven_id),\n"
                + "  INDEX tbProdutos_has_tbVenda_FKIndex1(tbProdutos_pro_id),\n"
                + "  INDEX tbProdutos_has_tbVenda_FKIndex2(tbVenda_ven_id)\n"
                + ");";

        try {
            conn = DriverManager.getConnection(this.conexao.getUrl(), this.conexao.getUsuario(), this.conexao.getSenha());
            stm = conn.createStatement();
            stm.executeUpdate(produtos);
            stm.executeUpdate(vendas);
            stm.executeUpdate(vendedor);
            stm.executeUpdate(produtos_vendas);
        } catch (SQLException ex) {
            Logger.getLogger(ControleVendaDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void insereAdm() {
        String sql = "INSERT INTO tbVendedor (vend_nome, vend_endereco, vend_sexo, vend_telefone, vend_login, vend_senha) VALUES (?,?,?,?,?,?)";
        try {
            conn = DriverManager.getConnection(this.conexao.getUrl(), this.conexao.getUsuario(), this.conexao.getSenha());
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "Administrador");
            ps.setString(2, "");
            ps.setString(3, "");
            ps.setString(4, "");
            ps.setString(5, "admin");
            ps.setString(6, "409314");
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ControleVendaDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
