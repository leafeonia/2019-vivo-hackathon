package advertisingspaceforrent.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainSignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sign_up);
    }

    //Used to show the help by triggering a toast
    public void showHelp(View view) {

        Toast toast_help = new Toast(getApplicationContext());
        toast_help.setGravity(Gravity.CENTER, 0, 0);
        toast_help.setDuration(Toast.LENGTH_LONG);
        LayoutInflater inflater = getLayoutInflater();
        //View appear = inflater.inflate(R.layout.toast_help, (ViewGroup) findViewById(R.id.linear));
        //toast_help.setView(appear);
        toast_help.show();

    }
}
