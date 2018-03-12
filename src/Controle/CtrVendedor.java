/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import DAO.MysqlVendedor;
import Modelo.ModVendedor;
import java.util.ArrayList;

/**
 *
 * @author jaguar
 */
public class CtrVendedor {
    
    MysqlVendedor mysql;
    
    public CtrVendedor () {
        mysql = new MysqlVendedor();
    }
    
    public ArrayList<ModVendedor> todosVendedores () {
        ArrayList<ModVendedor> modVen = new ArrayList<ModVendedor>();
        modVen = mysql.todosVendedores();
        modVen = desconcatenaEndereco(modVen);
        return modVen;
    }

    public boolean salvar(ModVendedor ven) {
        ven = concatenaEndereco(ven);
        return mysql.salvar(ven);
    }

    public boolean editar(ModVendedor ven) {
        ven = concatenaEndereco(ven);
        return mysql.editar(ven);
    }

    public boolean deletar(ModVendedor ven) {
        return mysql.deletar(ven);
    }

    public ArrayList<ModVendedor> pesquisaVendedor(ModVendedor ven, int opcao) {
        if (opcao == 0)
            return mysql.vendedores(ven, opcao);
        else
            return mysql.vendedores(ven, opcao);
    }

    private ModVendedor concatenaEndereco(ModVendedor ven) {
        String endereco = ven.getVend_endereco();
        String bairro   = ven.getVend_bairro();
        String cidade   = ven.getVend_cidade();
        String estado   = ven.getVend_estado();
        
        String aux = "";
        
        aux = endereco +";"+bairro+";"+cidade+";"+estado;
        System.out.println("aux ---"+aux);
        ven.setVend_endereco(aux);
        
        return ven;
    }

    private ArrayList<ModVendedor> desconcatenaEndereco(ArrayList<ModVendedor> modVen) {
        for (int i = 0; i < modVen.size(); i++) {
            String aux[] = modVen.get(i).getVend_endereco().split(";");
            System.out.println(aux.length);
            if (aux.length > 3) {
                modVen.get(i).setVend_endereco(aux[0]);
                modVen.get(i).setVend_bairro(aux[1]);
                modVen.get(i).setVend_cidade(aux[2]);
                modVen.get(i).setVend_estado(aux[3]);
            }
            
        }
        
        return modVen;
    }
    
}
