package ru.orangesoftware.financisto.activity;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TabHost;

import ru.orangesoftware.financisto.R;
import ru.orangesoftware.financisto.utils.MyPreferences;
import ru.orangesoftware.financisto.utils.Utils;

public class AboutActivity extends TabActivity {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(MyPreferences.switchLocale(base));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Financisto (" + getAppVersion(this) + ")");

        addTabForFile("whatsnew", R.string.whats_new);
        addTabForFile("gpl-2.0-standalone", R.string.license);
        addTabForFile("about", R.string.about);
    }

    private void addTabForFile(String name, int titleId) {
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra(WebViewActivity.FILENAME, name);
        TabHost tabHost = getTabHost();
        tabHost.addTab(tabHost.newTabSpec(name)
                .setIndicator(getString(titleId), getResources().getDrawable(R.drawable.ic_tab_about))
                .setContent(intent));
    }

    public static String getAppVersion(Context context) {
        try {
            PackageInfo info = Utils.getPackageInfo(context);
            return "v. " + info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "";
        }
    }

}
