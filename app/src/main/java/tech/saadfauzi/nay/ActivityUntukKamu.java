package tech.saadfauzi.nay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import de.hdodenhof.circleimageview.CircleImageView;

public class ActivityUntukKamu extends AppCompatActivity {
    private CircleImageView close;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_untuk_kamu);
        close = findViewById(R.id.ci_close_kamu);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        textView = findViewById(R.id.tv_for_u);
        loadFromAsset();
    }

    public void loadFromAsset(){
        try {
            InputStream inputStream = getAssets().open("untuk-kamu-nay.txt");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            textView.setText(new String(buffer));
        }
        catch (IOException e){
            return;
        }
    }
}
