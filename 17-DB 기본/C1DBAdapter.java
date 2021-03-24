package com.example.yangjiwon.city0813;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Yangjiwon on 2016-08-30.
 */
public class C1DBAdapter {
    private static final String DB = "C1DB.db";
    private static final String DB_TABLE = "C1TAble";
    private static final String ID = "_id";
    private static final String NAME = "name";
    private static final int DB_VERS = 2;
    private SQLiteDatabase C1db;
    private final Context context;
    private C1Helper helper;

    public C1DBAdapter(Context context){
        this.context = context;
        helper = new C1Helper(context, DB, null, DB_VERS);
    }

    public void open() throws SQLiteException{
        try{
            C1db = helper.getWritableDatabase();
        } catch(SQLiteException ex){
            C1db = helper.getReadableDatabase();
        }
    }

    public void close(){
        C1db.close();
    }

    public long insertData(String name){
        ContentValues value = new ContentValues();
        value.put(NAME, name);
        return C1db.insert(DB_TABLE, null, value);
    }

    public int removeData(long index){
        return C1db.delete(DB_TABLE, ID + " = " + index, null);
    }

    public int updateData(long index, String name){
        String where = ID+" = "+index;
        ContentValues value = new ContentValues();
        value.put("name", name);
        return C1db.update(DB_TABLE, value, where, null);
    }

    public Cursor getAll(){
        return C1db.query(DB_TABLE, new String[] {ID, NAME}, null, null, null, null, null);
    }

    private static class C1Helper extends SQLiteOpenHelper{
        private static final String DB_CREATE = "create table "+DB_TABLE+" ("+ID+" integer primary key autoincrement, "+NAME+" text not null);";
        public C1Helper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db){
            db.execSQL(DB_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oVers, int nVers){
            db.execSQL("DROP TABLE IF EXISTS "+DB_TABLE);
            onCreate(db);
        }
    }
}