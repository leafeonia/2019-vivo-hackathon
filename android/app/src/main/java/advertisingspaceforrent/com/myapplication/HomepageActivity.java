package advertisingspaceforrent.com.myapplication;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HomepageActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    TextView nav_header_nam, nav_header_emal;
    ImageView nav_header_imag;
    Button b1,b2,b3,b4,b5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        String nav_header_gender = "Male";
        View header = navigationView.getHeaderView(0);//Used to get a reference to navigation header
        Intent i = getIntent();
        nav_header_nam = (TextView) header.findViewById(R.id.nav_header_name);
        nav_header_emal = (TextView) header.findViewById(R.id.nav_header_email);
        nav_header_imag = (ImageView) header.findViewById(R.id.nav_header_image);
        nav_header_nam.setText(i.getStringExtra("username"));
        nav_header_emal.setText(i.getStringExtra("email"));
        if (nav_header_gender.equals("Male")) {
            nav_header_imag.setImageResource(R.drawable.man);
        } else {
            nav_header_imag.setImageResource(R.drawable.female);
        }
        b1 = (Button)findViewById(R.id.b1);
        b2 = (Button)findViewById(R.id.b2);
        b3 = (Button)findViewById(R.id.b3);
        b4 = (Button)findViewById(R.id.b4);
        b5 = (Button)findViewById(R.id.b5);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomepageActivity.this,QuizListActivity.class);
                i.putExtra("languageId", 1);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomepageActivity.this,QuizListActivity.class);
                i.putExtra("languageId", 2);
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomepageActivity.this,QuizListActivity.class);
                i.putExtra("languageId", 3);
                startActivity(i);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomepageActivity.this,QuizListActivity.class);
                i.putExtra("languageId", 4);
                startActivity(i);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomepageActivity.this,QuizListActivity.class);
                i.putExtra("languageId", 5);
                startActivity(i);
            }
        });
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_scorecard) {
            Intent intent = new Intent(this, PuzzleActivity.class);
            startActivity(intent);

        } /*else if (id == R.id.nav_Setting) {
            //  startActivity(new Intent(this,Setting.class));
            startActivity(new Intent(this, Setting_activity.class));

        } else*/ if (id == R.id.nav_share) {
            //shareApplication();
            Intent intent = new Intent(android.content.Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            intent.setType("message/rfc822");
            intent.putExtra(Intent.EXTRA_SUBJECT, "QuizBook");
            System.out.println(""+R.string.email_content);
            intent.putExtra(Intent.EXTRA_TEXT, ""+getText(R.string.email_content)+getText(R.string.link)+getText(R.string.last_content));
            Intent chooser = Intent.createChooser(intent, "Share using");
            startActivity(chooser);


        } else if (id == R.id.nav_feedback) {
            Intent intent = new Intent(this, WrongListActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_Setting) {
            MainActivity.USER_ID = 0;
            startActivity(new Intent(this, MainActivity.class));
        } else if (id == R.id.nav_aboutus) {
            Uri uri = Uri.parse("https://github.com/leafeonia/2019-vivo-hackathon");//要跳转的网址
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        /*else if (id == R.id.nav_Help) {
            Intent i = new Intent(this, Help.class);
            startActivity(i);

        } */


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
