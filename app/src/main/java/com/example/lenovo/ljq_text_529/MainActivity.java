package com.example.lenovo.ljq_text_529;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.lenovo.ljq_text_529.ui.mobile.MobileFragment;
import com.example.lenovo.ljq_text_529.ui.mobile.PothoFragment;

public class MainActivity extends AppCompatActivity {

    private FrameLayout mFrag;
    /**
     * 鍒楄〃
     */
    private RadioButton mBtn1;
    /**
     * 鍥剧墖
     */
    private RadioButton mBtn2;
    /**
     * 娓呴櫎缂撳瓨
     */
    private RadioButton mBtn3;
    private RadioGroup mRg;
    private FragmentManager fragmentManager;
    private MobileFragment mobileFragment;
    private PothoFragment pothoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        fragmentManager = getSupportFragmentManager();
        mobileFragment = new MobileFragment();
        pothoFragment = new PothoFragment();
        fragmentManager.beginTransaction().replace(R.id.frag,mobileFragment).commit();

        setListenter();

    }

    private void setListenter() {
        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.btn1:

                        fragmentManager.beginTransaction().replace(R.id.frag,mobileFragment).commit();
                        break;
                    case R.id.btn2:

                        fragmentManager.beginTransaction().replace(R.id.frag,pothoFragment).commit();
                        break;
                    case R.id.btn3:

                        //fragmentManager.beginTransaction().replace(R.id.frag,mobileFragment).commit();
                        break;
                }
            }
        });
    }

    private void initView() {
        mFrag = (FrameLayout) findViewById(R.id.frag);
        mBtn1 = (RadioButton) findViewById(R.id.btn1);
        mBtn2 = (RadioButton) findViewById(R.id.btn2);
        mBtn3 = (RadioButton) findViewById(R.id.btn3);
        mRg = (RadioGroup) findViewById(R.id.rg);
    }
}
