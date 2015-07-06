package sblib.bobsun.sblib.views;

import android.app.Activity;

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

    public static  void init(Activity activity){
        process(activity);
    }

    private static void process(Object object){
        Annotation injectViewAnnotation;
        for (Field field : object.getClass().getDeclaredFields()){
            injectViewAnnotation = field.getAnnotation(InjectView.class);
            if (injectViewAnnotation != null){
                InjectViewProcessor.process(field,object,((InjectView)injectViewAnnotation).value());
            }
        }
        Annotation injectClickListenerAnnotation;
        for (Method method : object.getClass().getDeclaredMethods()){
            injectClickListenerAnnotation = method.getAnnotation(InjectClickListener.class);
            if (injectClickListenerAnnotation != null){
                InjectClickListenerProcessor.process(object,((InjectClickListener) injectClickListenerAnnotation).value(),method);
            }
        }
    }

}
