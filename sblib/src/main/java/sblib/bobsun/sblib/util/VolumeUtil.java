package sblib.bobsun.sblib.util;

import android.content.Context;
import android.media.AudioManager;

/**
 * Created by bobsun on 15-5-24.
 */
public class VolumeUtil {
    private static VolumeUtil staticInstance;
    private AudioManager audioManager;
    private VolumeUtil(Context context){
        audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
    }
    /**
     * Get static Instance. This utility is designed as singlton, so you can access it from anywhere.
     * @param context
     * Application context
     * @return
     * Static instance.
     */
    public static VolumeUtil getStaticInstance(Context context){
        if (staticInstance == null)
            staticInstance = new VolumeUtil(context);
        return staticInstance;
    }

    /**
     * Raise specific volume by default step.
     * @param flag
     * Specific volume to raise.
     * Flag value is defined in AudioManager.
     */
    public void raiseVolume(int flag){
        audioManager.adjustStreamVolume(flag,
                AudioManager.ADJUST_RAISE,
                0);
    }
    /**
     * Reduce specific volume by default step.
     * @param flag
     * Specific volume to raise.
     * Flag value is defined in AudioManager.
     */
    public void reduceVolume(int flag){
        audioManager.adjustStreamVolume(flag,
                AudioManager.ADJUST_LOWER,
                0);
    }
}
