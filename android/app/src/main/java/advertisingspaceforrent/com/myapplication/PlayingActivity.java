package advertisingspaceforrent.com.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);
        Button buttona = (Button) findViewById(R.id.ButtonA);
        Button buttonb = (Button) findViewById(R.id.ButtonB);
        Button buttonc = (Button) findViewById(R.id.ButtonC);
        Button buttond = (Button) findViewById(R.id.ButtonD);
        buttona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNormalDialog();
            }
        });
        buttonb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNormalDialog();
            }
        });
        buttonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNormalDialog();
            }
        });
        buttond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNormalDialog();
            }
        });
    }

    private void showNormalDialog(){
        /* @setIcon 设置对话框图标
         * @setTitle 设置对话框标题
         * @setMessage 设置对话框消息提示
         * setXXX方法返回Dialog对象，因此可以链式设置属性
         */
        final AlertDialog.Builder normalDialog = new AlertDialog.Builder(PlayingActivity.this);
        normalDialog.setIcon(R.drawable.check);
        normalDialog.setTitle("Congratulations！");
        normalDialog.setMessage("You got the correct answer\nNext Question?");
        normalDialog.setPositiveButton("Next",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                    }
                });
        normalDialog.setNegativeButton("Close",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                    }
                });
        // 显示
        normalDialog.show();
    }
}
