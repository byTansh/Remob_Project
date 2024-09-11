
package br.com.remob.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Passageiro extends javax.swing.JFrame {

    public Passageiro() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        statusConnect = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pesquisaText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        Nome = new javax.swing.JTextField();
        CPF = new javax.swing.JTextField();
        Idade = new javax.swing.JTextField();
        Telefone = new javax.swing.JTextField();
        Email = new javax.swing.JTextField();
        Senha = new javax.swing.JTextField();
        Sexo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "CPF", "Idade", "Telefone", "E-mail", "Senha", "Sexo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        statusConnect.setText("Status da Conexão:");

        jButton1.setText("Conectar aos Dados");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Banco de Dados - Passageiros");

        jLabel2.setText("Pesquisar Dados:");

        jButton2.setText("Pesquisar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("ID");

        jLabel4.setText("Nome");

        jLabel5.setText("CPF");

        jLabel6.setText("Idade");

        jLabel7.setText("Telefone");

        jLabel8.setText("E-mail");

        jLabel9.setText("Senha");

        jLabel10.setText("Sexo");

        ID.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        ID.setEnabled(false);
        ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDActionPerformed(evt);
            }
        });

        Nome.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Nome.setEnabled(false);

        CPF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        CPF.setEnabled(false);

        Idade.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Idade.setEnabled(false);

        Telefone.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Telefone.setEnabled(false);

        Email.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Email.setEnabled(false);

        Senha.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Senha.setEnabled(false);

        Sexo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Sexo.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 973, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pesquisaText, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CPF, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(Idade, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(Telefone, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(Email, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(Senha, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(Sexo, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(ID, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(Nome)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(statusConnect)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(545, 545, 545)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(605, 605, 605)
                                .addComponent(jButton1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(31, 31, 31)
                .addComponent(statusConnect)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pesquisaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2)
                            .addComponent(jLabel2))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(CPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(Idade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        BDconnect banco = new BDconnect();        
        boolean resultado = banco.conectaDB();        
        if (resultado == true) {
            this.statusConnect.setText("Status da Conexão: Conectado no banco de dados.");
        } else {
            this.statusConnect.setText("Status da Conexão: NÃO Conectado no banco de dados.");
        }
            
        //String query = "SELECT * FROM passageiro WHERE id = ?";
        String query = "SELECT * FROM passageiro";
        PreparedStatement ps = banco.getPreparedStatement(query);
        try {
             // Executar a consulta
            ResultSet rs = ps.executeQuery();
            
            DefaultTableModel model = (DefaultTableModel) this.jTable1.getModel();
            if (model.getRowCount() > 0) {
                model.setNumRows(0);
            }
            
            // Processar os resultados
            while (rs.next()) {
                String[] dados = {rs.getString("id"), 
                                  rs.getString("nome"),
                                  rs.getString("cpf"),
                                  rs.getDate("idade").toString(),
                                  rs.getString("telefone"), 
                                  rs.getString("email"),
                                  rs.getString("senha"),
                                  rs.getString("sexo")};
                                  
                
                model.addRow(dados);
            } //fim WHILE
            this.jTable1.setModel(model);
            rs.close();
            ps.close();
            banco.encerrarConexao();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, 
            "Não foi possível realizar a consulta no BD. Erro: " + ex.getMessage());
        }                                     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          try {
              
              //conecta ao banco de dados
              BDconnect banco = new BDconnect();
              banco.conectaDB();
              
              //declara variável para selecionar valor
              String sql = "select * from passageiro where nome like ?";
              
              //puxa os dados do banco
              PreparedStatement ps = banco.getPreparedStatement(sql);
              
              //pega o texto do campo pesquisa e insere no valor '?' da variavel sql
              ps.setString(1,   pesquisaText.getText() + "%");
              //obs: o "%" representa qualquer valor adicional, para não precisar digitar a informação completa
              //exemplo: select * from passageiro where nome like 'ana%' == Ana Souza, Ana de Assis, Ana Roberta
              //se houver mais de um usuário com o mesmo nome, é bom puxar a informação pelo ID
              
              //executa a query (select * from passageiro where nome like (pesquisaText.getText() + "%")
              ResultSet rs = ps.executeQuery();
              
              //inicia um if para puxar os valores das colunas da tabela passageiro
              //(parâmetro: se rs tem uma próxima 'next' linha para percorrer, o código continua a ser executado.)
              if(rs.next()) {
                  
                  //puxando os valores de cada coluna e retornando como string
                  String value1 = rs.getString("id"); 
                  String value2 = rs.getString("nome");
                  String value3 = rs.getString("cpf");
                  String value4 = rs.getDate("idade").toString();
                  String value5 = rs.getString("telefone");
                  String value6 = rs.getString("email");
                  String value7 = rs.getString("senha");
                  String value8 = rs.getString("sexo");
                  
                  //inserindo os valores nos campos de texto
                  ID.setText(value1);
                  Nome.setText(value2);
                  CPF.setText(value3);
                  Idade.setText(value4);
                  Telefone.setText(value5);
                  Email.setText(value6);
                  Senha.setText(value7);
                  Sexo.setText(value8);
                  
                  
                }
                //fim if
                
              //fecha a consulta no banco
              rs.close();
              //fecha o prepared statement
              ps.close();
              //encerra a conexão com o banco
              banco.encerrarConexao();
              //obs: importante fechar, sempre que terminar de usar o banco
              //para não sobrecarregar o sistema
              
        }//fim try
          
          catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, 
            "Não foi possível realizar a consulta no BD. Erro: " + ex.getMessage());
        }//fim exception                     
    }//GEN-LAST:event_jButton2ActionPerformed

    private void IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDActionPerformed

    }//GEN-LAST:event_IDActionPerformed

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
            java.util.logging.Logger.getLogger(Passageiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Passageiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Passageiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Passageiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Passageiro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CPF;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField ID;
    private javax.swing.JTextField Idade;
    private javax.swing.JTextField Nome;
    private javax.swing.JTextField Senha;
    private javax.swing.JTextField Sexo;
    private javax.swing.JTextField Telefone;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField pesquisaText;
    private javax.swing.JLabel statusConnect;
    // End of variables declaration//GEN-END:variables
}
