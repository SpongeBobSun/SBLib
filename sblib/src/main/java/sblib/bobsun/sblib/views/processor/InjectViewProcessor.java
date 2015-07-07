package sblib.bobsun.sblib.views.processor;

import android.app.Activity;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by bobsun on 15-7-6.
 */
public class InjectViewProcessor {

    public static void process(Field view,Object variable, int resId){
        try {
            view.set(variable,
                    variable.getClass().getMethod("findViewById",int.class).invoke(variable,resId)
            );
        } catch (IllegalAccessException e) {
            Log.e("SBLib injection","Please declare your variable to public");
        } catch (InvocationTargetException e) {
//            e.printStackTrace();
        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
        }
    }

    public static void process(Field viewFiled, Object variable, Object parent, int resId){
        try {
            viewFiled.set(variable,
                    parent.getClass().getMethod("findViewById",int.class).invoke(parent,resId));
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
