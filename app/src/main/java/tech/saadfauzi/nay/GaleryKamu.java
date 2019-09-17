package tech.saadfauzi.nay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class GaleryKamu extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {
    private CircleImageView close;
    private SliderLayout sliderShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galery_kamu);
        close = findViewById(R.id.ci_close_galery);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        sliderShow = findViewById(R.id.slider);
//        //-- HashMap image from web
//        HashMap <String, String> url_maps = new HashMap<String, String>();
//        url_maps.put("Bengong", "https://lh3.googleusercontent.com/rQPEV7eJZZNU_1clOKBnHIzZZMaD_rgKebi3OJEGVH6oURVodWnVrtXMMhidN5JvuJg=h310");
//        url_maps.put("Melongo", "https://i0.wp.com/www.amazine.co/wp-content/uploads/2013/12/Kucing_1.jpg");
//        url_maps.put("Apaaa", "http://islamidia.com/wp-content/uploads/2016/07/Kucing-dan-Kedudukannya-Dalam-Pandangan-Islam.jpg");
//        -- HashMap image from drawable
        HashMap<String,Integer> file_maps = new HashMap<String,Integer>();
        file_maps.put("Senyummu",R.drawable.nay01);
        file_maps.put("Nyanyi Lagu Rindu",R.drawable.nay02);
        file_maps.put("Tiurlah Nay",R.drawable.nay03);
        file_maps.put("Merindumu",R.drawable.nay05);
        file_maps.put("Terlalu Manis Untuk Dilupakan",R.drawable.nay06);
        file_maps.put("Tidru Again",R.drawable.nay07);
        file_maps.put("Kamu", R.drawable.nay08);
        file_maps.put("Dan Aku Masih Inget Sih Gimana Kamu Waktu Kepedesan", R.drawable.nay09);
        //-- looping image stored
        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);

            sliderShow.addSlider(textSliderView);
        }

        sliderShow.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderShow.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderShow.setCustomAnimation(new DescriptionAnimation());
        sliderShow.setDuration(3000);
        sliderShow.addOnPageChangeListener(this);
    }
    @Override
    protected void onStop() {
        sliderShow.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this, slider.getBundle().get("extra") + "",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Log.e("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
//    private void setupSlider() {
//        sliderView.setDurationScroll(800);
//        List<Fragment> fragments = new ArrayList<>();
//        fragments.add(FragmentSlider.newInstance("https://firebasestorage.googleapis.com/v0/b/fir-realtimedatabase-9549b.appspot.com/o/nay02.jpg"));
//        fragments.add(FragmentSlider.newInstance("https://image.tmdb.org/t/p/w250_and_h281_bestv2/rXBB8F6XpHAwci2dihBCcixIHrK.jpg"));
//        fragments.add(FragmentSlider.newInstance("https://image.tmdb.org/t/p/w250_and_h141_bestv2/biN2sqExViEh8IYSJrXlNKjpjxx.jpg"));
//        fragments.add(FragmentSlider.newInstance("https://image.tmdb.org/t/p/w250_and_h141_bestv2/o9OKe3M06QMLOzTl3l6GStYtnE9.jpg"));
//
//        mAdapter = new SliderPagerAdapter(getSupportFragmentManager(), fragments);
//        sliderView.setAdapter(mAdapter);
//        mIndicator = new SliderIndicator(this, mLinearLayout, sliderView, R.drawable.indicator_circle);
//        mIndicator.setPageCount(fragments.size());
//        mIndicator.show();
//    }
}
