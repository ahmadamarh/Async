package rubi.ex3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.SystemClock;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MyAsync extends AsyncTask<Activity, Void, Long>{
    private Activity mainAct;
    @Override
    protected Long doInBackground(Activity... activity) {
        mainAct=activity[0];
        return SystemClock.elapsedRealtime();
    }
    @Override
    protected void onPostExecute(Long startTime) {
        long time=SystemClock.elapsedRealtime() - (startTime);
        Intent intent = new Intent(mainAct, AsyncAndHandlerActivity.class);
        String message ="The Time It Took For Async: "+String.valueOf(time);
        intent.putExtra(EXTRA_MESSAGE, message);
        intent.putExtra("msg2",Color.RED);
        mainAct.startActivity(intent);
    }

}
