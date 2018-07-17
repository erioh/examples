package com.sdemenkov.dao;

import com.sdemenkov.entity.Credential;
import com.sdemenkov.entity.QueryHolder;

import java.sql.*;

public class QueryExecutor implements Runnable {
    private QueryHolder holder;
    private Credential credential;

    public QueryExecutor(Credential credential, QueryHolder holder) {
        this.holder = holder;
        this.credential = credential;

    }

    @Override
    public void run() {
        while (true) {
            String value;
            if (!"".equals(value = holder.getQuery())) {
                try (Connection connection = DriverManager.getConnection(
                        credential.getUrl(),
                        credential.getUser(),
                        credential.getPassword());
                     Statement statement = connection.createStatement()) {
                    ResultSet resultSet = statement.executeQuery(value);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
