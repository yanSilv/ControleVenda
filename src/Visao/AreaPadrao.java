/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Visao;

import Conexao.Conexao_;
import DAO.ControleVendaDB;
import Modelo.ModVendedor;
import javax.swing.JButton;
import javax.swing.JMenu;

/**
 *
 * @author jaguar
 */
public class AreaPadrao extends javax.swing.JFrame {
    
    Produtos prod;
    Venderores vend;
    Vendas ven;
    RelatoriosProdutos relP;
    RelatoriosVendas   relV;
    LoginUser login;
    ModVendedor modVen;
    
    Conexao_ conexao;
    ControleVendaDB daoVen;

    /**
     * Creates new form AreaPadrao
     */
    public AreaPadrao() {
        initComponents();
        conexao = new Conexao_();
        daoVen = new ControleVendaDB();
        desabilitaButoes();
        
        if (!conexao.conecta_()) {
           daoVen.criaDB();
           daoVen.construirBD();
           daoVen.insereAdm();
        }
        
    }
   
    private void criaJanelaLogin() {
        if(vend != null) {
            vend.dispose();
        }
        
        if (ven != null) {
            ven.dispose();
        }
        
        if (relP != null) {
            relP.dispose();
        }
        
        if (relV != null) {
            relV.dispose();
        }
        
        if(prod != null) {
            prod.dispose();
        }
        
        if(login == null) {
            login = new LoginUser(this);
        }
      
        jAreaTrabalho.removeAll();
        jAreaTrabalho.add(login);
        login.setVisible(true);
        login.setPosicao();
        
    }
    
    private void criaJanelaProdutos() {
        if(vend != null) {
            vend.dispose();
        }
        
        if (ven != null) {
            ven.dispose();
        }
        
        if (relP != null) {
            relP.dispose();
        }
        
        if (relV != null) {
            relV.dispose();
        }
        
        if(prod == null) {
            prod = new Produtos();
        }
        
        jAreaTrabalho.removeAll();
        jAreaTrabalho.add(prod);
        prod.setVisible(true);
        prod.setPosicao();
    }
    
    private void criaJanelaVendas() {
        
        if(vend != null) {
            vend.dispose();
        }
        
        if (relP != null) {
            relP.dispose();
        }
        
        if (relV != null) {
            relV.dispose();
        }
        
        if(prod !=null) {
            prod.dispose();
        }
        
        if (ven == null) {
            ven = new Vendas(this.modVen);
        }
        
        jAreaTrabalho.removeAll();
        jAreaTrabalho.add(ven);
        ven.setVisible(true);
        ven.setPosicao();
        
    }
    
    private void criaJanelaVendedor() {
        
        if (relP != null) {
            relP.dispose();
        }
        
        if (relV != null) {
            relV.dispose();
        }
        
        if(prod !=null) {
            prod.dispose();
        }
        
        if (ven != null) {
            ven.dispose();
        }
        
        if(vend == null) {
            vend = new Venderores();
        }
        
        jAreaTrabalho.removeAll();
        jAreaTrabalho.add(vend);
        vend.setVisible(true);
        vend.setPosicao();
        
    }
    
    private void criaJanelaRelatorioProdutos() {
        
        if (relV != null) {
            relV.dispose();
        }
        
        if(prod !=null) {
            prod.dispose();
        }
        
        if (ven != null) {
            ven.dispose();
        }
        
        if(vend != null) {
            vend.dispose();
        }
        
        if (relP == null) {
            relP = new RelatoriosProdutos();
        }
        
        jAreaTrabalho.removeAll();
        jAreaTrabalho.add(relP);
        relP.setVisible(true);
        relP.setPosicao();
        
    }

    private void criaJanelaRelatorioVendas() {
        
        if(prod !=null) {
            prod.dispose();
        }
        
        if (ven != null) {
            ven.dispose();
        }
        
        if(vend != null) {
            vend.dispose();
        }
        
        if (relP != null) {
            relP.dispose();
        }
        
        if (relV == null) {
            relV = new RelatoriosVendas();
        }
        
        jAreaTrabalho.removeAll();
        jAreaTrabalho.add(relV);
        relV.setVisible(true);
        relV.setPosicao();
    }
    
    public void desabilitaButoes() {
        //jBProdutos.setEnabled(false);
        jBProdutos.setVisible(false);
        jBVendas.setVisible(false);
        jBVendedor.setVisible(false);
        jMCadastro.setVisible(false);
        jMRelatorio.setVisible(false);
    }
    
    public void habilitaButoes(ModVendedor vend) {
        jBProdutos.setVisible(true);
        jBVendas.setVisible(true);
        jBVendedor.setVisible(true);
        jMCadastro.setVisible(true);
        jMRelatorio.setVisible(true);
        jBLogin.setVisible(false);
        
        if(login != null) {
            login.dispose();
        }
        
        jLVendedor.setText(vend.getVend_nome());
        modVen = vend;
        
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jBProdutos = new javax.swing.JButton();
        jBVendedor = new javax.swing.JButton();
        jBVendas = new javax.swing.JButton();
        jBLogin = new javax.swing.JButton();
        jAreaTrabalho = new javax.swing.JDesktopPane();
        jLVendedor = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMCadastro = new javax.swing.JMenu();
        jMCadProdutos = new javax.swing.JMenuItem();
        jMVendas = new javax.swing.JMenuItem();
        jMVendedores = new javax.swing.JMenuItem();
        jMRelatorio = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Controle Vendas");

        jToolBar1.setRollover(true);

        jBProdutos.setText("Produtos");
        jBProdutos.setFocusable(false);
        jBProdutos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBProdutos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBProdutosActionPerformed(evt);
            }
        });
        jToolBar1.add(jBProdutos);

        jBVendedor.setText("Vendedor");
        jBVendedor.setFocusable(false);
        jBVendedor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBVendedor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVendedorActionPerformed(evt);
            }
        });
        jToolBar1.add(jBVendedor);

        jBVendas.setText("Vendas");
        jBVendas.setFocusable(false);
        jBVendas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBVendas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVendasActionPerformed(evt);
            }
        });
        jToolBar1.add(jBVendas);

        jBLogin.setText("Login");
        jBLogin.setFocusable(false);
        jBLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBLogin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLoginActionPerformed(evt);
            }
        });
        jToolBar1.add(jBLogin);

        jLVendedor.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N

        jMCadastro.setText("Cadastro");

        jMCadProdutos.setText("Produtos");
        jMCadProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMCadProdutosActionPerformed(evt);
            }
        });
        jMCadastro.add(jMCadProdutos);

        jMVendas.setText("Vendas");
        jMVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMVendasActionPerformed(evt);
            }
        });
        jMCadastro.add(jMVendas);

        jMVendedores.setText("Vendedores");
        jMVendedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMVendedoresActionPerformed(evt);
            }
        });
        jMCadastro.add(jMVendedores);

        jMenuBar1.add(jMCadastro);

        jMRelatorio.setText("Relatorios");

        jMenuItem1.setText("Produstos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMRelatorio.add(jMenuItem1);

        jMenuItem2.setText("Vendas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMRelatorio.add(jMenuItem2);

        jMenuBar1.add(jMRelatorio);

        jMenu2.setText("Sair");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jAreaTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, 1229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(jLVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addComponent(jAreaTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(1240, 730));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBProdutosActionPerformed
        criaJanelaProdutos();
    }//GEN-LAST:event_jBProdutosActionPerformed

    private void jMCadProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMCadProdutosActionPerformed
        criaJanelaProdutos();
    }//GEN-LAST:event_jMCadProdutosActionPerformed

    private void jBVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVendasActionPerformed
        criaJanelaVendas();
    }//GEN-LAST:event_jBVendasActionPerformed

    private void jBVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVendedorActionPerformed
        criaJanelaVendedor();
    }//GEN-LAST:event_jBVendedorActionPerformed

    private void jMVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMVendasActionPerformed
        criaJanelaVendas();
    }//GEN-LAST:event_jMVendasActionPerformed

    private void jMVendedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMVendedoresActionPerformed
        criaJanelaVendedor();
    }//GEN-LAST:event_jMVendedoresActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        criaJanelaRelatorioProdutos();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        criaJanelaRelatorioVendas();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jBLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLoginActionPerformed
        criaJanelaLogin();
    }//GEN-LAST:event_jBLoginActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenu2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AreaPadrao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AreaPadrao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AreaPadrao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AreaPadrao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AreaPadrao().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jAreaTrabalho;
    private javax.swing.JButton jBLogin;
    private javax.swing.JButton jBProdutos;
    private javax.swing.JButton jBVendas;
    private javax.swing.JButton jBVendedor;
    private javax.swing.JLabel jLVendedor;
    private javax.swing.JMenuItem jMCadProdutos;
    private javax.swing.JMenu jMCadastro;
    private javax.swing.JMenu jMRelatorio;
    private javax.swing.JMenuItem jMVendas;
    private javax.swing.JMenuItem jMVendedores;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables


}
