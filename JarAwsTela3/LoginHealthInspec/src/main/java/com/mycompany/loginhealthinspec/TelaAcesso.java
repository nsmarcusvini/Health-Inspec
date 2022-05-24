/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.loginhealthinspec;

import com.github.britooo.looca.api.core.Looca;
import java.io.File;
import java.net.InetAddress;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.*;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Nicolas
 */
public class TelaAcesso extends javax.swing.JFrame {

    private int mouseX = 0, mouseY = 0;

    /**
     * Creates new form Login
     */
    public TelaAcesso() {
        initComponents();
        this.setUpOs();
    }

    Thread function = new Thread() {

        @Override
        public void run() {

            ConnectionAzure azure = new ConnectionAzure();
            JdbcTemplate con = new JdbcTemplate(azure.getDataSource());
            Scanner scan = new Scanner(System.in);
            Looca looca = new Looca();
            Inserts inserts = new Inserts();
            ResultSet resultSetEmail = null;
            String so = looca.getSistema().getSistemaOperacional();
            Integer bits = looca.getSistema().getArquitetura();
            Log log = new Log();
            Integer processList = looca.getGrupoDeProcessos().getProcessos().size();

            // MAP DE PROCESSOS QUE SERÃO FECHADOS
            Map<Integer, String> blackList = new HashMap<Integer, String>();
            blackList.put(0, "notepad");
            blackList.put(1, "gedit");

            //Try que pega todos os processos que estão sendo executados
            try {
                for (int i = 0; i < processList; i++) {
                    String fraseProcesso = "";

                    txtTxtArea.setText(txtTxtArea.getText() + looca.getGrupoDeProcessos().getProcessos().get(i).getNome() + "\n");
                    fraseProcesso = looca.getGrupoDeProcessos().getProcessos().get(i).getNome();
                    log.guardarLog("Processo: " + fraseProcesso + " em execução.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {

                double tamanho = new File("C:\\").getTotalSpace() - new File("C:\\").getFreeSpace();

                Double ram = looca.getMemoria().getEmUso() / 1073741824.0;
                Double ramTotal = looca.getMemoria().getTotal() / 1073741824.0;
                Double disco = looca.getGrupoDeDiscos().getTamanhoTotal() / 1073741824.0;
                if (disco > disco * 0.33) {
                    SlackIntegration.sendMessageToSlack("Disco elevado : acima 75%");
                    if (disco > disco * 0.75) {
                        SlackIntegration.sendMessageToSlack("Disco elevado acima 75%");
                    }
                    if (disco < disco * 0.75) {
                        SlackIntegration.sendMessageToSlack("Disco estável");
                    }
                    if (ramTotal > 1) {
                        SlackIntegration.sendMessageToSlack("Memória ram elevada : acima 75%");
                    }
                    if (ramTotal < ramTotal * 0.75) {
                        SlackIntegration.sendMessageToSlack("Memória ram estável");
                    }

                    lblUsoProcessador.setText(String.format("%.2f%%", looca.getProcessador().getUso()));
                    lblUsoMemoriaRam.setText(String.format("%.2f GB usados", ram));
                    lblUsoDisco.setText(String.format("%.2f usados", tamanho / 1073741824.0));
                    SlackIntegration.sendMessageToSlack("memoria ram elevado acima 75%");
                }
                if (ramTotal < 1) {
                    SlackIntegration.sendMessageToSlack("memoria ram estavel");
                }

                lblHostName.setText(InetAddress.getLocalHost().getHostName());
                lblSistemaOperacional.setText(looca.getSistema().getSistemaOperacional());
                lblProcessador.setText(looca.getProcessador().getNome());
                lblMemoriaRam.setText(String.format("%.1f Gb", ram));
                lblDisco.setText(String.format("%.1f Gb", disco));

            } catch (Exception e) {

                e.printStackTrace();

            }

            // while que verifica o uso de CPU e RAM(falta o disco)
            //While da blacklist
            try {
                Boolean contador = true;
                String espaco = "==========";
                Double ram = looca.getMemoria().getEmUso() / 1073741824.0;
                double tamanho = new File("C:\\").getTotalSpace() - new File("C:\\").getFreeSpace();
                String hostName = InetAddress.getLocalHost().getHostName();
                
                while (contador) {

                Boolean verdadeiro = true;
                Integer processlist = looca.getGrupoDeProcessos().getProcessos().size();

                System.out.println(String.format("%s %.2f%% %s %.2f GB USADOS %s %.2f USADOS",
                        espaco, looca.getProcessador().getUso(),
                        espaco, ram, espaco, tamanho / 1073741824.0));

                String insert = "INSERT INTO maquinas (tipoMaquina, fkTecnico, nomeMaquina, sistemaOperacional, arquitetura) VALUES (?, ?, ?, ?, ?)";

                con.update(insert,
                        "Computador",
                        1,
                        hostName,
                        so,
                        bits
                );

                String insertComp = "INSERT INTO componentes (nomeComponente, tipoComponente, descricaoComponente, fkMaquina) VALUES (?, ?, ?, ?);";

                con.update(insertComp,
                        hostName,
                        "CPU",
                        looca.getProcessador().getNome(),
                        2
                );

                String insertReg = "INSERT INTO registros (totalUsado, dataHora, fkComponente) VALUES (?, ?, ?)";

                con.update(insertReg,
                        looca.getProcessador().getUso(),
                        LocalDateTime.now(),
                        2
                );

                for (int i = 0; i < processlist; i++) {
                    try {
                        if (blackList.containsValue(looca.getGrupoDeProcessos().getProcessos().get(i).getNome())) {
                            if (looca.getSistema().getSistemaOperacional().equals("Windows")) {
                                String processoFinalizado = looca.getGrupoDeProcessos().getProcessos().get(i).getNome();
                                String killWindows = "taskkill /F /T /PID " + looca.getGrupoDeProcessos().getProcessos().get(i).getPid();
                                Runtime.getRuntime().exec(killWindows);
                                log.guardarLog("Processo: " + processoFinalizado + " finalizado pela BlackList!");
                                looca.getGrupoDeProcessos().getProcessos().remove(i);
                            }
                            if (looca.getSistema().getSistemaOperacional().equals("Ubuntu")) {
                                String killUbuntu = "kill -SIGKILL " + looca.getGrupoDeProcessos().getProcessos().get(i).getPid();
                                Runtime.getRuntime().exec(killUbuntu);
                                looca.getGrupoDeProcessos().getProcessos().remove(i);
                            }
                        }
                    } catch (Exception x) {

                    }
                }

            }
            } catch (Exception e) {
            }
            
        }
    };

    private void setUpOs() {
        Looca looca = new Looca();
        // MAP DE PROCESSOS QUE SERÃO FECHADOS

        Map<Integer, String> listax = new HashMap<Integer, String>();
        listax.put(0, "notepad");
        try {

            Double ram = looca.getMemoria().getTotal() / 1073741824.0;
            Double disco = looca.getGrupoDeDiscos().getTamanhoTotal() / 1073741824.0;

            lblHostName.setText(InetAddress.getLocalHost().getHostName());
            lblSistemaOperacional.setText(looca.getSistema().getSistemaOperacional());
            lblProcessador.setText(looca.getProcessador().getNome());
            lblMemoriaRam.setText(String.format("%.1f Gb", ram));
            lblDisco.setText(String.format("%.1f Gb", disco));

            //WHILE
            function.start();

            //FIM DO WHILE
        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblHostName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        closeLbl = new javax.swing.JLabel();
        minimizeLbl = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        lblSistemaOperacional = new javax.swing.JLabel();
        lblProcessador = new javax.swing.JLabel();
        lblMemoriaRam = new javax.swing.JLabel();
        lblDisco = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        txtPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtTxtArea = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        lblUsoDisco = new javax.swing.JLabel();
        lblUsoProcessador = new javax.swing.JLabel();
        lblUsoMemoriaRam = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

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

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));

        lblHostName.setBackground(new java.awt.Color(1, 103, 126));
        lblHostName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblHostName.setForeground(new java.awt.Color(1, 103, 126));
        lblHostName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHostName.setText("HOSTNAME");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/computador.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHostName, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHostName)
                .addGap(129, 129, 129))
        );

        lblHostName.getAccessibleContext().setAccessibleParent(lblHostName);

        jPanel3.setBackground(new java.awt.Color(1, 103, 126));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        closeLbl.setBackground(new java.awt.Color(250, 250, 250));
        closeLbl.setFont(new java.awt.Font("Myanmar Text", 0, 22)); // NOI18N
        closeLbl.setForeground(new java.awt.Color(250, 250, 250));
        closeLbl.setText("X");
        closeLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeLblMouseClicked(evt);
            }
        });
        jPanel3.add(closeLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 30, 30));

        minimizeLbl.setBackground(new java.awt.Color(250, 250, 250));
        minimizeLbl.setFont(new java.awt.Font("Myanmar Text", 0, 48)); // NOI18N
        minimizeLbl.setForeground(new java.awt.Color(250, 250, 250));
        minimizeLbl.setText("-");
        minimizeLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeLblMouseClicked(evt);
            }
        });
        jPanel3.add(minimizeLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 10, 30, 40));

        jTabbedPane1.setBackground(new java.awt.Color(250, 250, 250));
        jTabbedPane1.setAlignmentX(0.0F);
        jTabbedPane1.setAlignmentY(0.0F);
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jPanel4.setBackground(new java.awt.Color(1, 103, 126));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, -1, -1));

        jSeparator2.setBackground(new java.awt.Color(250, 250, 250));
        jSeparator2.setForeground(new java.awt.Color(250, 250, 250));
        jPanel4.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 400, 20));

        jSeparator3.setBackground(new java.awt.Color(250, 250, 250));
        jSeparator3.setForeground(new java.awt.Color(250, 250, 250));
        jPanel4.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 340, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(250, 250, 250));
        jLabel11.setText("Sistema Operacional: ");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(250, 250, 250));
        jLabel12.setText("Processador: ");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, -1, -1));

        jSeparator4.setBackground(new java.awt.Color(250, 250, 250));
        jSeparator4.setForeground(new java.awt.Color(250, 250, 250));
        jPanel4.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 400, 20));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(250, 250, 250));
        jLabel13.setText("Memória RAM: ");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, -1, -1));

        jSeparator5.setBackground(new java.awt.Color(250, 250, 250));
        jSeparator5.setForeground(new java.awt.Color(250, 250, 250));
        jPanel4.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 400, 20));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(250, 250, 250));
        jLabel14.setText("Disco Rígido: ");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, -1, -1));

        jLabel3.setBackground(new java.awt.Color(250, 250, 250));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(250, 250, 250));
        jLabel3.setText("CONFIGURAÇÕES DO SISTEMA");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        jSeparator6.setBackground(new java.awt.Color(250, 250, 250));
        jSeparator6.setForeground(new java.awt.Color(250, 250, 250));
        jPanel4.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 400, 20));

        lblSistemaOperacional.setForeground(new java.awt.Color(250, 250, 250));
        lblSistemaOperacional.setText("-");
        jPanel4.add(lblSistemaOperacional, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, -1));

        lblProcessador.setForeground(new java.awt.Color(250, 250, 250));
        lblProcessador.setText("-");
        jPanel4.add(lblProcessador, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, -1, -1));

        lblMemoriaRam.setForeground(new java.awt.Color(250, 250, 250));
        lblMemoriaRam.setText("-");
        jPanel4.add(lblMemoriaRam, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, -1, -1));

        lblDisco.setForeground(new java.awt.Color(250, 250, 250));
        lblDisco.setText("-");
        jPanel4.add(lblDisco, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hard-disk.png"))); // NOI18N
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema-operacional.png"))); // NOI18N
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cpu.png"))); // NOI18N
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/memoria-ram.png"))); // NOI18N
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, -1, -1));

        jTabbedPane1.addTab("Informações do sistema", jPanel4);

        jPanel5.setBackground(new java.awt.Color(1, 103, 126));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator7.setBackground(new java.awt.Color(250, 250, 250));
        jSeparator7.setForeground(new java.awt.Color(250, 250, 250));
        jPanel5.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 190, 20));

        jLabel8.setBackground(new java.awt.Color(250, 250, 250));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(250, 250, 250));
        jLabel8.setText("PROCESSOS");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        txtTxtArea.setEditable(false);
        txtTxtArea.setColumns(20);
        txtTxtArea.setRows(5);
        txtTxtArea.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane2.setViewportView(txtTxtArea);

        javax.swing.GroupLayout txtPanelLayout = new javax.swing.GroupLayout(txtPanel);
        txtPanel.setLayout(txtPanelLayout);
        txtPanelLayout.setHorizontalGroup(
            txtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        txtPanelLayout.setVerticalGroup(
            txtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addGap(0, 0, 0))
        );

        jPanel5.add(txtPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 400, 280));

        jTabbedPane1.addTab("Processos", jPanel5);

        jPanel6.setBackground(new java.awt.Color(1, 103, 126));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator8.setBackground(new java.awt.Color(250, 250, 250));
        jSeparator8.setForeground(new java.awt.Color(250, 250, 250));
        jPanel6.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 140, 20));

        jLabel9.setBackground(new java.awt.Color(250, 250, 250));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(250, 250, 250));
        jLabel9.setText("EM USO");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        lblUsoDisco.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblUsoDisco.setForeground(new java.awt.Color(250, 250, 250));
        lblUsoDisco.setText("Coletando dados...");
        jPanel6.add(lblUsoDisco, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 236, -1, -1));

        lblUsoProcessador.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblUsoProcessador.setForeground(new java.awt.Color(250, 250, 250));
        lblUsoProcessador.setText("Coletando dados...");
        jPanel6.add(lblUsoProcessador, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 96, -1, -1));

        lblUsoMemoriaRam.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblUsoMemoriaRam.setForeground(new java.awt.Color(250, 250, 250));
        lblUsoMemoriaRam.setText("Coletando dados...");
        jPanel6.add(lblUsoMemoriaRam, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 166, -1, -1));

        jSeparator9.setBackground(new java.awt.Color(250, 250, 250));
        jSeparator9.setForeground(new java.awt.Color(250, 250, 250));
        jPanel6.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 400, 20));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(250, 250, 250));
        jLabel15.setText("Processador: ");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, -1, -1));

        jSeparator10.setBackground(new java.awt.Color(250, 250, 250));
        jSeparator10.setForeground(new java.awt.Color(250, 250, 250));
        jPanel6.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 400, 20));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(250, 250, 250));
        jLabel16.setText("Memória RAM: ");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, -1, -1));

        jSeparator11.setBackground(new java.awt.Color(250, 250, 250));
        jSeparator11.setForeground(new java.awt.Color(250, 250, 250));
        jPanel6.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 400, 20));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(250, 250, 250));
        jLabel17.setText("Disco Rígido: ");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hard-disk.png"))); // NOI18N
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, -1));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cpu.png"))); // NOI18N
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, -1));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/memoria-ram.png"))); // NOI18N
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));

        jTabbedPane1.addTab("Uso", jPanel6);

        jPanel3.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 640, 480));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        mouseX = evt.getX();
        mouseY = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        setLocation(evt.getXOnScreen() - mouseX, evt.getYOnScreen() - mouseY);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void closeLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLblMouseClicked
        function.stop();
        dispose();
        System.exit(0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }//GEN-LAST:event_closeLblMouseClicked


    private void btnExibirUsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExibirUsoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExibirUsoActionPerformed

    private void btnExibirProcessos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExibirProcessos1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExibirProcessos1ActionPerformed

    private void minimizeLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeLblMouseClicked
        this.setExtendedState(TelaAcesso.ICONIFIED);
    }//GEN-LAST:event_minimizeLblMouseClicked

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
            java.util.logging.Logger.getLogger(TelaAcesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAcesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAcesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAcesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAcesso().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel closeLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblDisco;
    private javax.swing.JLabel lblHostName;
    private javax.swing.JLabel lblMemoriaRam;
    private javax.swing.JLabel lblProcessador;
    private javax.swing.JLabel lblSistemaOperacional;
    private javax.swing.JLabel lblUsoDisco;
    private javax.swing.JLabel lblUsoMemoriaRam;
    private javax.swing.JLabel lblUsoProcessador;
    private javax.swing.JLabel minimizeLbl;
    private javax.swing.JPanel txtPanel;
    private javax.swing.JTextArea txtTxtArea;
    // End of variables declaration//GEN-END:variables
}
