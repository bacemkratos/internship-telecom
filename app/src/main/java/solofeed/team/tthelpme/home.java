package solofeed.team.tthelpme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button mCbutton = (Button)findViewById(R.id.claim_id);
        Button cLbutton = (Button)findViewById(R.id.claim_log_id);
        Button infobutton = (Button)findViewById(R.id.myinfo_id);
        mCbutton.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            startActivity( new Intent(getApplicationContext(),Quiz.class));
                                        }
                                    }
        );
        cLbutton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity( new Intent(getApplicationContext(),ClaimsLog.class));
                    }
                }
        );
    }
    @Override
    public void onBackPressed()
    {

        // super.onBackPressed(); // Comment this super call to avoid calling finish() or fragmentmanager's backstack pop operation.
    }
}
