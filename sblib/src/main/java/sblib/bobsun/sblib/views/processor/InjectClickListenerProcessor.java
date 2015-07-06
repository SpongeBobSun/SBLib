package sblib.bobsun.sblib.views.processor;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by bobsun on 15-7-6.
 */
public class InjectClickListenerProcessor {
    public static void process(final Object activity, int resId, final Method listener){
        try {
            View view = (View) activity.getClass().getMethod("findViewById",int.class).invoke(activity,resId);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        listener.invoke(activity,v);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
