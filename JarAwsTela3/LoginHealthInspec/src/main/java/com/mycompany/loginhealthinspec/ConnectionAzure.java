package com.mycompany.loginhealthinspec;

import java.awt.Color;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

public class ConnectionAzure {

    private String connectionUrl
            = "jdbc:sqlserver://svr-health-inspec.database.windows.net:1433;"
            + "database=bd-health-inspec;"
            + "user=admin-health-inspec@svr-health-inspec;"
            + "password=2ads@grupo7;"
            + "encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;"
            + "loginTimeout=30;";

    public String getEmail() throws SQLException {

        ResultSet resultSetEmail = null;

        try ( java.sql.Connection connection = DriverManager.getConnection(connectionUrl);  Statement statement = connection.createStatement();) {

            String selectEmailSql = "select email from empresa;";
            resultSetEmail = statement.executeQuery(selectEmailSql);
            
        while( resultSetEmail.next() ) {
            return resultSetEmail.getString("email") + "";
        }
            

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getSenha() throws SQLException {

        ResultSet resultSetSenha = null;

        try ( java.sql.Connection connection = DriverManager.getConnection(connectionUrl);  Statement statement = connection.createStatement();) {

            String selectSenhaSql = "select senha from empresa;";
            resultSetSenha = statement.executeQuery(selectSenhaSql);
        while( resultSetSenha.next() ) {
            return resultSetSenha.getString("senha") + "";
        }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
