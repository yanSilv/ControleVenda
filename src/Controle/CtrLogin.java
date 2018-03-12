/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import Modelo.ModVendedor;
import DAO.MysqlVendedor;

/**
 *
 * @author jaguar
 */
public class CtrLogin {
    
    MysqlVendedor mysql;
    
    public CtrLogin () {
        this.mysql = new MysqlVendedor();
    }

    public ModVendedor login(ModVendedor ven) {
        return this.mysql.login(ven);
    }
    
}
