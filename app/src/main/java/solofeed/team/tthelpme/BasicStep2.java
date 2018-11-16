package solofeed.team.tthelpme;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class BasicStep2 extends AppCompatActivity {
int i ;
String h ="";
    SQLiteDatabase myclaim;
gh dbHelper ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_step2);
        dbHelper = new gh(this,"claimlog" ,null,1);
       myclaim=  dbHelper.getWritableDatabase();
        Cursor c = myclaim.query("db",null,null,null,null,null,null);
        i = c.getCount();

        FileInputStream in = null;
        try {
            generateReport(BasicStep1.myset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            in = openFileInput("log.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader r = new InputStreamReader(in);
        BufferedReader re = new BufferedReader(r);
        h="";
        try {
            while(re.ready())
            {
                try {
                    h+=re.readLine()+"\n";
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        TextView t = (TextView)findViewById(R.id.kol);
        t.setText(h);
       Button send = (Button)findViewById(R.id.send_id);
       Button home = (Button)findViewById(R.id.home_id_i);
       home.setOnClickListener(
               new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       startActivity(new Intent(getApplicationContext(),home.class));
                   }
               }
       );

       send.setOnClickListener(
               new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                       Date date = new Date();
                       String j = dateFormat.format(date);
                        ContentValues m = new ContentValues();
                       m.put(dbHelper.username,MainActivity.log);
                       m.put(dbHelper.id,Integer.toString(i));
                      m.put(dbHelper.contenu,"");
                      m.put(dbHelper.date,j.toString());
                       myclaim.insertOrThrow(dbHelper.dbName,null,m);
                      myclaim.close();
                      dbHelper.close();

                       Toast.makeText(getApplicationContext(),"sent",Toast.LENGTH_LONG).show();
                       startActivity(new Intent(getApplicationContext(),home.class));
                   }
               }
       );
    }

    public void generateReport (HashMap<String,Boolean> sett ) throws IOException {
        int i=1;
        FileOutputStream log = null;
        try {
            log = openFileOutput("log.txt",0);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        final OutputStreamWriter wr = new OutputStreamWriter(log);
              wr.write("***"+getResources().getString(R.string.psr)+"***"+"\n"+"\n");

           if(sett.containsKey("new"))
           {
               wr.append(i+") "+getResources().getString(R.string.newhelp)+"\n");

                 i++;
           }
            if(sett.containsKey("internet"))
           {
              wr.append(i+") "+getResources().getString(R.string.inthelp)+"\n");
               i++;
           }
             if(sett.containsKey("adsl"))
           {
               wr.append(i+") "+getResources().getString(R.string.adslhelp)+"\n");
               i++;
           }
             if(sett.get("filter")==false)
           {
             wr.append(i+") "+getResources().getString(R.string.filtehelp)+"\n");
               i++;
           }
            if(sett.get("etat")==false)
           {
               wr.append(i+") "+getResources().getString(R.string.statehe)+"\n");
               i++;
           }
             if(sett.get("slow")==true)
           {
              wr.append(i+") "+getResources().getString(R.string.slowhelp)+"\n");
               i++;

           }
        if(sett.containsKey("power")==true || sett.containsKey("wlan")==true)
        {
            wr.append(i+") "+getResources().getString(R.string.brokehelp)+"\n");
            i++;

        }


wr.close();

    }
}
