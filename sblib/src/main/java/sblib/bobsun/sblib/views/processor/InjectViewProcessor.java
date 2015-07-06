package sblib.bobsun.sblib.views.processor;

import android.app.Activity;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by bobsun on 15-7-6.
 */
public class InjectViewProcessor {

    public static void process(Field view,Object activity, int resId){
        try {
            view.set(activity,
                    activity.getClass().getMethod("findViewById",int.class).invoke(activity,resId)
            );
        } catch (IllegalAccessException e) {
            Log.e("SBLib injection","Please declare your variable to public");
        } catch (InvocationTargetException e) {
//            e.printStackTrace();
        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
        }
    }
}
