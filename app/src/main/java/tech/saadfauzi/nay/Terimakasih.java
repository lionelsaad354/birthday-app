package tech.saadfauzi.nay;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import de.hdodenhof.circleimageview.CircleImageView;

public class Terimakasih extends AppCompatActivity {
    private CircleImageView close;
    private String URL = "http://www.saadfauzi.tech/2018/08/nay.html";
    TextView tvPrivacyPolicy, tvThanks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terimakasih);
        close = findViewById(R.id.ci_close_thanks);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tvPrivacyPolicy = findViewById(R.id.privacy_policy);
        tvThanks = findViewById(R.id.tv_thanks);
        loadThanks();
    }

    @Override
    protected void onStart() {
        super.onStart();
        tvPrivacyPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri url_privacy = Uri.parse(URL);
                Intent intentPrivacy = new Intent(Intent.ACTION_VIEW, url_privacy);
                startActivity(intentPrivacy);
            }
        });
    }
    public void loadThanks(){
        try {
            InputStream inputStream = getAssets().open("makasih_nay.txt");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            tvThanks.setText(new String(buffer));
        }
        catch (IOException e){
            return;
        }
    }
}
