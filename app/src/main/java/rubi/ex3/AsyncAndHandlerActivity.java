package rubi.ex3;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.style.BackgroundColorSpan;
import android.widget.EditText;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class AsyncAndHandlerActivity extends AppCompatActivity {
    String EXTRA_MESSAGE_2="msg2";
    EditText timeText;
    int new_background;
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.async_and_handler_view);
        new_background=0;
        timeText=findViewById(R.id.editText);
        String newString;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString(EXTRA_MESSAGE);
                new_background=extras.getInt(EXTRA_MESSAGE_2);
            }
        } else {
            newString= (String) savedInstanceState.getSerializable(EXTRA_MESSAGE);
        }
        ConstraintLayout bgElement = (ConstraintLayout) findViewById(R.id.my_constraint);
        bgElement.setBackgroundColor(new_background);
        timeText.setText(newString);
    }
}
