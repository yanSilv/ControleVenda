/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 *
 * @author jaguar
 */
public class ModVendas {
    private int      ven_id;
    private ModVendedor tbVendedor_vend_id;
    private String   ven_form_pagamento;
    private String   ven_opcao_pagamento;
    private int      ven_qtd_parcela;
    private double   ven_valor_venda;
    private double   ven_valor_pagamento;
    private char     ven_venda_status;
    private double   ven_desconto_percent;
    private double   ven_descont;
    
    

    public int getVen_id() {
        return ven_id;
    }

    public void setVen_id(int ven_id) {
        this.ven_id = ven_id;
    }

    public ModVendedor getTbVendedor_vend_id() {
        return tbVendedor_vend_id;
    }

    public void setTbVendedor_vend_id(ModVendedor tbVendedor_vend_id) {
        this.tbVendedor_vend_id = tbVendedor_vend_id;
    }

    public String getVen_form_pagamento() {
        return ven_form_pagamento;
    }

    public void setVen_form_pagamento(String ven_form_pagamento) {
        this.ven_form_pagamento = ven_form_pagamento;
    }

    public String getVen_opcao_pagamento() {
        return ven_opcao_pagamento;
    }

    public void setVen_opcao_pagamento(String ven_opcao_pagamento) {
        this.ven_opcao_pagamento = ven_opcao_pagamento;
    }

    public int getVen_qtd_parcela() {
        return ven_qtd_parcela;
    }

    public void setVen_qtd_parcela(int ven_qtd_parcela) {
        this.ven_qtd_parcela = ven_qtd_parcela;
    }

    public double getVen_valor_venda() {
        return ven_valor_venda;
    }

    public void setVen_valor_venda(double ven_valor_venda) {
        this.ven_valor_venda = ven_valor_venda;
    }

    public double getVen_valor_pagamento() {
        return ven_valor_pagamento;
    }

    public void setVen_valor_pagamento(double ven_valor_pagamento) {
        this.ven_valor_pagamento = ven_valor_pagamento;
    }

    public char getVen_venda_status() {
        return ven_venda_status;
    }

    public void setVen_venda_status(char ven_venda_status) {
        this.ven_venda_status = ven_venda_status;
    }

    public double getVen_desconto_percent() {
        return ven_desconto_percent;
    }

    public void setVen_desconto_percent(double ven_desconto_percent) {
        this.ven_desconto_percent = ven_desconto_percent;
    }

    public double getVen_descont() {
        return ven_descont;
    }

    public void setVen_descont(double ven_descont) {
        this.ven_descont = ven_descont;
    }
    
    

}
