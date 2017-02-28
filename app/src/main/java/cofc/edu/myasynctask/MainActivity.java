package cofc.edu.myasynctask;

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
        final long RANGE = 10000000;

        long guess = 0;
        Random rand = new Random();

        while (guess != PASSWORD) {
            guess = Math.abs(rand.nextLong() % RANGE);
        }
        displayProgress("Done!!");
        displayAnswer(guess);

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
}
