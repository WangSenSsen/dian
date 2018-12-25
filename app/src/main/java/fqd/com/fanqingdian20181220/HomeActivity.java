package fqd.com.fanqingdian20181220;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class HomeActivity extends FragmentActivity {

    private FragmentManager manager;
    private Frag1 frag1;
    private Frag2 frag2;
    private Frag3 frag3;
    private RadioGroup radio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        radio = findViewById(R.id.radio);
        //获取事物管理器
        manager = getSupportFragmentManager();
        //开启事物
        FragmentTransaction transaction = manager.beginTransaction();
        frag1 = new Frag1();
        frag2 = new Frag2();
        frag3 = new Frag3();
        transaction.add(R.id.home_fram,frag1);
        transaction.add(R.id.home_fram,frag2);
        transaction.add(R.id.home_fram,frag3);
        //设置显示与隐藏
        transaction.show(frag1).hide(frag2).hide(frag3);
        //提交事物
        transaction.commit();
        //初始化选中小按钮
        radio.check(radio.getChildAt(0).getId());
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction1 = manager.beginTransaction();
                switch (checkedId){
                    case R.id.radio1:
                        transaction1.show(frag1).hide(frag2).hide(frag3);
                        break;
                    case R.id.radio2:
                        transaction1.show(frag2).hide(frag1).hide(frag3);
                        break;
                    case R.id.radio3:
                        transaction1.show(frag3).hide(frag2).hide(frag1);
                        break;

                }
                transaction1.commit();
            }
        });

    }
}
