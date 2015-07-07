package sblib.bobsun.sblib.views.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by bobsun on 15-7-6.
 */

/**
 * Inject a view using resource id.
 * The view variable must be declared public.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectView {
    int value() default (-1);
}
