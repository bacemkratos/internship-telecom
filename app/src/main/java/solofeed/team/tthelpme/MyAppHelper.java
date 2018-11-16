package solofeed.team.tthelpme;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Bacem on 26/01/2018.
 */

public class MyAppHelper extends SQLiteOpenHelper {
    String dbName ="ttdb" ;

    String username ="username" ;
    String password ="password" ;

    public MyAppHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
sqLiteDatabase.execSQL("create table "+dbName+"("+
                username+" text primary key ,  "+
                password+" text  "
        +")");
        ContentValues cv = new ContentValues();
        cv.put(username,"73 261 695");
        cv.put(password,"Abz345ZO");
        sqLiteDatabase.insert(dbName,null,cv);
        cv.put(username,"73 324 449");
        cv.put(password,"12yoA78K");
        sqLiteDatabase.insert(dbName,null,cv);
        cv.put(username,"22");
        cv.put(password,"aa");
        sqLiteDatabase.insert(dbName,null,cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
