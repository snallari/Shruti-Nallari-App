package com.example.shrutinallari.webapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends Activity {

    private WebView w1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        super.onCreate(savedInstanceState);
        setProgressBarIndeterminate(true);
        setContentView(R.layout.activity_main);
        w1 = (WebView) findViewById(R.id.weburl);
        w1.setWebViewClient(new MyBrowser());
        String url = "http://shrutinallari.com";
        w1.getSettings().setLoadsImagesAutomatically(true);
        w1.getSettings().setJavaScriptEnabled(true);
        w1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        w1.loadUrl(url);
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (view != null) {
                setProgressBarIndeterminate(false);
                view.loadUrl(url);
            }
            return true;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && w1.canGoBack()) {
            w1.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

};
