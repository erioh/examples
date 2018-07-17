package com.sdemenkov.console;

import com.sdemenkov.dao.QueryExecutor;
import com.sdemenkov.entity.QueryHolder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConsoleReader implements Runnable{
    private List<String> statementList = new ArrayList<>();
    private QueryHolder holder;

    public ConsoleReader(QueryHolder holder) {
        this.holder = holder;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
            StringBuilder queryBuilder = new StringBuilder();
            String sqlStatement;
            while (!"exit".equals((sqlStatement = reader.readLine()))) {
                if (!"/".equals(sqlStatement)) {
                    statementList.add(sqlStatement);
                } else {
                    for (String value : statementList) {
                        queryBuilder.append(value);
                    }
                    holder.setQuery(queryBuilder.toString());
                    queryBuilder = new StringBuilder();
                }
            }
        } catch (IOException e) {
            throw  new RuntimeException(e);
        }
    }
}
