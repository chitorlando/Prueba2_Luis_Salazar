package com.Luis_Salazar_2doParcial_prueba_01.apps.Luis_Salazar_2doParcial_01_prueba;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

public class LOSR_ClienteDAL {
    private LOSR_ClientesHelper clientesHelper; // crea la BD
    private SQLiteDatabase sql;
    private Context context;

    public LOSR_ClienteDAL(Context context){
        this.context=context;
    }

    public void openDAL(){
        clientesHelper = new LOSR_ClientesHelper(context,"ClientesDB",null,1);
        sql=clientesHelper.getWritableDatabase();
    }

    public void closeDAL(){
        sql.close();
    }

    public long insertDAL(LOSR_Cliente cliente){
        long count =0;
        try {
            this.openDAL();
            ContentValues values = new ContentValues();
            values.put("nombre",cliente.getNombre());
            values.put("Apellido",cliente.getApellido());
            values.put("Correo",cliente.getCorreo());

            count = sql.insert("Clientes",null,values);

        }catch (Exception e){
            throw e;
        }finally {
            sql.close();
        }
        return count;
    }

    public LOSR_Cliente selectByCodigoDAL(int codigo){
        LOSR_Cliente cliente=null;
        try {
            this.openDAL();
            String select = "SELECT Codigo, Nombre, Apellido, Correo FROM Clientes WHERE Codigo="+codigo;
            Cursor cursor = sql.rawQuery(select, null);

            if(cursor.moveToFirst())
            {
                cliente = new LOSR_Cliente();
                cliente.setNombre(cursor.getString(1));
                cliente.setApellido(cursor.getString(2));
                cliente.setCorreo(cursor.getString(3));
            }

        }catch (Exception e){
            throw e;
        }finally {
            sql.close();
        }
        return cliente;
    }

    public ArrayList<String> selectDAL(){
        ArrayList<String> list = null;
        try{
            this.openDAL();
            String select = "SELECT Codigo, Nombre, Apellido, Correo FROM Clientes";
            Cursor cursor = sql.rawQuery(select, null);

            if(cursor.moveToFirst())
            {
                list = new ArrayList<String>();
                do{
                    list.add(
                            cursor.getString(1)+" "+
                                    cursor.getString(2)+" "+
                                    cursor.getString(3)+" "+
                                    cursor.getString(4)
                    );
                }while (cursor.moveToNext());

            }

        }catch (Exception e){
            throw e;
        }finally {
            sql.close();
        }
        return list;
    }

    public ArrayList<LOSR_Cliente> selectDAL2(){
        ArrayList<LOSR_Cliente> list = null;
        try{
            this.openDAL();
            String select = "SELECT Codigo, Nombre, Apellido, Correo FROM Clientes";
            Cursor cursor = sql.rawQuery(select, null);

            if(cursor.moveToFirst())
            {
                list = new ArrayList<LOSR_Cliente>();
                do{
                    LOSR_Cliente cliente = new LOSR_Cliente();
                    cliente.setCodigo(Integer.valueOf(cursor.getString(0)));
                    cliente.setNombre(cursor.getString(1));
                    cliente.setApellido(cursor.getString(2));
                    cliente.setCorreo(cursor.getString(3));
                    list.add(cliente);
                }while (cursor.moveToNext());

            }

        }catch (Exception e){
            throw e;
        }finally {
            sql.close();
        }
        return list;
    }

    public int deleteDAL(int codigo){
        int count =0;
        try {
            this.openDAL();
            count = sql.delete("Clientes","Codigo="+codigo,null);

        }catch (Exception e){
            throw e;
        }finally {
            sql.close();
        }
        return count;
    }

    public int updateDAL(LOSR_Cliente cliente){
        int count =0;
        try{
            this.openDAL();
            ContentValues values = new ContentValues();
            values.put("Nombre",cliente.getNombre());
            values.put("Apellido",cliente.getApellido());
            values.put("Correo",cliente.getCorreo());
            count=sql.update("Clientes",values,"Codigo="+cliente.getCodigo(),null);
        }catch (Exception e){
            throw e;
        }finally {
            this.sql.close();
        }
        return count;
    }
}
