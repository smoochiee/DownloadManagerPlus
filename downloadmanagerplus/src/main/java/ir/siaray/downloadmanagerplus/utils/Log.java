package ir.siaray.downloadmanagerplus.utils;

import java.lang.reflect.Field;

/**
 * Created by SIARAY on 15/12/2016.
 */

public class Log {
private static String TAG="DownloadManagerPlus";
    public static <T> void i(T msg) {
        android.util.Log.i(TAG, "" + msg);
    }

    public static <T> void print(T msg) {
        android.util.Log.i(TAG, "" + msg);
    }

    public static String printItems(Object obj) {
        Log.i("*** " + obj.getClass().getSimpleName() + " Values ***");
        String result = "";
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            String name = field.getName();
            Object value = null;
            try {
                value = field.get(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            Log.i(name + ": " + value);
            result = result + name + ": " + value + "\n";
        }
        if (result.isEmpty())
            return null;
        else
            return result;
    }
}
