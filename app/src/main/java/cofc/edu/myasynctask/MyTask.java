package cofc.edu.myasynctask;

import android.os.AsyncTask;

/**
 * Created by kbriggs on 2/27/17.
 */

public class MyTask {

    public void longTask () {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
