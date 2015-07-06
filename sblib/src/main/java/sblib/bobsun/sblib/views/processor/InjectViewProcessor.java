package sblib.bobsun.sblib.views.processor;

import android.app.Activity;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by bobsun on 15-7-6.
 */
public class InjectViewProcessor {

    public static void process(Field view,Class activityClass, Object activity, int resId){
        try {
            view.set(activity,
                    activityClass.getMethod("findViewById",int.class).invoke(activity,resId)
            );
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
