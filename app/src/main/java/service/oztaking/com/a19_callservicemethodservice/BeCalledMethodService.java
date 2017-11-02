package service.oztaking.com.a19_callservicemethodservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Administrator on 2017-11-02.
 */

public class BeCalledMethodService extends Service {

    String TAG = new String("ANDROID-LOG");
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"onCreate方法被调用");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy方法被调用");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }
    //1.被调用的服务中的方法
    public class MyBinder extends Binder implements IService{

        @Override
        public void BeCalledMethod() {
            Toast.makeText(getApplicationContext(),"我是被调用服务中的方法",Toast.LENGTH_SHORT).show();
        }
    }

}
