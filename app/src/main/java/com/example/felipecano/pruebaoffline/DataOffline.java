package com.example.felipecano.pruebaoffline;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by felipecano on 3/01/18.
 */

public class DataOffline extends SQLiteOpenHelper {

    public DataOffline(Context context) {
        super(context, BDPruebaOffline.DATABASE_NAME, null, BDPruebaOffline.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Creamos y ejecutamos la instruccion Sql para crear la Base de datos
        String CREATE_ANEXOS_TABLE = "CREATE TABLE " + BDPruebaOffline.TABLE_PRUEBAOFFLINE + "("
                + BDPruebaOffline.BD_ID + " INTEGER PRIMARY KEY,"
                + BDPruebaOffline.BD_Name + " TEXT,"
                + BDPruebaOffline.BD_LastName + " TEXT,"
                + BDPruebaOffline.BD_Address + " TEXT" + ")";

        sqLiteDatabase.execSQL(CREATE_ANEXOS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + BDPruebaOffline.TABLE_PRUEBAOFFLINE);

        // re-iniciamos metodo principal
        onCreate(sqLiteDatabase);
    }

    //Funcion Para añadir usuario a la base de datos
    public void AddPerson(String name, String lastname, String address) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(BDPruebaOffline.BD_Name, name);
        values.put(BDPruebaOffline.BD_LastName, lastname);
        values.put(BDPruebaOffline.BD_Address, address);

        System.out.println("el anexo es agregado es"  + name +  "lastname" + lastname +  " address" + address );

        try{
            // Insertamos datos
            db.insert(BDPruebaOffline.TABLE_PRUEBAOFFLINE, null, values);
        }catch (Exception e){

        }
        // cerramos conexion a la base de datos
        db.close();
    }


    public List<String> SearchPerson(String name, String id)
    {
        id = id.replace(" ","");

        List<String> arraylist = new ArrayList<String>();
        SQLiteDatabase sql=this.getReadableDatabase();

        String query = "SELECT  *FROM " + BDPruebaOffline.TABLE_PRUEBAOFFLINE + " where "+ BDPruebaOffline.BD_Name +" = '"+name+"' AND "+ BDPruebaOffline.BD_ID+" = '"+ id+"'";
        System.out.println("el anexo es  Buscado " + query);
        //String query = "SELECT  *FROM clientes where user_ID_users = 2345";
        Cursor c = sql.rawQuery(query, null);
        while(c.moveToNext()) {
            arraylist.add(c.getString(1));
        }
        c.close();
        sql.close();
        return arraylist;

    }

}
