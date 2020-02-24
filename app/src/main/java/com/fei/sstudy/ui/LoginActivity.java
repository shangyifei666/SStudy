package com.fei.sstudy.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.fei.sstudy.R;
import com.fei.sstudy.entity.Config;
import com.fei.sstudy.util.StatusBarUtils;

public class LoginActivity extends AppCompatActivity {
    private final String TAG = "LoginActivity";

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        StatusBarUtils.setWindowStatusBarColor(this,getResources().getColor(R.color.color_education_system));

        webView = findViewById(R.id.wv_login);

        initWebView();
    }

    private void initWebView(){
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setUseWideViewPort(true);//关键点
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setDisplayZoomControls(false);
        settings.setJavaScriptEnabled(true); // 设置支持javascript脚本
        settings.setDomStorageEnabled(true); // 设置适应Html5
        settings.setAllowFileAccess(true); // 允许访问文件
        settings.setBuiltInZoomControls(true); // 设置显示缩放按钮
        settings.setSupportZoom(true); // 支持缩放
        settings.setLoadWithOverviewMode(true);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);//清除缓存
        webView.clearCache(true);
        webView.clearHistory();
        webView.loadUrl(Config.LOGIN_URL);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Log.d(TAG,"url: " + request.getUrl());
                CookieManager cookieManager = CookieManager.getInstance();
                String cookie = cookieManager.getCookie(String.valueOf(request.getUrl()));
                Log.d(TAG,"cookie: "+cookie);
                saveCookie(cookie);
                LoginActivity.this.finish();
                return false;
            }
        });
    }

    private void saveCookie(String cookie){
        String jw;
        String JSESSIONID;

        int f = cookie.indexOf("=");
        int s = cookie.indexOf("=",f+1);
        int o = cookie.indexOf(";");
        jw = cookie.substring(f+1,o);
        JSESSIONID = cookie.substring(s+1);
        Log.d(TAG,"jw="+jw+" ,JSESSIONID="+JSESSIONID);

        SharedPreferences sharedPreferences= getSharedPreferences("SPcookie", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("jw",jw);
        editor.putString("JSESSIONID",JSESSIONID);
        editor.commit();
    }

    @Override
    protected void onPause() {
        super.onPause();
//        CookieManager.getInstance().removeAllCookie();
    }
}
