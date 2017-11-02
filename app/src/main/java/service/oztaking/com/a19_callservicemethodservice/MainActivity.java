package service.oztaking.com.a19_callservicemethodservice;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt1 = (Button) findViewById(R.id.bt1);
        bt1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        BeCalledMethodService beCalledMethodService = new BeCalledMethodService();
        beCalledMethodService.BeCalledMethod();

        Intent intent = new Intent(this, BeCalledMethodService.class);
        startService(intent);
    }
}
