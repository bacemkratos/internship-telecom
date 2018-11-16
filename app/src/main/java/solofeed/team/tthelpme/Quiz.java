package solofeed.team.tthelpme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Quiz extends AppCompatActivity {
static boolean advanced = false ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Button basicB = (Button) findViewById(R.id.basic_b_id);
        Button advancedB = (Button) findViewById(R.id.advanced);
        basicB.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getApplicationContext(),BasicStep1.class));
                    }
                }
        );
        advancedB.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getApplicationContext(),AdvancedStep1.class));
                    }
                }
        );




    }
}
