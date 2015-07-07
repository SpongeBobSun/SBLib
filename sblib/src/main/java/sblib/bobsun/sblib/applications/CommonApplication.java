package sblib.bobsun.sblib.applications;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

/**
 * Created by bobsun on 15-7-7.
 */
public class CommonApplication extends Application {
    private static Context mContext;
    private static Activity mainActivity;

    public static Context getContext() {
        return mContext;
    }

    public static void setContext(Context context) {
        mContext = context;
    }

    public static Activity getMainActivity() {
        return mainActivity;
    }

    public static void setMainActivity(Activity activity) {
        mainActivity = activity;
    }
}
