package com.manyou.ipchaxun.demo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.manyou.ipchaxun.IPInfo;
import com.manyou.ipchaxun.IpChaxunHelper;
import com.manyou.ipchaxun.listens.IpCallBackListens;

public class MainActivity extends AppCompatActivity {

    TextView mTvDisplay;
    IpChaxunHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvDisplay=(TextView)findViewById(R.id.tv_display);

        helper =new IpChaxunHelper(this, new IpCallBackListens() {
            @Override
            public void onSuccess(IPInfo info) {

                mTvDisplay.setText(info.toString());
            }

            @Override
            public void Faild(String errorType, String errorDetail) {
                Log.e("TAG","tree Faild:"+errorType);
                mTvDisplay.setText(errorDetail);

            }
        });

        helper.getIP();


        findViewById(R.id.tv_get_ip).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(helper!=null){
                    helper.getIP();
                }
            }
        });
    }


}
