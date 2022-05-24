package com.mycompany.loginhealthinspec;

import com.github.britooo.looca.api.core.Looca;
import com.mysql.cj.xdevapi.PreparableStatement;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Random;
import org.springframework.jdbc.core.JdbcTemplate;

public class Inserts {

    ConnectionAzure azure = new ConnectionAzure();
    Looca looca = new Looca();
    Long tempoDeUso = looca.getSistema().getTempoDeAtividade();
    Double horasLigado1 = tempoDeUso / 60.0;
    Double horasLigado2 = horasLigado1 / 60.0;
    String formatado = String.format("%.1f", horasLigado2);
    String so = looca.getSistema().getSistemaOperacional();
    Integer bits = looca.getSistema().getArquitetura();
    ResultSet resultSetEmail = null;

    String tipoMaquina = "Computador";
    Random gerador = new Random();

    Double ram = looca.getMemoria().getEmUso() / 1073741824.0;
    Double disco = looca.getGrupoDeDiscos().getTamanhoTotal() / 1073741824.0;
    double tamanho = new File("C:\\").getTotalSpace() - new File("C:\\").getFreeSpace();
    double tamanhoTotal = new File("C:\\").getTotalSpace();

    public void msg() throws UnknownHostException {
        Boolean contador = true;
        String espaco = "==========";
        String so = looca.getSistema().getSistemaOperacional();
        Integer bits = looca.getSistema().getArquitetura();
        ConnectionAzure azure = new ConnectionAzure();
        JdbcTemplate con = new JdbcTemplate(azure.getDataSource());
        String hostName = InetAddress.getLocalHost().getHostName();
        System.out.println(String.format("%s CAPTURANDO DADOS DA MÁQUINA %s", espaco, espaco));
        System.out.println(String.format("%s DADOS CAPTURADOS DA MÁQUINA: %s", espaco, espaco));
        System.out.println(String.format("%s PROCESSADOR %s MEMÓRIA RAM %s DISCO %s",
                espaco, espaco, espaco, espaco));

        while (contador) {

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
              
        }

    }

    public void insertMaquinas() throws UnknownHostException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

        /*
        String insert= "INSERT INTO maquinas VALUES (null, ?, ?, ?, ?, ?);";
        
        con.update(insert,
                "Computador",
                1,
                hostName,
                so,
                bits
                );
        
        
        /*
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
        java.sql.Connection connection = DriverManager.getConnection(azure.connectionUrl);
        connection.createStatement();
        PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO maquinas (tipoMaquina, fkTecnico, nomeMaquina, sistemaOperacional, arquitetura) VALUES (?, ?, ?, ?, ?);");
        insertStatement.setString(1, "Computador");
        insertStatement.setInt(2, 1);
        insertStatement.setString(3, hostName);
        insertStatement.setString(4, so);
        insertStatement.setInt(5, bits);
        insertStatement.execute();

        /*
         //con.update("INSERT INTO maquinas VALUES (?, ?, ?, ?, ?, ?)",
           //     null, tipoMaquina, hostName, so, bits, 1);
        
        statement.executeUpdate(String.format("INSERT INTO maquinas VALUES (%s, %d, %s, %s, %d)",
                tipoMaquina, 1,  hostName, so, bits));
         */
    }

    public void insertComponentes() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnknownHostException {
        /*
        ConnectionAzure azure = new ConnectionAzure();
        JdbcTemplate con = new JdbcTemplate(azure.getDataSource());
        String hostName = InetAddress.getLocalHost().getHostName();
        
        String insert= "INSERT INTO componentes VALUES (null, ?, ?, ?, ?);";
        
        con.update(insert,
                hostName,
                "CPU",
                looca.getProcessador().getNome(),
                1
                );
        
        
        
        
        
        /*
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
        java.sql.Connection connection = DriverManager.getConnection(azure.connectionUrl);
        connection.createStatement();
        
        PreparedStatement insertCPU = connection.prepareStatement("INSERT INTO componentes (nomeComponente, tipoComponente, descricaoComponente, fkMaquina) VALUES (?, ?, ?, ?);");
        insertCPU.setString(1, InetAddress.getLocalHost().getHostName());
        insertCPU.setString(2, "Processador");
        insertCPU.setString(3, looca.getProcessador().getNome());
        insertCPU.setInt(4, 1);
        insertCPU.execute();

        PreparedStatement insertRAM = connection.prepareStatement("INSERT INTO componentes (nomeComponente, tipoComponente, descricaoComponente, fkMaquina) VALUES (?, ?, ?, ?);");
        insertRAM.setString(1, "Kingston");
        insertRAM.setString(2, "Memória Ram");
        insertRAM.setString(3, looca.getMemoria().toString());
        insertRAM.setInt(4, 1);
        insertRAM.execute();

        PreparedStatement insertHD = connection.prepareStatement("INSERT INTO componentes (nomeComponente, tipoComponente, descricaoComponente, fkMaquina) VALUES (?, ?, ?, ?);");
        insertHD.setString(1, "SSD");
        insertHD.setString(2, "Disco");
        insertHD.setString(3, looca.getGrupoDeDiscos().getTamanhoTotal().toString());
        insertHD.setInt(4, 1);
        insertHD.execute();

        // Processador
        /*con.update("INSERT INTO componentes VALUES (?, ?, ?, ?);",
                null, looca.getProcessador().getNome(),
                looca.getProcessador().getFabricante() + " "
                + looca.getProcessador().getMicroarquitetura(),
                gerador.nextInt(4) + 1);
        
        
        
        statement.executeUpdate(String.format("INSERT INTO componentes VALUES (%s, %s, %s, %d);",
                looca.getProcessador().getNome(), 
                "CPU", looca.getProcessador().getMicroarquitetura(),
                gerador.nextInt(4) + 1));
        
        // Memória Ram
        con.update("INSERT INTO componentes VALUES (?, ?, ?, ?);",
                null, "RAM", looca.getMemoria().toString(),
                gerador.nextInt(4) + 1);
        
        statement.executeUpdate(String.format("INSERT INTO componentes VALUES (%s, %s, %s, %d);",
                "RAM", 
                "8GB", looca.getMemoria().toString(),
                gerador.nextInt(4) + 1));
        

        // Disco
        con.update("INSERT INTO componentes VALUES (?, ?, ?, ?);",
                null, "Disco", tamanhoTotal,
                gerador.nextInt(4) + 1);
        
        statement.executeUpdate(String.format("INSERT INTO componentes VALUES (%s, %s, %s, %d);",
                "Disco", looca.getGrupoDeDiscos().toString(), tamanhoTotal, 
                gerador.nextInt(4) + 1));
         */
    }

    public void insertRegistros() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        /*
        ConnectionAzure azure = new ConnectionAzure();
        JdbcTemplate con = new JdbcTemplate(azure.getDataSource());
        
        
        String insert= "INSERT INTO registros VALUES (null, null, ?, ?)";
        
        con.update(insert,
                looca.getProcessador().getUso(),
                1
                );
        
        
        
        /*
        PreparedStatement insertRegistroCPU = connection.prepareStatement("INSERT INTO registros (dataHora, totalUsado, fkComponente) VALUES (?, ?, ?);");
        insertRegistroCPU.setLong(1, Calendar.getInstance().getTimeInMillis());
        insertRegistroCPU.setDouble(2, looca.getProcessador().getUso());
        insertRegistroCPU.setInt(3, 1);
        insertRegistroCPU.executeUpdate();

        PreparedStatement insertRegistroRAM = connection.prepareStatement("INSERT INTO registros (dataHora, totalUsado, fkComponente) VALUES (?, ?, ?);");
        insertRegistroRAM.setLong(1, Calendar.getInstance().getTimeInMillis());
        insertRegistroRAM.setDouble(2, looca.getMemoria().getEmUso());
        insertRegistroRAM.setInt(3, 1);
        insertRegistroRAM.execute();

        PreparedStatement insertRegistroDISCO = connection.prepareStatement("INSERT INTO registros (dataHora, totalUsado, fkComponente) VALUES (?, ?, ?);");
        insertRegistroDISCO.setLong(1, Calendar.getInstance().getTimeInMillis());
        insertRegistroDISCO.setDouble(2, tamanho);
        insertRegistroDISCO.setInt(3, 1);
        insertRegistroDISCO.execute();

        // Processador
        /*con.update("INSERT INTO registros VALUES (?, ?, ?, ?)",
                null, LocalDateTime.now(), looca.getProcessador().getUso(),
                gerador.nextInt(2) + 1);
        
        
        statement.executeUpdate(String.format("INSERT INTO registros VALUES (%s, %.2f, %d);",
                LocalDateTime.now(), looca.getProcessador().getUso(), 
                gerador.nextInt(2) + 1));
        
        
        // Memória
        
        con.update("INSERT INTO registros VALUES (?, ?, ?, ?)",
                null, LocalDateTime.now(), ram,
                gerador.nextInt(2) + 1);
        
        
        statement.executeUpdate(String.format("INSERT INTO registros VALUES (%s, %.2f, %d);",
                LocalDateTime.now(), ram, 
                gerador.nextInt(2) + 1));
        
        
        // Disco
        
        con.update("INSERT INTO registros VALUES (?, ?, ?, ?)",
                null, LocalDateTime.now(), tamanho, gerador.nextInt(2) + 1);
        
        statement.executeUpdate(String.format("INSERT INTO registros VALUES (%s, %.2f, %d);",
                LocalDateTime.now(), tamanho, 
                gerador.nextInt(2) + 1));
         */
    }

}
