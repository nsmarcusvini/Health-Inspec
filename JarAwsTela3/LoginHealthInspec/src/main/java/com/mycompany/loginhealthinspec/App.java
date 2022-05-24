/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginhealthinspec;

import java.awt.Color;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Scanner;
import oshi.jna.platform.mac.SystemB;

/**
 *
 * @author nicol
 */
public class App {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ConnectionAzure azure = new ConnectionAzure();

        ResultSet resultSetEmail = null;

        
            
                try {
                    
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                    java.sql.Connection connection = DriverManager.getConnection(azure.connectionUrl);
                    Statement statement = connection.createStatement();
                    System.out.println("Conexão obtida com sucesso!");
                    String selectEmailSql = "SELECT email, senha FROM hospital;";
                    resultSetEmail = statement.executeQuery(selectEmailSql);

                    while (resultSetEmail.next()) {                        
                        
                        System.out.println("Digite seu email: ");
                        String email = scan.nextLine();
                        System.out.println("Digite sua senha: ");
                        String senha = scan.nextLine();

                        if (email.equals(resultSetEmail.getString(1)) && senha.equals(resultSetEmail.getString(2))) {
                            Log.guardarLog("Login efetuado com sucesso");
                            System.out.println("Login efetuado com sucesso");
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
