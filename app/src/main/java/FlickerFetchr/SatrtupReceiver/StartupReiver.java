package FlickerFetchr.SatrtupReceiver;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.util.Log;

/**
 * Created by Icarus on 9/13/2014.
 */
public class StartupReiver extends BoradcaseReiceiver{
    private static final String TAG = "StartupReciver";

    @Override
    public void onRecivieve(Context context, Intent intent) {
        Log.i(Tag, "Recieved broadcast intent:" + intent.getAction());
    }
}
