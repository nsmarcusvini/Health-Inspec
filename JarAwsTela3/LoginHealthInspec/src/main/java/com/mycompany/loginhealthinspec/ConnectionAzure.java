package com.mycompany.loginhealthinspec;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionAzure {
    
    private BasicDataSource dataSourceAzure;

    public ConnectionAzure() {
        dataSourceAzure = new BasicDataSource();

        dataSource​Azure.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource​Azure.setUrl("jdbc:sqlserver://svr-health-inspec.database.windows.net:1433;"
            + "database=bd-health-inspec;"
            + "user=admin-health-inspec@svr-health-inspec;"
            + "password=2ads@grupo7;"
            + "encrypt=true;"
            + "trustServerCertificate=false;"
            + "hostNameInCertificate=*.database.windows.net;"
            + "loginTimeout=30;");
    }

    public BasicDataSource getDataSource() {
        return dataSourceAzure;
    }
    
    
    
    String connectionUrl
            = "jdbc:sqlserver://svr-health-inspec.database.windows.net:1433;"
            + "database=bd-health-inspec;"
            + "user=admin-health-inspec@svr-health-inspec;"
            + "password=2ads@grupo7;"
            + "encrypt=true;"
            + "trustServerCertificate=false;"
            + "hostNameInCertificate=*.database.windows.net;"
            + "loginTimeout=30;";

}
