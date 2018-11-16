package solofeed.team.tthelpme;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Bacem on 06/02/2018.
 */

public class gh extends SQLiteOpenHelper {
    String dbName ="db" ;

    String username ="username" ;
    String id ="id" ;
    String contenu ="contenu" ;
    String date ="date" ;


    public gh(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+dbName+"("+
                username+" text ,  "+
                id+" text  , " +
                contenu+" text  , "+
                date+" text  "
                +");");
        ContentValues cv = new ContentValues();
        cv.put(username,"22");
        cv.put(id,"0");
        cv.put(contenu,"s");
        cv.put(date,"15/01/2018");
        sqLiteDatabase.insert(dbName,null,cv);

        cv.put(username,"22");
        cv.put(id,"1");
        cv.put(contenu,"AbzsdfsdfsdfsdfO");
        cv.put(date,"05/01/2018");
        sqLiteDatabase.insert(dbName,null,cv);
        cv.put(username,"22");
        cv.put(id,"2");
        cv.put(contenu,"AbzsdfssdfsdfsdfsdfO");
        cv.put(date,"02/01/2018");
        sqLiteDatabase.insert(dbName,null,cv);
        cv.put(username,"22");
        cv.put(id,"3");
        cv.put(contenu,"AbzsdfssdfsdfsdfsdfO");
        cv.put(date,"01/02/2018");
        sqLiteDatabase.insert(dbName,null,cv);

        cv.put(username,"22");
        cv.put(id,"4");
        cv.put(contenu,"AbzsdfssdfsdfsdfsdfO");
        cv.put(date,"29/12/2017");
        sqLiteDatabase.insert(dbName,null,cv);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
