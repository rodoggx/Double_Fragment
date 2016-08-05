package com.example.simpledoublefragment;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements LeftFragment.CallbackComponent {

    private static final String LEFT_FRAGMENT_TAG = "LEFT_FRAGMENT";
    private static final String RIGHT_FRAGMENT_TAG = "RIGHT_FRAGMENT";

    private static final String TAG = "MainActivityTAG_";

    private LeftFragment mLeftFragment;
    private RightFragment mRightFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //   setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);



        mLeftFragment = new LeftFragment();
        mRightFragment = new RightFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.a_main_left, mLeftFragment, LEFT_FRAGMENT_TAG)
                .add(R.id.a_main_right, mRightFragment, RIGHT_FRAGMENT_TAG)
                .add(R.id.a_main_right, new NamesFragment())
                .commit();

    }


    @Override
    public void buttonClicked(String name) {
        Log.d(TAG, "buttonClicked: " + name);
        if (mRightFragment != null && mRightFragment.isAdded()) {
            mRightFragment.loadImage(name);
        }
    }
    public void doMagic(View view) {
        String url = "http://www.mocky.io/v2/57a01bec0f0000c10d0f650f";

        OkHttpClient client = new OkHttpClient();
        Request request = new  Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            Log.d(TAG, "doMagic: " + response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
