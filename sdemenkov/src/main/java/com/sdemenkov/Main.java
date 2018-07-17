package com.sdemenkov;

import com.sdemenkov.dao.QueryExecutor;
import com.sdemenkov.entity.Credential;
import com.sdemenkov.fuctory.ConsoleCredentialSupplier;
import com.sdemenkov.fuctory.CredentialSupplier;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        CredentialSupplier supplier = new ConsoleCredentialSupplier();
        Credential credential = supplier.get();
        QueryExecutor queryExecutor = new QueryExecutor(credential);



    }
}
