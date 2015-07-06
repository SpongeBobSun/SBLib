package sblib.bobsun.sblib.views;

import android.app.Activity;

import java.lang.reflect.Field;

import sblib.bobsun.sblib.views.annotations.InjectView;
import sblib.bobsun.sblib.views.processor.InjectViewProcessor;

/**
 * Created by bobsun on 15-7-6.
 */
public class Injection {

    public Injection(Activity activity){
        processInjectView(activity);
    }

    private void processInjectView(Object object){
        InjectView injectViewAnnotation;
        for (Field field : object.getClass().getDeclaredFields()){
            injectViewAnnotation = field.getAnnotation(InjectView.class);
            if (injectViewAnnotation != null){
                InjectViewProcessor.process(field,object.getClass(),object,injectViewAnnotation.value());
            }
        }
    }


    private void processInjectListener(Class cls){

    }
}
