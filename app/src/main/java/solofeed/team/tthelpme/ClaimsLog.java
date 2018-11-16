package solofeed.team.tthelpme;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ClaimsLog extends AppCompatActivity {
    String[] dates;
    String[] ids ;
    String[] contenus ;;
  gh dbHelper;
    SQLiteDatabase mybd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dbHelper = new gh(this,"bb" ,null,1);
        mybd=  dbHelper.getWritableDatabase();
        Cursor q = mybd.query("db",null,null,null,null,null,null);
        Log.d("debugs",MainActivity.log);
        Log.d("debug",String.valueOf(q.getCount()));
        ArrayList<String> dateslist = new ArrayList<>();
        ArrayList<String> contenuslist = new ArrayList<>();
        ArrayList<String> idslist = new ArrayList<>();

        if (q.moveToFirst())
        {
            do
            {
                String path=q.getString(q.getColumnIndex("id"));
                idslist.add(path);
                String path2=q.getString(q.getColumnIndex("date"));
                dateslist.add(path2);
                String path3=q.getString(q.getColumnIndex("contenu"));
                contenuslist.add(path3);



            } while (q.moveToNext());
        }

 dates = new String[dateslist.size()];
 ids = new String[idslist.size()];
 contenus = new String[contenuslist.size()];
  dates = dateslist.toArray(dates) ;
        ids = idslist.toArray(ids) ;
        contenus = contenuslist.toArray(contenus);


        setContentView(R.layout.activity_claims_log);
        ListView mylist  = (ListView)findViewById(R.id.mylist_id);
        myadapter mya = new myadapter();
        mylist.setAdapter(mya);

    }
    class myadapter extends BaseAdapter {


        @Override
        public int getCount() {

            return ids.length;

        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view= getLayoutInflater().inflate(R.layout.custom,null);
            TextView t = (TextView) view.findViewById(R.id.id_id);
            TextView d =  (TextView) view.findViewById(R.id.date_id);
            Button b =   (Button) view.findViewById(R.id.view_id);
            t.setText(ids[i]);
            d.setText(dates[i]);

            return view;
        }
    }
}
