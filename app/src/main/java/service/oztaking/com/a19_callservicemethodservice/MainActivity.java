package service.oztaking.com.a19_callservicemethodservice;

import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private MyServiceConnection mycon;
    private IService myService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt1 = (Button) findViewById(R.id.bt1);
        bt1.setOnClickListener(this);

        Intent intent = new Intent(this, BeCalledMethodService.class);
        mycon = new MyServiceConnection();
        bindService(intent, mycon,BIND_AUTO_CREATE);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(mycon);
    }

    @Override
    public void onClick(View v) {
//        BeCalledMethodService beCalledMethodService = new BeCalledMethodService();

        myService.BeCalledMethod();
    }

    //当服务连接成功后调用
    public class MyServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //在连接的时候取到中间人对象
           myService = (IService) service;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }
}
