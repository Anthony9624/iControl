package com.example.icontrol;



import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
	
	 private ProgressDialog pdDialog=null;
	    //���ȼ���
	 int iCount  = 0;

    private Button bt2;
    private Button bt5;
    private Button bt3;
	private Button bt7;
	private Button bt4;
	private ToggleButton togglebutton; 
	private static final int msgKey1 = 1;
	private TextView mTime;
	
	//v.getBackground().setAlpha(100);
	    
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		togglebutton = (ToggleButton) findViewById(R.id.togglebutton);
		bt7 = (Button) findViewById(R.id.button7);
		
		bt2 = (Button) findViewById(R.id.button2);
		bt5 = (Button) findViewById(R.id.button5);
		bt4 = (Button) findViewById(R.id.button4);
		bt3 = (Button) findViewById(R.id.button3);
		mTime = (TextView) findViewById(R.id.mytime);
	    new TimeThread().start();
	    
		
		
		
		bt2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,WeatherActivity.class);
				startActivity(intent);
				
			}	
		});
		bt3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,datenoteActivity.class);
				startActivity(intent);
			}
		});
		bt4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
				startActivity(intent);
			}
		});
		
		bt5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = getPackageManager().getLaunchIntentForPackage("com.autonavi.minimap"); 
				startActivity(intent);
			}
		});
	
	
		togglebutton.setOnClickListener(new OnClickListener() {
			
			 public void onClick(View v) {          
	                // ����ť��һ�α����ʱ����Ӧ���¼�        
	                if (togglebutton.isChecked()) {              
	                    Toast.makeText(MainActivity.this, "����������", Toast.LENGTH_LONG).show();         
	                }   
	                // ����ť�ٴα����ʱ����Ӧ���¼�  
	                else {              
	                    Toast.makeText(MainActivity.this, "�����ѽ���", Toast.LENGTH_LONG).show();          
	                }      
	            }  
		});
		bt7.setOnClickListener(new OnClickListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			       iCount  = 0;
	                //����ProgressDialog����
	                pdDialog = new ProgressDialog(MainActivity.this);

	                //���ý�������񣬷��ΪԲ�Σ���ת��
	                pdDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

	                // ����ProgressDialog ����
	                pdDialog.setTitle("�����С���");

	                // ����ProgressDialog ��ʾ��Ϣ
	                pdDialog.setMessage("���Ժ󡭡�");

	                // ����ProgressDialog ����ͼ��
	                pdDialog.setIcon(R.drawable.qidong);

	                // ����ProgressDialog ����������
	                pdDialog.setProgress(100);

	                // ����ProgressDialog �Ľ������Ƿ���ȷ
	                pdDialog.setIndeterminate(false);

	                // ����ProgressDialog �Ƿ���԰��˻ذ���ȡ��
	                pdDialog.setCancelable(true);

	                // ����ProgressDialog ��һ��Button
	                pdDialog.setButton("ȡ��", new DialogInterface.OnClickListener() {
	                    public void onClick(DialogInterface dialog, int i)
	                    {
	                        //�����ȡ������ťȡ���Ի���
	                        dialog.cancel();
	                    }
	                });

	                // ��ProgressDialog��ʾ
	                pdDialog.show();

	                //�����߳�ʵ��
	                new Thread(){
	                    public void run(){
	                        try{
	                            while (iCount  <= 100) {
	                                // ���߳������ƽ��ȡ�
	                                pdDialog.setProgress(iCount ++);
	                                Thread.sleep(50);
	                            }
	                            pdDialog.cancel();
	                        }
	                        catch (InterruptedException e){
	                            pdDialog.cancel();
	                        }
	                    }

	                }.start();	
	                Toast.makeText(MainActivity.this, "������������", Toast.LENGTH_LONG).show();
			}
			
		});
		
	}
		public class TimeThread extends Thread {
			@Override
        	public void run () {
				do {
					try {
						Thread.sleep(1000);
						Message msg = new Message();
						msg.what = msgKey1;
						mHandler.sendMessage(msg);
					}
					catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while(true);
        }
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage (Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case msgKey1:
                    long sysTime = System.currentTimeMillis();
                    CharSequence sysTimeStr = DateFormat.format("hh:mm:ss", sysTime);
                    mTime.setText(sysTimeStr);
                    break;

                default:
                    break;
            }
        }
    };

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
