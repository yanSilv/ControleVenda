/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Visao;

import java.awt.Dimension;
import Modelo.ModVendedor;
import Modelo.ModProdutos;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Controle.CtrProdutos;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author jaguar
 */
public class Vendas extends javax.swing.JInternalFrame {
    
    ModVendedor modVen;
    ModProdutos modPro;
    CtrProdutos ctrPro;
    
    //Acumula todos os produtos da pesquisa;
    ArrayList<ModProdutos> arrayPro;
    
    //Guarda os produtos da venda;
    ArrayList<ModProdutos> arrayProVenda;
    
    /**
     * Creates new form Vendas
     */
    public Vendas(ModVendedor modVen) {
        initComponents();
        this.modVen = modVen;
        modPro = new ModProdutos();
        ctrPro = new CtrProdutos();
        arrayPro = new ArrayList<ModProdutos>();
        arrayProVenda = new ArrayList<ModProdutos>();
        tfQuantidade.setText("1");
        tfQuantParcela.setEnabled(false);
        jlPercentualDesconto.setText("0.00%");
    }
    
    public void setPosicao() {  
        Dimension d = this.getDesktopPane().getSize();  
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }
    
    private void preencheTabela(ArrayList<ModProdutos> pesPro) {
        jtPesquisa.getColumnModel().getColumn(0).setPreferredWidth(5);
        jtPesquisa.getColumnModel().getColumn(1).setPreferredWidth(100);
        jtPesquisa.getColumnModel().getColumn(2).setPreferredWidth(10);
        
        DefaultTableModel modelo =  (DefaultTableModel) jtPesquisa.getModel();
        modelo.setNumRows(0);
        this.arrayPro = pesPro;

        for (int i = 0; i < pesPro.size(); i++) {
            modelo.addRow(new Object[]{pesPro.get(i).getPro_id(), pesPro.get(i).getPro_descricao(), pesPro.get(i).getPro_valor_custo()});
            
        }
    }
    
    private void preencheJTVenda(ModProdutos get, String quant) {
        
       // jTVenda.getColumnModel().getColumn(0).setPreferredWidth(5);
        jTVenda.getColumnModel().getColumn(0).setPreferredWidth(5);
        jTVenda.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTVenda.getColumnModel().getColumn(2).setPreferredWidth(10);
        jTVenda.getColumnModel().getColumn(3).setPreferredWidth(10);
        
        DefaultTableModel modelo = (DefaultTableModel) jTVenda.getModel();
        modelo.setNumRows(0);
        
        get.setPro_quantidade(Integer.parseInt(quant));
        this.arrayProVenda.add(get);
        
        for (int i = 0; i < arrayProVenda.size(); i ++)
            modelo.addRow(new Object[]{this.arrayProVenda.get(i).getPro_id(), this.arrayProVenda.get(i).getPro_descricao(), this.arrayProVenda.get(i).getPro_quantidade(), this.arrayProVenda.get(i).getPro_valor_custo()});
    
    }
    
    private void valorVenda() {
        
        double valor = 0.00;
        
        for (int i = 0; i < arrayProVenda.size(); i++) {
            valor += (arrayProVenda.get(i).getPro_quantidade() * arrayProVenda.get(i).getPro_valor_custo());
        }
        
        jlValorVenda.setText(String.valueOf(valor));
        tfValorPagamento.setText(String.valueOf(valor));
    }
    
    private boolean calculaDesconto() {
        double valorVenda = Double.parseDouble(jlValorVenda.getText());
        double desconto = Double.parseDouble(tfDesconto.getText());
        double result;
        
        if (desconto < valorVenda) {
            result = valorVenda - desconto;
            jlValorVenda.setText(String.valueOf(result));
        } else {
            JOptionPane.showMessageDialog(null, "Valor do desconto invalido!!\nDesconto maior que o valor da venda");
            valorVenda();
            tfDesconto.setText("");
            jlPercentualDesconto.setText("0.00%");
            return false;
        }
        
        return true;
    }
    
    private void calculaPercentDesconto() {
        double desconto = Double.parseDouble(tfDesconto.getText());
        double result;
        
        double valor = 0.00;
        
        for (int i = 0; i < arrayProVenda.size(); i++) {
            valor += (arrayProVenda.get(i).getPro_quantidade() * arrayProVenda.get(i).getPro_valor_custo());
        }
        result = (desconto * 100)/valor;
        jlPercentualDesconto.setText(String.valueOf(result)+"%");
        
        
        
    }
    
    private void limpaPesquisa() {
        tfCodigoPesquisa.setText("");
        tfNomePesquisa.setText("");
        tfQuantidade.setText("1");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfCodigoPesquisa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfNomePesquisa = new javax.swing.JTextField();
        btPesquisa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPesquisa = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        tfQuantidade = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTVenda = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jcPagamento = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jcOpcoesPagamento = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        tfQuantParcela = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jlValorVenda = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfDesconto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jlPercentualDesconto = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tfValorPagamento = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jlDesconto = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisa Produtos"));

        jLabel1.setText("Codigo Produto:");

        jLabel2.setText("Nome Produto:");

        btPesquisa.setText("Pesquisar");
        btPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisaActionPerformed(evt);
            }
        });

        jtPesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Nome Produto", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtPesquisaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtPesquisa);
        if (jtPesquisa.getColumnModel().getColumnCount() > 0) {
            jtPesquisa.getColumnModel().getColumn(0).setResizable(false);
            jtPesquisa.getColumnModel().getColumn(1).setResizable(false);
            jtPesquisa.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel9.setText("Quantidade:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfCodigoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfNomePesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(93, 93, 93))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btPesquisa)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCodigoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNomePesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btPesquisa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Venda"));

        jTVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome Produto", "Quantidade", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTVendaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTVendaMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTVendaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTVendaMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTVendaMouseEntered(evt);
            }
        });
        jTVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTVendaKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTVenda);
        if (jTVenda.getColumnModel().getColumnCount() > 0) {
            jTVenda.getColumnModel().getColumn(0).setResizable(false);
            jTVenda.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTVenda.getColumnModel().getColumn(1).setResizable(false);
            jTVenda.getColumnModel().getColumn(2).setResizable(false);
            jTVenda.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel3.setText("Pagamento:");

        jcPagamento.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jcPagamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A vista", "Parcelado" }));
        jcPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcPagamentoActionPerformed(evt);
            }
        });

        jLabel4.setText("Opção de Pagamento:");

        jcOpcoesPagamento.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jcOpcoesPagamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dinheiro", "Cartão", "Cheque" }));

        jLabel5.setText("Quantidade Parcelas:");

        tfQuantParcela.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N

        jLabel6.setText("Valor Venda:");

        jlValorVenda.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N

        jLabel7.setText("Desconto:");

        tfDesconto.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfDescontoCaretUpdate(evt);
            }
        });
        tfDesconto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfDescontoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfDescontoKeyReleased(evt);
            }
        });

        jLabel8.setText("Percentual de desconto:");

        jlPercentualDesconto.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N

        jLabel10.setText("Valor Pagamento:");

        tfValorPagamento.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        tfValorPagamento.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfValorPagamentoCaretUpdate(evt);
            }
        });

        jLabel11.setText("% Desconto:");

        jlDesconto.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N

        jButton2.setText("SALVAR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jlPercentualDesconto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jlValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jcPagamento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(tfQuantParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlDesconto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcOpcoesPagamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(tfDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfValorPagamento)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfQuantParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcOpcoesPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfValorPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlPercentualDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jlValorVenda, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                    .addComponent(jlDesconto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(88, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisaActionPerformed
        ArrayList<ModProdutos> pesPro = new ArrayList<ModProdutos>();
       
        if (!tfCodigoPesquisa.getText().equals("") && tfNomePesquisa.getText().equals("")) {
            this.modPro.setPro_id(Integer.parseInt(tfCodigoPesquisa.getText()));
            pesPro = ctrPro.pesquisaProduto(this.modPro, 1);
            
        } else if (tfCodigoPesquisa.getText().equals("") && !tfNomePesquisa.getText().equals("")) {
            modPro.setPro_descricao(tfNomePesquisa.getText());
            pesPro =  ctrPro.pesquisaProduto(modPro, 0);
            
        } else if (!tfCodigoPesquisa.getText().equals("") && !tfNomePesquisa.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Não é permitido a pesquisa com os dois campos preechidos");
        else
            JOptionPane.showMessageDialog(null, "É necessario o preenchimento de um dos dois campos da pesquisa");
        
        limpaPesquisa();
        preencheTabela(pesPro);
    }//GEN-LAST:event_btPesquisaActionPerformed

    private void jtPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPesquisaMouseClicked
        int linhaTabela = jtPesquisa.getSelectedRow();
        
        for(int i = 0; i < this.arrayPro.size(); i++) {
            
            if ( (int) jtPesquisa.getValueAt(linhaTabela, 0) == arrayPro.get(i).getPro_id()) {
                preencheJTVenda(arrayPro.get(i), tfQuantidade.getText());
                break;
            }    
        }
        
        valorVenda();
    }//GEN-LAST:event_jtPesquisaMouseClicked

    private void jTVendaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTVendaMouseExited
        //int linhaTabela = jtPesquisa.getSelectedRow();
        //if (linhaTabela > 0)
        //System.out.println("linhaTabela --" + (int) jtPesquisa.getValueAt(linhaTabela, 0));
    }//GEN-LAST:event_jTVendaMouseExited

    private void jTVendaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTVendaMouseReleased
        //int linhaTabela = jtPesquisa.getSelectedRow();
        //if (linhaTabela > 0)
        //System.out.println("linhaTabela --" + (int) jtPesquisa.getValueAt(linhaTabela, 0));
    }//GEN-LAST:event_jTVendaMouseReleased

    private void jTVendaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTVendaKeyReleased
        //int linhaTabela = jtPesquisa.getSelectedRow();
        //if (linhaTabela > 0)
        //System.out.println("linhaTabela --" + (int) jtPesquisa.getValueAt(linhaTabela, 0));
    }//GEN-LAST:event_jTVendaKeyReleased

    private void jTVendaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTVendaMousePressed
        //int linhaTabela = jtPesquisa.getSelectedRow();
        //if (linhaTabela > 0)
        //System.out.println("linhaTabela --" + (int) jtPesquisa.getValueAt(linhaTabela, 0));
    }//GEN-LAST:event_jTVendaMousePressed

    private void jTVendaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTVendaMouseEntered
        //int linhaTabela = jtPesquisa.getSelectedRow();
        //if (linhaTabela > 0)
        //System.out.println("linhaTabela --" + (int) jtPesquisa.getValueAt(linhaTabela, 0));
    }//GEN-LAST:event_jTVendaMouseEntered

    private void jTVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTVendaMouseClicked
        //int linhaTabela = jtPesquisa.getSelectedRow();
        //jtPesquisa.getValueAt(linhaTabela, 2);
    }//GEN-LAST:event_jTVendaMouseClicked

    private void jcPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcPagamentoActionPerformed
        if (jcPagamento.getSelectedIndex() == 0) {
            tfQuantParcela.setEnabled(false);
        } else if (jcPagamento.getSelectedIndex() == 1) {
            tfQuantParcela.setEnabled(true);
        }
    }//GEN-LAST:event_jcPagamentoActionPerformed

    private void tfValorPagamentoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfValorPagamentoCaretUpdate
        
    }//GEN-LAST:event_tfValorPagamentoCaretUpdate

    private void tfDescontoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfDescontoCaretUpdate
        
    }//GEN-LAST:event_tfDescontoCaretUpdate

    private void tfDescontoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDescontoKeyPressed
        
    }//GEN-LAST:event_tfDescontoKeyPressed

    private void tfDescontoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDescontoKeyReleased
        System.out.println("passou 594");
        if (!tfDesconto.getText().isEmpty()) {
            valorVenda();
            if (calculaDesconto())
                calculaPercentDesconto();
        } else {
            valorVenda();
            jlPercentualDesconto.setText("0.00%");
        }
    }//GEN-LAST:event_tfDescontoKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btPesquisa;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTVenda;
    private javax.swing.JComboBox jcOpcoesPagamento;
    private javax.swing.JComboBox jcPagamento;
    private javax.swing.JLabel jlDesconto;
    private javax.swing.JLabel jlPercentualDesconto;
    private javax.swing.JLabel jlValorVenda;
    private javax.swing.JTable jtPesquisa;
    private javax.swing.JTextField tfCodigoPesquisa;
    private javax.swing.JTextField tfDesconto;
    private javax.swing.JTextField tfNomePesquisa;
    private javax.swing.JTextField tfQuantParcela;
    private javax.swing.JTextField tfQuantidade;
    private javax.swing.JTextField tfValorPagamento;
    // End of variables declaration//GEN-END:variables

    

    

    

    

}
