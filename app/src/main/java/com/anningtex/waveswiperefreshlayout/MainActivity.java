package com.anningtex.waveswiperefreshlayout;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.anningtex.waveswiperefreshlayout.weight.WaveSwipeRefreshLayout;

/**
 * @author Administrator
 * desc:WaveSwipeRefreshLayout
 * source:https://github.com/recruit-lifestyle/WaveSwipeRefreshLayout
 */
public class MainActivity extends AppCompatActivity {
    private WaveSwipeRefreshLayout mWaveSwipe;
    private RecyclerView mRecyclerView;
    Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mWaveSwipe = findViewById(R.id.wave_swipe);
        mRecyclerView = findViewById(R.id.recyclerView);
        //设置小圆圈颜色
        mWaveSwipe.setColorSchemeColors(Color.WHITE, Color.YELLOW, Color.RED, Color.GREEN);
        //设置背景色
        mWaveSwipe.setWaveColor(Color.argb(255, 63, 81, 181));
        //设置刷新监听
        mWaveSwipe.setOnRefreshListener(() -> new Thread() {
            @Override
            public void run() {
                SystemClock.sleep(3000); //do something in background
                //stop refreshing
                mHandler.post(() -> {
                    mWaveSwipe.setRefreshing(false);//调用这个方法结束刷新小圆圈的显示
                });
            }
        }.start());
    }
}