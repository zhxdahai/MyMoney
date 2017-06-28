package feicui.edu.mymoney;

import android.app.Application;

import com.fuqianla.paysdk.FuQianLa;

/**
 * Created by Administrator on 2017/6/22.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FuQianLa.getInstance().init(getApplicationContext());
    }
}
