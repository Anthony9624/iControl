package com.example.icontrol;



import android.app.Activity;  
import android.os.Bundle;    
import android.view.Window;
import android.webkit.WebView;  
 
public class WeatherActivity extends Activity {  
    private WebView webview;  
    @Override 
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //ʵ����WebView����  
        webview = new WebView(this);  
        //����WebView���ԣ��ܹ�ִ��Javascript�ű�  
        webview.getSettings().setJavaScriptEnabled(true);  
        //������Ҫ��ʾ����ҳ  
        webview.loadUrl("http://m.weather.com.cn/d/town/index?lat=41.679375&lon=123.401009");  
        //����Web��ͼ  
        setContentView(webview);  
    }  
      
   
} 
