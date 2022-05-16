package com.mycompany.loginhealthinspec;

public class ConnectionAzure {

    String connectionUrl
            = "jdbc:sqlserver://svr-health-inspec.database.windows.net:1433;"
            + "database=bd-health-inspec;"
            + "user=admin-health-inspec@svr-health-inspec;"
            + "password=2ads@grupo7;"
            + "encrypt=true;"
            + "trustServerCertificate=false;"
            + "hostNameInCertificate=*.database.windows.net;"
            + "loginTimeout=30;";

    public ConnectionAzure() {
    }
}
