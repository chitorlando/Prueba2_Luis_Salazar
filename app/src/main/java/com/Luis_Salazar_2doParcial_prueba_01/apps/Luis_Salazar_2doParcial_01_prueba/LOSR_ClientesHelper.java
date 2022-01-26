package com.Luis_Salazar_2doParcial_prueba_01.apps.Luis_Salazar_2doParcial_01_prueba;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;


public class LOSR_ClientesHelper extends SQLiteOpenHelper {

    private String createTable_Clientes = "CREATE TABLE Clientes " +
            "(Codigo INTEGER PRIMARY KEY AUTOINCREMENT, " + "Nombre TEXT, " +
            "Apellido TEXT, " + "Correo TEXT )";

    public LOSR_ClientesHelper(@Nullable Context context, @Nullable String name,
                               @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //ejecutar el SQL para crear la estructura de las tablas
        sqLiteDatabase.execSQL(createTable_Clientes);
        //sql: segunda
        //sql: tercera
        //vistas, triggers, etc...
        //sqLiteDatabase.execSQL("INSERT INTO Clientes...")

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // borrar la tablas
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Clientes");
        // SQL para crear la tabla o tablas con nueva estructura
        // sqLiteDatabase.execSQL(createTable_Clientes_modificado);
        sqLiteDatabase.execSQL(createTable_Clientes);
    }
}
