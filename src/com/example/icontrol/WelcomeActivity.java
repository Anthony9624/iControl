package com.example.icontrol;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class WelcomeActivity extends Activity {

    // 声明控件对象
    private TextView textView;
    private int count = 5;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 去除标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome);
        // 初始化控件对象
        textView = (TextView) findViewById(R.id.textView);
        animation = AnimationUtils.loadAnimation(this, R.anim.animation_text);
        //textView.startAnimation(animation);
        handler.sendEmptyMessageDelayed(0, 1000);

    }

    private int getCount() {
        count--;
        if (count == 0) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        return count;
    }

    private Handler handler = new Handler() {
    	
        public void handleMessage(android.os.Message msg) {
            if (msg.what == 0) {
                textView.setText(getCount()+"");
                handler.sendEmptyMessageDelayed(0, 1000);
                animation.reset();
                textView.startAnimation(animation);
            }

        };

    };

}