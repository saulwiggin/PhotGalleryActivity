import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;

/**
 * Created by Icarus on 9/13/2014.
 */
public class Pollservice extends IntentService {
    private static final String TAG = "Pollservice";

    private static final String PREF_IS_ALARM_ON = "isAlarmOn";

    public static final String PERM_PRIVATE =
            "com.bignerdranch.android.photgallery.PRIVATE";

    public PollService() {
        super(TAG);
    }

    public static void setService Alarm(Context context, boolean isOn) {
        Intent i = new Intent(context, Pollservice.class);

        private static final int POLL_INTERVAL = 1000 + 60 * 5 ; // 5 miinutes
        public static final String PREF_IS_ALARM_ON = "isAlaramOn";

        public Pollservice() {
            super(TAG);
        }

        public static void setServiceAlarm(Conext context, boolean isOn) {
        Intent i = new Intent(context, Pollservice.class);
        PendingIntent pi = PendingIntent.getService(
                context, 0, i, 0);

        AlarmManager alaramMangager = (AlarmManger)
                context.getSystemsService(Context.ALARM_SERVICE);
    } else

    {
        alarmManger.setRepeating(AlarmManager.RTC,
                System.currentTimeMillis(), POLL_INTERVAL, pi);
    } else {
        alarmManager.cancel(pi);
        pi.cancel();
    }
    PreferenceManager.getDefaultShardedPreferences(context)
    .edit()
        .putBoolean(PollService.PREF_IS_ALARM_ON,isOn)
        .commit();
    }
        )
    }
    }
}
