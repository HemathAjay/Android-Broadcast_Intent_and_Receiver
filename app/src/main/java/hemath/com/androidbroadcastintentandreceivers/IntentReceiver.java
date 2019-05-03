package hemath.com.androidbroadcastintentandreceivers;

import android.content.*;
import android.widget.*;

public class IntentReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context,Intent intent)
    {
        String action = intent.getAction();
        if (action.equals("hemath.com.NET_RES")) {
            Toast.makeText(context, "Explicit Broadcast was triggered", Toast.LENGTH_SHORT).show();
        }

        if (("android.net.conn.CONNECTIVITY_CHANGE").equals(action)) {
            Toast.makeText(context, "Implicit Broadcast was triggered using registerReceiver", Toast.LENGTH_SHORT).show();
        }
    }
}
