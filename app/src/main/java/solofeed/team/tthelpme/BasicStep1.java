package solofeed.team.tthelpme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.HashMap;
import java.util.HashSet;

public class BasicStep1 extends AppCompatActivity {
static HashMap<String,Boolean> myset = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_step1);
       myset.clear();
        CheckBox inter = findViewById(R.id.internet_id);
        inter.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if(b) {
                            myset.put("internet",true) ;
                        }
                        else
                            myset.put("internet",false) ;
                    }
                }
        );
        CheckBox adsl = findViewById(R.id.Adsl_id);
        adsl.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if(b) {
                            myset.put("adsl",true) ;
                        }
                        else
                            myset.put("adsl",false) ;
                    }
                }
        );
        CheckBox wlan = findViewById(R.id.wlan_id);
        wlan.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if(b) {
                            myset.put("wlan",true) ;
                        }
                        else
                            myset.put("wlan",false) ;
                    }
                }
        );
        CheckBox power = findViewById(R.id.power_id);
        power.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if(b) {
                            myset.put("power",true) ;
                        }
                        else
                            myset.put("power",false) ;
                    }
                }
        );
        RadioGroup mygroup = (RadioGroup)findViewById(R.id.r1) ;
        mygroup.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        if ( i == R.id.radioButton)
                            myset.put("filter",true) ;
                        else
                            myset.put("filter",false) ;
                    }
                }
        );
        RadioGroup mygroup2 = (RadioGroup)findViewById(R.id.r2) ;
        mygroup2.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        if ( i == R.id.radioButton9) {
                            myset.put("fast", true);  myset.put("average", false);  myset.put("slow", false); myset.put("null", false);
                        }
                        else if ( i == R.id.radioButton24) {
                            myset.put("fast", false);  myset.put("average", true);  myset.put("slow", false); myset.put("null", false);
                        }
                       else if ( i == R.id.radioButton3) {
                            myset.put("fast", false);  myset.put("average", false);  myset.put("slow", true); myset.put("null", false);
                        }
                       else if ( i == R.id.radioButton4) {
                            myset.put("fast", false);  myset.put("average", false);  myset.put("slow", false); myset.put("null", true);
                        }

                    }
                }
        );
        RadioGroup mygroup3 = (RadioGroup)findViewById(R.id.r3) ;
        mygroup3.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        if ( i == R.id.radioButton55)
                            myset.put("etat",true) ;
                        else
                            myset.put("etat",false) ;
                    }
                }
        );
        RadioGroup mygroup4 = (RadioGroup)findViewById(R.id.r4) ;
        mygroup4.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        if ( i == R.id.radioButton100)
                            myset.put("new",true) ;
                        else
                            myset.put("new",false) ;
                    }
                }
        );
        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean test = true ;
                        if (myset.containsKey("new")==false)
                            test=false;
                        else if (myset.containsKey("filter")==false)
                            test=false;
                        else if (myset.containsKey("etat")==false)
                            test=false;
                        else if (myset.containsKey("fast")==false && myset.containsKey("average")==false && myset.containsKey("slow")==false && myset.containsKey("null")==false    )
                            test=false;
                        else if (myset.containsKey("internet")==false && myset.containsKey("adsl")==false &&  myset.containsKey("power")==false && myset.containsKey("wlan")==false)
                        test=false;
                           if(test==false)
                               Toast.makeText(getApplicationContext(),R.string.alertt,Toast.LENGTH_LONG).show();
                            else
                               startActivity(new Intent(getApplicationContext(),BasicStep2.class));
                    }
                }
        );
    }
}
