package com.example.shrutinallari.webapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
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

import com.squareup.picasso.Picasso;

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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        if (w1.canGoBack() == true) {
            menu.findItem(R.id.action_back).setVisible(true);
            return true;
        } else if (w1.canGoForward() == true) {
            menu.findItem(R.id.action_frwd).setVisible(true);
            return true;
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_back:
                if (w1.canGoBack() == true) {
                    w1.goBack();
                    return true;
                }
            case R.id.action_frwd:
                if (w1.canGoForward() == true) {
                    w1.goForward();
                    return true;
                }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

};