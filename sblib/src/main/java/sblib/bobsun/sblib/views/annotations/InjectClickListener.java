package sblib.bobsun.sblib.views.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by bobsun on 15-7-6.
 */

/**
 * Inject a OnClickListener using resource id.
 * The onclick processing method must be declared as public.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectClickListener {
    public int value() default (-1);
}
