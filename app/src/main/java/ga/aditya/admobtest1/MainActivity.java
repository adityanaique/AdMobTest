package ga.aditya.admobtest1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnShowBannerAd = (Button) findViewById(R.id.button_show_bannerAd);
        btnShowBannerAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showBannerAd = new Intent(MainActivity.this, BannerActivity.class);
                startActivity(showBannerAd);
            }
        });

        Button btnInterstitialAd = (Button) findViewById(R.id.button_interstitialAd);
        btnInterstitialAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showInterstitialActivity = new Intent(MainActivity.this, InterstitialActivity.class);
                startActivity(showInterstitialActivity);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
