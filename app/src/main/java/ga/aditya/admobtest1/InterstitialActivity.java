package ga.aditya.admobtest1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

/**
 * Shows an interstitial ad.
 */
public class InterstitialActivity extends AppCompatActivity {
    private Button mShowButton;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstitial);

        mShowButton = (Button) findViewById(R.id.button_show_interstitialAd);
        mShowButton.setEnabled(false);
    }

    public void loadInterstitial(View view) {
        mShowButton.setEnabled(false);
        mShowButton.setText(getResources().getString(R.string.interstitial_loading));

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getResources().getString(R.string.interstitial_ad_unit_id));
        mInterstitialAd.setAdListener(new ToastAdListener(this) {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                mShowButton.setText(getResources().getString(R.string.show_interstitial_ad));
                mShowButton.setEnabled(true);
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                super.onAdFailedToLoad(errorCode);
                mShowButton.setText(getErrorReason());
            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest);
    }

    public void showInterstitial(View view) {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
        mShowButton.setText(getResources().getString(R.string.interstitial_not_ready));
        mShowButton.setEnabled(false);
    }
}
