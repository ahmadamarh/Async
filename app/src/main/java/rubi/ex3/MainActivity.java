package rubi.ex3;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Activity mainContext;
    Button async;
    Button handler_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainContext=this;
        async=findViewById(R.id.sync_button);
        handler_button=findViewById(R.id.handler);
        async.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            MyAsync sync=new MyAsync();
            sync.execute(mainContext);
            }
        });
        handler_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyHandlerThread my_handler_thread=new MyHandlerThread("myHandler",mainContext);
                my_handler_thread.start();
            }
        });
    }
}
