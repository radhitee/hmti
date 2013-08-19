package com.example.android.home.test;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
@SuppressLint("SetJavaScriptEnabled")
public class MainActivity extends Activity {
	final Activity activity = this;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().requestFeature(Window.FEATURE_PROGRESS);
		setContentView(R.layout.main);
		WebView web = (WebView) findViewById(R.id.webview);
		web.getSettings().setJavaScriptEnabled(true);
		web.setWebChromeClient(new WebChromeClient() {
			@Override
			public void onProgressChanged(WebView view, int progress) {
				activity.setTitle("Loading Coy.....");
				activity.setProgress(progress * 100);
				if (progress == 100) {
					activity.setTitle(R.string.app_name);
				}

			}

		});
		web.setWebViewClient(new WebViewClient() {

			@Override
			public void onReceivedError(WebView view, int errorCode,
					String description, String failingUrl) {
				super.onReceivedError(view, errorCode, description, failingUrl);
			}

			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}
		});
		web.loadUrl("www.hmtibansal.org");
	}

}
