/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.loginhealthinspec;

import com.github.britooo.looca.api.core.Looca;
import java.awt.Color;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Nicolas
 */
public class Login extends javax.swing.JFrame {

    private int mouseX = 0, mouseY = 0;

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();

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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtUsuario = new javax.swing.JTextField();
        passwdSenha = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        btnEntrar = new javax.swing.JButton();
        minimizeLbl = new javax.swing.JLabel();
        closeLbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(1, 103, 126));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/200.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(250, 250, 250));
        jLabel2.setText("HEALTH INSPEC");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel1)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(250, 250, 250));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsuario.setBackground(new java.awt.Color(250, 250, 250));
        txtUsuario.setText("E-mail");
        txtUsuario.setBorder(null);
        txtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusLost(evt);
            }
        });
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        jPanel3.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 252, 38));

        passwdSenha.setBackground(new java.awt.Color(250, 250, 250));
        passwdSenha.setText("Senha");
        passwdSenha.setBorder(null);
        passwdSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwdSenhaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwdSenhaFocusLost(evt);
            }
        });
        passwdSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwdSenhaActionPerformed(evt);
            }
        });
        jPanel3.add(passwdSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 252, 39));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, -1, -1));

        jSeparator2.setBackground(new java.awt.Color(1, 103, 126));
        jSeparator2.setForeground(new java.awt.Color(1, 103, 126));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 250, 20));

        jSeparator3.setBackground(new java.awt.Color(1, 103, 126));
        jSeparator3.setForeground(new java.awt.Color(1, 103, 126));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 250, 20));

        btnEntrar.setBackground(new java.awt.Color(250, 250, 250));
        btnEntrar.setForeground(new java.awt.Color(1, 103, 126));
        btnEntrar.setText("Entrar");
        btnEntrar.setBorder(null);
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        jPanel3.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 290, 256, 35));

        minimizeLbl.setBackground(new java.awt.Color(1, 103, 126));
        minimizeLbl.setFont(new java.awt.Font("Myanmar Text", 0, 48)); // NOI18N
        minimizeLbl.setForeground(new java.awt.Color(1, 103, 126));
        minimizeLbl.setText("-");
        minimizeLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeLblMouseClicked(evt);
            }
        });
        jPanel3.add(minimizeLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 30, 20));

        closeLbl.setBackground(new java.awt.Color(1, 103, 126));
        closeLbl.setFont(new java.awt.Font("Myanmar Text", 0, 24)); // NOI18N
        closeLbl.setForeground(new java.awt.Color(1, 103, 126));
        closeLbl.setText("X");
        closeLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeLblMouseClicked(evt);
            }
        });
        jPanel3.add(closeLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 30, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-usuário-30.png"))); // NOI18N
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 165, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-desbloquear-30.png"))); // NOI18N
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 215, -1, -1));

        lblError.setBackground(java.awt.Color.white);
        lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblError.setText("-");
        jPanel3.add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 290, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void minimizeLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeLblMouseClicked
        this.setExtendedState(Login.ICONIFIED);
    }//GEN-LAST:event_minimizeLblMouseClicked

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        String username = txtUsuario.getText();
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void passwdSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwdSenhaActionPerformed

    }//GEN-LAST:event_passwdSenhaActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        mouseX = evt.getX();
        mouseY = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        setLocation(evt.getXOnScreen() - mouseX, evt.getYOnScreen() - mouseY);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void closeLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLblMouseClicked
        dispose();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }//GEN-LAST:event_closeLblMouseClicked

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        // TODO add your handling code here:

        ConnectionAzure azure = new ConnectionAzure();
        Looca looca = new Looca();
        ResultSet resultSetEmail = null;
        try {
            Double ram = looca.getMemoria().getEmUso() / 1073741824.0;
            Double disco = looca.getGrupoDeDiscos().getTamanhoTotal() / 1073741824.0;
            double tamanho = new File("C:\\").getTotalSpace() - new File("C:\\").getFreeSpace();
            double tamanhoTotal = new File("C:\\").getTotalSpace();
            String so = looca.getSistema().getSistemaOperacional();
            Integer bits = looca.getSistema().getArquitetura();
            String hostName = InetAddress.getLocalHost().getHostName();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            java.sql.Connection connection = DriverManager.getConnection(azure.connectionUrl);
            JdbcTemplate con = new JdbcTemplate(azure.getDataSource());
            System.out.println("Conexão obtida com sucesso!");

            List<Funcionario> listaLoginFuncionario = con.query(
                    "SELECT idFuncionario, email, fkHospital, senha FROM funcionario WHERE email = '" + txtUsuario.getText() + "' AND senha = '" + passwdSenha.getText() + "';",
                    new BeanPropertyRowMapper<>(Funcionario.class));

            if (listaLoginFuncionario.isEmpty()) {
                Log.guardarLog("Tentativa de login falhou");
                lblError.setForeground(Color.red);
                lblError.setText("Usuário ou senha incorreta!");
            } else {

                Funcionario funcionario = listaLoginFuncionario.get(0);
                System.out.println(funcionario.getFkHospital());

                List<Maquinas> listaMaquinas = con.query("SELECT * FROM maquinas WHERE fkHospital = " + funcionario.getFkHospital() + ";",
                        new BeanPropertyRowMapper<>(Maquinas.class));

                //System.out.println(listaMaquinas.get(0).toString());
                if (listaMaquinas.isEmpty()) {

                    String insertMaquinas = "INSERT INTO maquinas (nomeMaquina, sistemaOperacional, arquitetura, fkHospital) VALUES (?, ?, ?, ?);";
                    con.update(insertMaquinas,
                            hostName,
                            so,
                            bits,
                            funcionario.getFkHospital()
                    );
                    listaMaquinas = con.query("SELECT * FROM maquinas WHERE fkHospital = " + funcionario.getFkHospital() + ";",
                        new BeanPropertyRowMapper<>(Maquinas.class));
                    Maquinas maquinas = listaMaquinas.get(0);
                    
                    String insertCompMaq = "INSERT INTO componentes_has_maquinas (fkComponente, fkMaquina, totalComponente, unidadeMedida) VALUES (?, ?, ?, ?);";

                    //CPU
                    con.update(insertCompMaq,
                            3,
                            maquinas.getIdMaquina(),
                            String.format("%.1f Ghz",looca.getProcessador().getFrequencia()),
                            "Ghz"
                    );

                    //RAM
                    con.update(insertCompMaq,
                            1,
                            maquinas.getIdMaquina(),
                            String.format("%.1f Gb",
                                    ram),
                            "Gb"
                    );

                    //DISCO
                    con.update(insertCompMaq,
                            2,
                            maquinas.getIdMaquina(),
                            String.format("%.1f Gb",
                                    disco),
                            "Gb"
                    );

                    TelaAcesso telaAcesso = new TelaAcesso();
                    telaAcesso.setVisible(true);
                } else {
                    System.out.println("Máquina já inserida!");
                    TelaAcesso telaAcesso = new TelaAcesso();
                    telaAcesso.setVisible(true);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_btnEntrarActionPerformed

    private void txtUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusGained
        // TODO add your handling code here:
        if (txtUsuario.getText().equals("E-mail")) {
            txtUsuario.setText("");
            txtUsuario.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtUsuarioFocusGained

    private void txtUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusLost
        // TODO add your handling code here:
        if (txtUsuario.getText().equals("")) {
            txtUsuario.setText("E-mail");
            txtUsuario.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtUsuarioFocusLost

    private void passwdSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwdSenhaFocusGained
        // TODO add your handling code here:
        if (passwdSenha.getText().equals("Senha")) {
            passwdSenha.setText("");
            passwdSenha.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_passwdSenhaFocusGained

    private void passwdSenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwdSenhaFocusLost
        // TODO add your handling code here:
        if (passwdSenha.getText().equals("")) {
            passwdSenha.setText("Senha");
            passwdSenha.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_passwdSenhaFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws UnknownHostException {
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel closeLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel minimizeLbl;
    private javax.swing.JPasswordField passwdSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
