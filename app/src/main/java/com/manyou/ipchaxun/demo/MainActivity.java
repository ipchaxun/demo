package com.manyou.ipchaxun.demo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.manyou.ipchaxun.IPInfo;
import com.manyou.ipchaxun.IpChaxunHelper;
import com.manyou.ipchaxun.listens.IpCallBackListens;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==IpChaxunHelper.REQUEST_CODE_LOCATION_SETTINGS){
            if(helper!=null){
                helper.getIP();;
            }
        }

    }
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

                mTvDisplay.setText(infoToString(info));
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


    static String infoToString(IPInfo info){
            if(info.isOK){
                StringBuffer sb=new StringBuffer();
                sb.append(info.ip);
                sb.append(" ");
                sb.append(info.country);
                sb.append(" ");
                sb.append(info.province);
                sb.append(" ");
                sb.append(info.city);
                sb.append(" ");
                sb.append(info.netType);
                return sb.toString();
            }else{
                return "未知";
            }
    }
}
