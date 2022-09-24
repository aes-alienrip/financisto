package ru.orangesoftware.financisto.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.webkit.WebView;

import ru.orangesoftware.financisto.utils.MyPreferences;

/**
 * Created by IntelliJ IDEA.
 * User: Denis Solonenko
 * Date: 3/24/11 10:22 PM
 */
public class WebViewActivity extends Activity {

    public static final String FILENAME = "filename";
    public static final String URL = "url";

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(MyPreferences.switchLocale(base));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WebView webView = new WebView(this);
        setContentView(webView);

        String url = getIntent().getStringExtra(URL);
        String fileName = getIntent().getStringExtra(FILENAME);
        if (fileName != null) {
            url = "file:///android_asset/" + fileName + ".htm";

        }
        webView.loadUrl(url);
    }

}