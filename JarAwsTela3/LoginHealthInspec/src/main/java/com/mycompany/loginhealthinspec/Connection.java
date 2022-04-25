package com.mycompany.loginhealthinspec;

import org.apache.commons.dbcp2.BasicDataSource;

public class Connection {

    private BasicDataSource dataSource;

    public Connection() {
        dataSource = new BasicDataSource();

        dataSource​.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource​.setUrl("jdbc:mysql://localhost:3306/health_inspec");
        dataSource​.setUsername("root");
        dataSource​.setPassword("grupo7Sprint*");
    }

    public BasicDataSource getDataSource() {
        return dataSource;
    }

}
