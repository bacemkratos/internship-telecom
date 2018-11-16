package solofeed.team.tthelpme;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
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

public class FirstTtime extends AppCompatActivity {
    public  static  String Lang ="" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_time);
        File Myfile = getFileStreamPath("Lang.txt");
        if (!Myfile.exists()) {
            //Opening the app for first time
            //Choosing the app language
            setContentView(R.layout.first_time);
            Button eng_button =(Button) findViewById(R.id.eng_b_id);
            Button fr_button =(Button) findViewById(R.id.fr_b_id);
            Button ar_button =(Button) findViewById(R.id.ar_b_id);
            eng_button.setText(R.string.englang);
            fr_button.setText(R.string.frlang);
            ar_button.setText(R.string.arlang);


            fr_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setLocale("fr");
                    Lang="fr";
                    try {
                        FileOutputStream langlog = openFileOutput("Lang.txt",0) ;
                        final OutputStreamWriter wr = new OutputStreamWriter(langlog);
                        wr.write(Lang);
                        wr.close();
                        startActivity( new Intent(getApplicationContext(),MainActivity.class));


                    } catch (IOException e) {
                        Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG);
                    }
                }
            });
            ar_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setLocale("ar");
                    Lang="ar";
                    try {
                        FileOutputStream langlog = openFileOutput("Lang.txt",0) ;
                        final OutputStreamWriter wr = new OutputStreamWriter(langlog);
                        wr.write(Lang);
                        wr.close();
                        startActivity( new Intent(getApplicationContext(),MainActivity.class));
                    } catch (IOException e) {
                        Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG);
                    }
                }
            });
            eng_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setLocale("en");
                    Lang="en";
                    try {
                        FileOutputStream langlog = openFileOutput("Lang.txt",0) ;
                        final OutputStreamWriter wr = new OutputStreamWriter(langlog);
                        wr.write(Lang);
                        wr.close();
                        startActivity( new Intent(getApplicationContext(),MainActivity.class));
                    } catch (IOException e) {
                        Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG);
                    }
                }
            });

        }
        else {
            //if the app was not open for the first time

            try {
                FileInputStream in = openFileInput("Lang.txt")  ;
                InputStreamReader r = new InputStreamReader(in);
                BufferedReader re = new BufferedReader(r);
                Lang=re.readLine();
                setLocale(Lang);


            } catch (FileNotFoundException e) {
                Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG);

            } catch (IOException e) {
                e.printStackTrace();
            }
            startActivity( new Intent(getApplicationContext(),MainActivity.class));


        }
    }
    public void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;

        res.updateConfiguration(conf, dm);


    }
}
