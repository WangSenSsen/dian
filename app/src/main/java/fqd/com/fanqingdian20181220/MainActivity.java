package fqd.com.fanqingdian20181220;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView image;
    private TextView text;
    public int a=5;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 100) {
                a--;
                if (a==0) {
                    //跳转页面
                    Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                    startActivity(intent);
                }else{
                    //设置倒计时时间
                    text.setText(a+"秒");
                    handler.sendEmptyMessageDelayed(100,1000);
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.main_text);

        text.setText("5秒");
        //调用handler方法
        handler.sendEmptyMessageDelayed(100,1000);
    }
}
