package com.campusapp.cuet;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import agency.tango.materialintro.R;
import im.delight.android.webview.AdvancedWebView;
import pl.droidsonroids.gif.GifImageView;

//See CalendarWebView Class to Know How These Classes Work Altogether
public class PhotographyWebView extends Activity implements AdvancedWebView.Listener {

    private AdvancedWebView mWebView;
    GifImageView mCube;
    private Toast mToast;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web);

        mCube=(GifImageView)findViewById(R.id.gifCube);

        mWebView = (AdvancedWebView) findViewById(R.id.webview);
        mWebView.setListener(this, this);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("https://cuetphotography.000webhostapp.com/");

        // ...
    }

    @SuppressLint("NewApi")
    @Override
    protected void onResume() {
        super.onResume();
        mWebView.onResume();
        // ...
    }

    @SuppressLint("NewApi")
    @Override
    protected void onPause() {
        mWebView.onPause();
        // ...
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        mWebView.onDestroy();
        // ...
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        mWebView.onActivityResult(requestCode, resultCode, intent);
        // ...
    }

    @Override
    public void onBackPressed() {
        if (!mWebView.onBackPressed()) { return; }
        // ...
        super.onBackPressed();
    }

    @Override
    public void onPageStarted(String url, Bitmap favicon) {

        mCube.setVisibility(View.VISIBLE);

        if(mToast!=null){
            mToast.cancel();
        }

        mToast.makeText(this, "Please Wait.It Will Take Some Seconds.", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onPageFinished(String url) {
        mCube.setVisibility(View.GONE);
    }

    @Override
    public void onPageError(int errorCode, String description, String failingUrl) {

        mCube.setVisibility(View.GONE);
    }

    @Override
    public void onDownloadRequested(String url, String suggestedFilename, String mimeType, long contentLength, String contentDisposition, String userAgent) { }

    @Override
    public void onExternalPageRequest(String url) { }

}