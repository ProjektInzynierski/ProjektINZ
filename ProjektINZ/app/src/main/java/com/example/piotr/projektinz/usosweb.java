package com.example.piotr.projektinz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class usosweb extends AppCompatActivity {

    public WebView webview;
    public ProgressBar progressbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usosweb);
        webview = findViewById(R.id.webview);
        progressbar = findViewById(R.id.progressbar);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl("https://usosweb.pcz.pl/kontroler.php?_action=actionx:news/default()");
        webview.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                progressbar.setVisibility(View.GONE);
            }
        });
    }
}
