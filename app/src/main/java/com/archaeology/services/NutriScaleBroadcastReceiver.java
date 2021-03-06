// Communicate with scale
// @author: msenol86, ygowda
package com.archaeology.services;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import static com.archaeology.util.StateStatic.MESSAGE_STATUS_CHANGE;
public class NutriScaleBroadcastReceiver extends BroadcastReceiver
{
    final Handler M_HANDLER;
    /**
     * Constructor
     * @param aHandler - event handler
     */
    public NutriScaleBroadcastReceiver(Handler aHandler)
    {
        M_HANDLER = aHandler;
    }

    /**
     * Connection received
     * @param context - calling context
     * @param intent - intent to launch
     */
    @Override
    public void onReceive(Context context, Intent intent)
    {
        String action = intent.getAction();
        // When discovery finds a device
        if (BluetoothDevice.ACTION_ACL_CONNECTED.equals(action))
        {
            M_HANDLER.obtainMessage(MESSAGE_STATUS_CHANGE, "Device Connected").sendToTarget();
        }
        else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action))
        {
            M_HANDLER.obtainMessage(MESSAGE_STATUS_CHANGE, "Discovery Finished").sendToTarget();
        }
        else if (BluetoothDevice.ACTION_ACL_DISCONNECT_REQUESTED.equals(action))
        {
            M_HANDLER.obtainMessage(MESSAGE_STATUS_CHANGE,"Device About To Disconnect").sendToTarget();
        }
        else if (BluetoothDevice.ACTION_ACL_DISCONNECTED.equals(action))
        {
            M_HANDLER.obtainMessage(MESSAGE_STATUS_CHANGE, "Device Disconnected").sendToTarget();
        }
    }
}