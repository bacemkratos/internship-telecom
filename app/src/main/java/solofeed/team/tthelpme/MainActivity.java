package solofeed.team.tthelpme;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
   static String log ="";
  static  String pwd="";
   private MyAppHelper dbHelper ;
   private Button  loginButton ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_main);
       dbHelper = new MyAppHelper(this,"logindatabase" ,null,1);
        final SQLiteDatabase mylogindb=  dbHelper.getWritableDatabase();
     loginButton=(Button) findViewById(R.id.login_id) ;


     loginButton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             String log = ((TextView)findViewById(R.id.user_id)).getText().toString();
             String pwd = ((TextView)findViewById(R.id.password_id)).getText().toString();
             MainActivity.log=log;
             MainActivity.pwd=pwd;
              String[] selectcr = {log,pwd} ;
             Cursor q =  mylogindb.query(dbHelper.dbName,new String[] {dbHelper.username}, dbHelper.username+" like ? and "+dbHelper.password+" like ?", selectcr,null,null, null );

             if (q.getCount()==0)
             {
                 Toast.makeText(getApplicationContext(),R.string.loginerror,Toast.LENGTH_LONG).show();
             }
             else
             {     mylogindb.close();
                 dbHelper.close();
                 startActivity(new Intent(view.getContext(),home.class));
             }
         }
     });

    }
    @Override
    public void onBackPressed()
    {

        // super.onBackPressed(); // Comment this super call to avoid calling finish() or fragmentmanager's backstack pop operation.
    }
}
