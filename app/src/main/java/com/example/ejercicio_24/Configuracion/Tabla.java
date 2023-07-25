package com.example.ejercicio_24.Configuracion;

public class Tabla {

    //Nombre de la base de datos
    public static final String NameDatabase = "Firma";

    //Tabla Base de Datos

    public static final String tablaFirma = "Firma";

    //Campos de la tabla personas

    public static final String id = "id";
    public static final String descripcion = "descripcion";
    public static final String firma = "firma";

    //DDL Create and Drop

    public static final String CreateTablefirma = "CREATE TABLE FIRMA"+ "(id INTEGER PRIMARY KEY AUTOINCREMENT, descripcion TEXT, firma BLOB)";

    public static final String DROPTablefirma = "DROP TABLE IF EXISTS Firma";

    public static final String SelectTablefirma = "SELECT * FROM " + Tabla.tablaFirma;
}

