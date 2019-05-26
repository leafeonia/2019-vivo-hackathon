package advertisingspaceforrent.com.myapplication.util;

import android.content.Context;
import android.widget.Toast;

/**
 * @Author hxw
 * @Date 2019-5-23
 */
public class ToastUtil {

    /**
     * 显示不带context名的Toast
     * @param context
     * @param msg
     * @param dur
     */
    public static void showToast(Context context, String msg, Integer dur) {
        Toast toast = Toast.makeText(context,msg,dur);
        toast.setText(msg);
        toast.show();
    }

}
