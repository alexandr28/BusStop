package com.acampdev.busstop;

import com.acampdev.busstop.Models.User;

import java.util.UUID;

public class SQLConstants {

    public static final  String DB = "BusStop.db";
    public static final String GENERAR_ID= UUID.randomUUID().toString();
    public static  final  String UserTable="user";
    public static final String COLUMN_ID="id";
    public static final String COLUMN_EMAIL="email";
    public static final String COLUMN_PASSWORD="password";
    // Query
    public static final String SQL_CREATE__TABLE_USER=
             "CREATE TABLE "+ UserTable+" ("+
                     COLUMN_ID +" TEXT PRIMARY KEY,"+
                     COLUMN_EMAIL+" TEXT, "+
                     COLUMN_PASSWORD+" TEXT);"
            ;
    public static final String SQL_DELTE="DROP TABLE "+ UserTable;
    public static final String WHERE_CLAUSE_EMAIL="email = ?";
}
