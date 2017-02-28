package cofc.edu.myasynctask;

import android.os.AsyncTask;

/**
 * Created by kbriggs on 2/27/17.
 */

public class MyTask extends AsyncTask<String, String, String> {
    @Override
    protected String doInBackground(String... params) {
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
