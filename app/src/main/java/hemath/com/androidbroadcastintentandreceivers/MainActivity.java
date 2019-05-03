package hemath.com.androidbroadcastintentandreceivers;

import android.content.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button cast;
    IntentReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cast = findViewById(R.id.cast);
        cast.setOnClickListener(this);

        receiver = new IntentReceiver();
    }

    @Override
    public void onClick(View v) {
        broadcastIntent();
    }

    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter filter = new IntentFilter();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");


        registerReceiver(receiver, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(receiver);

    }

    public void broadcastIntent() {
        Intent intent = new Intent();
        intent.setAction("hemath.com.NET_RES");
        intent.setComponent(new ComponentName(getPackageName(),"hemath.com.androidbroadcastintentandreceivers.IntentReceiver"));
        getApplicationContext().sendBroadcast(intent);
    }
}
