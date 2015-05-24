package sblib.bobsun.sblib.util;

import android.content.Context;
import android.os.Vibrator;

/**
 * Created by bobsun on 15-5-24.
 */
public class VibrateUtil {
    private static VibrateUtil staticInstance;
    private Context context;
    private Vibrator vibrator;
    private VibrateUtil(Context context){
        this.context = context;
        vibrator = (Vibrator) this.context.getSystemService(Context.VIBRATOR_SERVICE);
    }

    /**
     * Get static Instance. This utility is designed as singlton, so you can access it from anywhere.
     * @param context
     * Application context
     * @return
     * Static instance.
     */
    public static VibrateUtil getStaticInstance(Context context){
        if(staticInstance == null)
            staticInstance = new VibrateUtil(context);
        return staticInstance;
    }

    /**
     * Make device vibrate for a specific duration.
     * @param millSeconds
     * Vibrate duration.
     */
    public void vibrate(long millSeconds){
        vibrator.vibrate(millSeconds);
    }
}
