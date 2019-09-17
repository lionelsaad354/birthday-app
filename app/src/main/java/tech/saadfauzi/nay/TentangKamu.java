package tech.saadfauzi.nay;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import de.hdodenhof.circleimageview.CircleImageView;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class TentangKamu extends AppCompatActivity {
    private CircleImageView close;
    private LinearLayout llIg, llFb;
    String URL_IG = "https://www.instagram.com/nailis_ulya/";
    String URL_FB = "https://www.facebook.com/nailiztulya";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang_kamu);
        close = findViewById(R.id.ci_close_tentang);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        llIg = findViewById(R.id.id_ig);
        llFb = findViewById(R.id.id_fb);
    }

    @Override
    protected void onStart() {
        super.onStart();
        llIg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri url_ig = Uri.parse(URL_IG);
                Intent intentIg = new Intent(Intent.ACTION_VIEW, url_ig);
                startActivity(intentIg);
            }
        });
        llFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri url_fb = Uri.parse(URL_FB);
                Intent intentFb = new Intent(Intent.ACTION_VIEW, url_fb);
                startActivity(intentFb);
            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
