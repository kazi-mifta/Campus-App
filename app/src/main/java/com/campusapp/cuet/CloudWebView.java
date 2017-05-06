package com.campusapp.cuet;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.widget.Toast;

import agency.tango.materialintro.R;
import im.delight.android.webview.AdvancedWebView;
import pl.droidsonroids.gif.GifImageView;

public class CloudWebView  extends Activity implements AdvancedWebView.Listener {

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
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.getSettings().setDisplayZoomControls(false);
        mWebView.setDesktopMode(false);
        mWebView.loadUrl("https://app.box.com/s/dnm4g0siszwi16xh6sijl6j1wt9c9k8d");//The Website Where The Cloud Resides.

        // ...
    }


    /*
        *The Following Methdos are Vital for WebView As it Can Do Things at The Moment When The Webpage starts Loading or
        * Finishes Loading. It Also Can Show Messages And Graphics At These Specific Moments.
     */
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

    //When The Link Is Clicked & the Page starts to Load It's Contents This Method Is Executed.
    @Override
    public void onPageStarted(String url, Bitmap favicon) {

        mCube.setVisibility(View.VISIBLE);
        if(mToast!=null){
            mToast.cancel();
        }

        mToast.makeText(this, "Please Wait.It Will Take Some Seconds.", Toast.LENGTH_SHORT).show();

    }

    //When Page Loads Finishes This Method Is Executed.
    @Override
    public void onPageFinished(String url) {
        mCube.setVisibility(View.GONE);
    }

    @Override
    public void onPageError(int errorCode, String description, String failingUrl) {

        mCube.setVisibility(View.GONE);
    }

    @Override
    public void onExternalPageRequest(String url) { }


    @Override
    public void onDownloadRequested(String url, String suggestedFilename, String mimeType, long contentLength, String contentDisposition, String userAgent) {
        // some file is available for download
        // either handle the download yourself or use the code below

        mWebView.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String url, String userAgent,
                                        String contentDisposition, String mimetype,
                                        long contentLength) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

    }

}
