/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginhealthinspec;

import com.github.britooo.looca.api.core.Looca;
import java.awt.Color;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;
import org.springframework.jdbc.core.JdbcTemplate;
import oshi.jna.platform.mac.SystemB;

/**
 *
 * @author nicol
 */
public class App {

    public static void main(String[] args) throws UnknownHostException {
        String hostName = InetAddress.getLocalHost().getHostName();
        ConnectionAzure azure = new ConnectionAzure();
        JdbcTemplate con = new JdbcTemplate(azure.getDataSource());
        Scanner scan = new Scanner(System.in);
        Looca looca = new Looca();
        Inserts inserts = new Inserts();
        ResultSet resultSetEmail = null;
        String so = looca.getSistema().getSistemaOperacional();
        Integer bits = looca.getSistema().getArquitetura();

        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            java.sql.Connection connection = DriverManager.getConnection(azure.connectionUrl);
            Statement statement = connection.createStatement();
            System.out.println("Conexão obtida com sucesso!");
            String selectEmailSql = "SELECT email, senha FROM hospital;";
            resultSetEmail = statement.executeQuery(selectEmailSql);

            System.out.println("Digite seu email: ");
            String email = scan.nextLine();
            System.out.println("Digite sua senha: ");
            String senha = scan.nextLine();

            while (resultSetEmail.next()) {

                if (email.equals(resultSetEmail.getString(1)) && senha.equals(resultSetEmail.getString(2))) {
                    Log.guardarLog("Login efetuado com sucesso");
                    System.out.println("Login efetuado com sucesso");
                    inserts.msg();
                    

                } else {
                    Log.guardarLog("Tentativa de login falhou");
                    System.out.println("Usuário ou senha incorretas, tente novamente!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
