/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import DAO.MysqlProdutos;
import Modelo.ModProdutos;
import java.util.ArrayList;

/**
 *
 * @author jaguar
 */
public class CtrProdutos {
    
    MysqlProdutos mysql;
    
    public CtrProdutos () {
        mysql = new MysqlProdutos();
    }

    public boolean salvar(ModProdutos pro) {
        return mysql.salvar(pro);
    }
    
    public ArrayList<ModProdutos> todosProdutos () {
        return mysql.todosProdutos();
    }

    public ArrayList<ModProdutos> pesquisaProduto(ModProdutos p, int opcao) {
        if (opcao == 0)
            return mysql.nomeProdutos(p, opcao);
        else
            return mysql.nomeProdutos(p, opcao);
        
    }

    public boolean editar(ModProdutos pro) {
        return mysql.editar(pro);
    }

    public boolean deletar(ModProdutos pro) {
        return mysql.deletar(pro);
    }
    
}
