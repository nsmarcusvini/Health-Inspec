package com.mycompany.loginhealthinspec;

import com.github.britooo.looca.api.core.Looca;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

        System.out.println(String.format("%s %.2f%% %s %.2f GB USADOS %s %.2f USADOS",
                espaco, looca.getProcessador().getUso(),
                espaco, ram, espaco, tamanho / 1073741824.0));

        // Máquinas
        String insertMaq = "INSERT INTO maquinas (tipoMaquina, fkTecnico, nomeMaquina, sistemaOperacional, arquitetura) VALUES (?, ?, ?, ?, ?)";

        con.update(insertMaq,
                "Computador",
                gerador.nextInt(3) + 1,
                hostName,
                so,
                bits
        );

        con.update(insertMaq,
                "Totem",
                gerador.nextInt(4) + 1,
                hostName,
                so,
                bits
        );

        con.update(insertMaq,
                "Computador",
                1,
                hostName,
                so,
                bits
        );

        // Componentes:
        String insertCompMaq = "INSERT INTO componentes_has_maquinas (fkComponente, fkMaquina, totalComponente, unidadeMedida) VALUES (?, ?, ?, ?);";

        //CPU
        con.update(insertCompMaq,
                1,
                1,
                looca.getProcessador().getFrequencia(),
                "Ghz"
        );

        con.update(insertCompMaq,
                1,
                2,
                looca.getProcessador().getFrequencia(),
                "Ghz"
        );

        con.update(insertCompMaq,
                1,
                3,
                looca.getProcessador().getFrequencia(),
                "Ghz"
        );

        //RAM
        con.update(insertCompMaq,
                2,
                1,
                String.format("Memória de %.1f",
                        ram),
                "Gb"
        );

        con.update(insertCompMaq,
                2,
                2,
                String.format("Memória de %.1f",
                        ram),
                "Gb"
        );

        con.update(insertCompMaq,
                2,
                3,
                String.format("Memória de %.1f",
                        ram),
                "Gb"
        );

        //DISCO
        con.update(insertCompMaq,
                3,
                1,
                String.format("Disco de %.1f",
                        disco),
                "Gb"
        );

        con.update(insertCompMaq,
                3,
                2,
                String.format("Disco de %.1f",
                        disco),
                "Gb"
        );

        con.update(insertCompMaq,
                3,
                3,
                String.format("Disco de %.1f",
                        disco),
                "Gb"
        );
        
        while (contador) {

            System.out.println(String.format("%s %.2f%% %s %.2f GB USADOS %s %.2f USADOS",
                    espaco, looca.getProcessador().getUso(),
                    espaco, ram, espaco, tamanho / 1073741824.0));

            // Registros:
            String insertReg = "INSERT INTO registros (fkComponenteMaquina, fkComponente, fkMaquina, dataHora, totalUsado) VALUES (?, ?, ?, ?, ?)";

            //CPU
            con.update(insertReg,
                    1,
                    1,
                    gerador.nextInt(3) + 1,
                    LocalDateTime.now(),
                    looca.getProcessador().getUso()
            );

            //RAM
            con.update(insertReg,
                    1,
                    2,
                    gerador.nextInt(3) + 1,
                    LocalDateTime.now(),
                    looca.getMemoria().getEmUso()
            );

            //DISCO
            con.update(insertReg,
                    1,
                    3,
                    gerador.nextInt(3) + 1,
                    LocalDateTime.now(),
                    tamanho);
        }

    }

}
