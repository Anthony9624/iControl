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
        //实例化WebView对象  
        webview = new WebView(this);  
        //设置WebView属性，能够执行Javascript脚本  
        webview.getSettings().setJavaScriptEnabled(true);  
        //加载需要显示的网页  
        webview.loadUrl("http://m.weather.com.cn/d/town/index?lat=41.679375&lon=123.401009");  
        //设置Web视图  
        setContentView(webview);  
    }  
      
   
} 
