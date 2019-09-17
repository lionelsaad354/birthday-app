package tech.saadfauzi.nay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    LinearLayout cvUntukKamu, cvGalerymu, cvTentangKamu, cvThanks;
    private Animation rotatePic, rotatePicLeft;
    private CircleImageView circleImageView, circleName, circleAge;
    private static final int TIME_INTERVAL = 2000;
    private long mBackPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        circleImageView = findViewById(R.id.circle_pic);

        rotatePic = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_pic);
        rotatePicLeft = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_pic_left);

        cvGalerymu = findViewById(R.id.cv_galerymu);
        cvTentangKamu = findViewById(R.id.cv_tentangmu);
        cvThanks = findViewById(R.id.cv_thanks);
        cvUntukKamu = findViewById(R.id.cv_untuk_kamu);
        circleName = findViewById(R.id.circle_name);
        circleAge = findViewById(R.id.circle_age);

        TextView a = new TextView(getApplicationContext()); a.setText("Sa'adatil"); a.setBackgroundResource(android.R.drawable.btn_default_small);
        TextView b = new TextView(getApplicationContext()); b.setText("Ulya"); b.setBackgroundResource(android.R.drawable.btn_default_small);
        TextView c = new TextView(getApplicationContext()); c.setText("HBD"); c.setBackgroundResource(android.R.drawable.btn_default_small);
        TextView d = new TextView(getApplicationContext()); d.setText("Nailis"); d.setBackgroundResource(android.R.drawable.btn_default_small);
        LinearLayout.LayoutParams tvParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        a.setLayoutParams(tvParams);
        b.setLayoutParams(tvParams);
        c.setLayoutParams(tvParams);
        d.setLayoutParams(tvParams);

        SubActionButton.Builder subBuilder = new SubActionButton.Builder(getApplicationContext());

        FloatingActionMenu circleMenu = new FloatingActionMenu.Builder(getApplicationContext())
                .setStartAngle(90) // A whole circle!
                .setEndAngle(360)
                .setRadius(getResources().getDimensionPixelSize(R.dimen.radius_medium))
                .addSubActionView(a)
                .addSubActionView(b)
                .addSubActionView(c)
                .addSubActionView(d)
                .attachTo(circleName)
                .enableAnimations()
                .build();
    }

    @Override
    protected void onStart() {
        super.onStart();
        circleImageView.startAnimation(rotatePic);
        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                circleImageView.startAnimation(rotatePic);
            }
        });
        circleAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                circleAge.startAnimation(rotatePicLeft);
            }
        });
        cvGalerymu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GaleryKamu.class));
            }
        });
        cvUntukKamu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ActivityUntukKamu.class));
            }
        });
        cvTentangKamu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TentangKamu.class));
            }
        });
        cvThanks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Terimakasih.class));
            }
        });

    }

    @Override public void onBackPressed() {
        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
            super.onBackPressed();
            return;
        } else { Toast.makeText(getBaseContext(), "Tekan Lagi Untuk Keluar", Toast.LENGTH_SHORT).show();}
        mBackPressed = System.currentTimeMillis();
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
