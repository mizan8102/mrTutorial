package com.example.tutorials_utc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

public class About_Activity extends AppCompatActivity {
    TextView link,gmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_);
       getSupportActionBar().hide();
        BottomNavigationView btn=(BottomNavigationView)findViewById(R.id.botton_navigation);
        btn.setSelectedItemId(R.id.about);
        btn.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.about:
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),Home.class));

                        overridePendingTransition(0,0);
                        finish();
                        return true;
                    case R.id.account:
                        startActivity(new Intent(getApplicationContext(),Account_Activity.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;

                }




                return false;
            }
        });
        ImageView roundedimag = (ImageView) findViewById(R.id.roundedimage);
        // Load an image using Picasso library
        Picasso.get()
                .load("https://scontent.fcgp1-1.fna.fbcdn.net/v/t1.0-9/90221503_688169682010427_9167963320899076096_o.jpg?_nc_cat=110&_nc_sid=09cbfe&_nc_eui2=AeH-aU01e0MJoM541f2g3M6ltgGEL_46oCy2AYQv_jqgLEw2MAS61Y8Jjn_skl6UMudG5ZmvgydpXKPH5dP14d72&_nc_ohc=xfOWN5Zz7lIAX_2mGnj&_nc_ht=scontent.fcgp1-1.fna&oh=8c3ed12c129c686cd1020a807fa1baaf&oe=5F5B6E78")
                .into(roundedimag);

        // Load an image using Glide library
        link = (TextView) findViewById(R.id.textView1);
        String linkText = "To know more.Please! Visit <a href='http://developermizan.epizy.com'>Mizanur Rahman</a> web page.";
        link.setText(Html.fromHtml(linkText));
        link.setMovementMethod(LinkMovementMethod.getInstance());
        TextView email = (TextView) findViewById(R.id.email);
        String emailText = "Send email: <a href=\"mailto:mizan81025@gmail.com\">Click Here!</a>";
        email.setText(Html.fromHtml(emailText));
        email.setMovementMethod(LinkMovementMethod.getInstance());

    }


}