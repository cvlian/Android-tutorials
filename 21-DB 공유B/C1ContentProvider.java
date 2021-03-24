package com.example.yangjiwon.city0901;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;

public class C1ContentProvider extends ContentProvider {

    public static final String DB_NAME = "citizenData.db";
    public static final String DB_TABLE = "citizen";
    public static final int DB_VERS = 1;
    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL = "email";
    public static final int ID_COLUMN = 0;
    public static final int NAME_COLUMN = 1;
    public static final int EMAIL_COLUMN = 2;
    private SQLiteDatabase db;
    private Context context;
    private C1DBHelper helper;

    public static final Uri CONTENT_URI = Uri.parse("content://com.example.yangjiwon.city0901.C1Provider/email");

    private static final int DATAS = 1;
    private static final int DATA_ID = 2;
    private static final UriMatcher urimatcher;

    static {
        urimatcher = new UriMatcher(UriMatcher.NO_MATCH);
        urimatcher.addURI("com.example.yangjiwon.city0901.C1Provider", "email", DATAS);
        urimatcher.addURI("com.example.yangjiwon.city0901.C1Provider", "email/#", DATA_ID);
    }

    public C1ContentProvider() {
    }

    @Override
    public boolean onCreate() {
        context = getContext();
        helper = new C1DBHelper(context, DB_NAME, null, DB_VERS);
        try {
            db = helper.getWritableDatabase();
        } catch(SQLiteException e){
            db = helper.getReadableDatabase();
        }
        return (db == null) ? false : true;
    }

    @Override
    public String getType(Uri uri) {
        switch (urimatcher.match(uri)){
            case DATAS:
                return "vnd.android.cursor.dir/vnd.example.yangjiwon.city0901.C1Provider";
            case DATA_ID:
                return "vnd.android.cursor.item/vnd.example.yangjiwon.city0901.C1Provider";
            default:
                return null;
        }
    }


    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
        builder.setTables(DB_TABLE);
        if(urimatcher.match(uri) == DATA_ID){
            String id = uri.getPathSegments().get(1);
            builder.appendWhere(KEY_ID+"="+id);
        }
        Cursor c = builder.query(db, projection, selection, selectionArgs, null, null, null);
        return c;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int cnt;
        switch (urimatcher.match(uri)){
            case DATAS:
                cnt = db.delete(DB_TABLE, selection, selectionArgs);
                break;
            case DATA_ID:
                String id = uri.getPathSegments().get(1);
                cnt = db.delete(DB_TABLE, KEY_ID+"="+id+(!TextUtils.isEmpty(selection)? "AND("+selection+')' : " "), selectionArgs);
                break;
            default:
                return 0;
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return cnt;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long rowID = db.insert(DB_TABLE, null, values);
        if(rowID > 0){
            Uri uri_id = ContentUris.withAppendedId(CONTENT_URI, rowID);
            getContext().getContentResolver().notifyChange(uri_id, null);
            return uri;
        }
        return null;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        int cnt;
        switch(urimatcher.match(uri)){
            case DATAS:
                cnt = db.update(DB_TABLE, values, selection, selectionArgs);
                break;
            case DATA_ID:
                String id = uri.getPathSegments().get(1);
                cnt = db.update(DB_TABLE, values, KEY_ID+"="+id+(!TextUtils.isEmpty(selection)? "AND("+selection+')' : " "), selectionArgs);
                break;
            default:
                return 0;
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return cnt;
    }

    public static class C1DBHelper extends SQLiteOpenHelper{
        public C1DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
            super(context, name, factory, version);
        }
        private static final String DB_CREATE = "create table "+DB_TABLE
                +" ("+KEY_ID+" integer primary key autoincrement, "
                +KEY_NAME+" text not null,"+KEY_EMAIL+" text not null);";
        @Override
        public void onCreate(SQLiteDatabase _db){
            _db.execSQL(DB_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase _db, int _oldVersion, int _newVersion){
            _db.execSQL("DROP TABLE IF EXISTS"+DB_TABLE);
            onCreate(_db);
        }
    }
}