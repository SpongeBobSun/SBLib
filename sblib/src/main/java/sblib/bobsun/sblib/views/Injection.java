package sblib.bobsun.sblib.views;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import sblib.bobsun.sblib.views.annotations.InjectClickListener;
import sblib.bobsun.sblib.views.annotations.InjectView;
import sblib.bobsun.sblib.views.processor.InjectClickListenerProcessor;
import sblib.bobsun.sblib.views.processor.InjectViewProcessor;

/**
 * Created by bobsun on 15-7-6.
 */
public class Injection {

    /**
     * Initialize function with view declaration object.
     * When view is declared and contained in the same object, use this initial function.
     * @param object    <b>The parameter must be an instance of below: Activity, View, Fragment or ViewGroup</b>
     */
    public static void init(Object object){
        process(object,null);
    }
    public static void init(Object object, View container){
        process(object,container);
    }

    private static void process(Object object,Object container){
        Annotation injectViewAnnotation;
        for (Field field : object.getClass().getDeclaredFields()){
            injectViewAnnotation = field.getAnnotation(InjectView.class);
            if (injectViewAnnotation != null){
                if (container == null) {
                    InjectViewProcessor.process(field, object, ((InjectView) injectViewAnnotation).value());
                } else {
                    InjectViewProcessor.process(field, object, container, ((InjectView) injectViewAnnotation).value());
                }
            }
        }
        Annotation injectClickListenerAnnotation;
        for (Method method : object.getClass().getDeclaredMethods()){
            injectClickListenerAnnotation = method.getAnnotation(InjectClickListener.class);
            if (injectClickListenerAnnotation != null){
                if (!checkClickMethodParams(method))
                    throw new IllegalArgumentException("Only support one and only one parameters which type is View");
                if (container == null) {
                    InjectClickListenerProcessor.process(object, ((InjectClickListener) injectClickListenerAnnotation).value(), method);
                } else {
                    InjectClickListenerProcessor.process(object, container, ((InjectClickListener) injectClickListenerAnnotation).value(), method);
                }
            }
        }
    }

    private static boolean checkClickMethodParams(Method method){
        Class[] paramTypes = method.getParameterTypes();
        if (paramTypes.length > 1)
            return false;
        if (paramTypes[0] != View.class){
            return false;
        }
        return true;
    }

}
