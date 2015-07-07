package sblib.bobsun.sblib.util;

/**
 * Created by bobsun on 15-7-6.
 */
public class StringUtil {
    public static boolean isNullOrEmpty(String string){
        if(string == null)
            return true;
        if("".equalsIgnoreCase(string))
            return true;
        return false;
    }
}
