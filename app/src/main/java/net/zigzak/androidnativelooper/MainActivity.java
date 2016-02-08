package net.zigzak.androidnativelooper;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.loadLibrary("mylooper");

        final Handler[] handler = new Handler[1];

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();

                handler[0] = new Handler() {
                    public void handleMessage(Message message) {
                        Log.d("NativeLooper", "What: " + message.what);
                    }
                };

                Looper.loop();
            }
        });

        thread1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //handler[0].sendEmptyMessage(1122);
        sendMyMessage(handler[0]);
    }

    protected native void sendMyMessage(Handler handler) ;
}