package com.prozekt.companion;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

public class OTP extends AppCompatActivity {

    private String host = "https://beproject.tk/otp?token=";
    SharedPreferences settings;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        setTitle("OTP Screen");
        settings = getSharedPreferences("ACCDETAILS", 0);
        WebView webView = findViewById(R.id.WebViewOtp);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setLayerType(View.LAYER_TYPE_HARDWARE,null);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(host+settings.getString("JWT",""));

        ImageView imageView = (ImageView) findViewById(R.id.successCheck);
        Drawable drawable = imageView.getDrawable();
        if(drawable instanceof Animatable){
            ((Animatable)drawable).start();
        }
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(false);
        finish();
        finishAndRemoveTask ();
    }
}
