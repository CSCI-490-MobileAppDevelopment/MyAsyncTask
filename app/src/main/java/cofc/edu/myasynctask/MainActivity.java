package cofc.edu.myasynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final long PASSWORD = 12345;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickStartTask(View v) {
        final long RANGE = 1000000;
        final long PUBLISH_RATE = 10;

        PasswordCheck checker = new PasswordCheck();
        checker.execute(RANGE, PUBLISH_RATE);

    }

    private void displayProgress(String progress) {
        TextView textView = (TextView) findViewById(R.id.status);
        textView.setText(progress);
    }

    private void displayAnswer(long ans) {
        String message = "The password is " + ans;

        TextView textView = (TextView) findViewById(R.id.answer);
        textView.setText(message);
    }

    private class PasswordCheck extends AsyncTask<Long, String, Long> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Long doInBackground(Long... params) {
            long range = params[0];
            long publishRate = params[1];

            long guess = 0;
            long count = 0;
            Random rand = new Random();

            while (guess != PASSWORD) {
                guess = Math.abs(rand.nextLong() % range);
                count++;

                if(count % publishRate == 0 ) {
                    publishProgress("Number of guesses: " + count, "  Last guess: " + guess);

                }
            }

            return guess;
        }

        @Override
        protected void onPostExecute(Long aLong) {
            super.onPostExecute(aLong);
            displayAnswer(aLong);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            String message = "";
            for(String str: values) {
                message += str + "," ;
            }
            displayProgress(message);
        }


    }
}
