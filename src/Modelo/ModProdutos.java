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
public class ModProdutos {
    
    private int pro_id;
    private String pro_descricao; 
    private String pro_categoria; 
    private double pro_valor_custo;
    private int    pro_quantidade; 
    private int    pro_quantidade_brind;

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_descricao() {
        return pro_descricao;
    }

    public void setPro_descricao(String pro_descricao) {
        this.pro_descricao = pro_descricao;
    }

    public String getPro_categoria() {
        return pro_categoria;
    }

    public void setPro_categoria(String pro_categoria) {
        this.pro_categoria = pro_categoria;
    }

    public double getPro_valor_custo() {
        return pro_valor_custo;
    }

    public void setPro_valor_custo(double pro_valor_custo) {
        this.pro_valor_custo = pro_valor_custo;
    }

    public int getPro_quantidade() {
        return pro_quantidade;
    }

    public void setPro_quantidade(int pro_quantidade) {
        this.pro_quantidade = pro_quantidade;
    }

    public int getPro_quantidade_brind() {
        return pro_quantidade_brind;
    }

    public void setPro_quantidade_brind(int pro_quantidade_brind) {
        this.pro_quantidade_brind = pro_quantidade_brind;
    }
    
    
    
}
