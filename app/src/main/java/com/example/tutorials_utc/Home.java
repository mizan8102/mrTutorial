package com.example.tutorials_utc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Home extends AppCompatActivity {

String header,hpic,des,code,dpic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();
        BottomNavigationView btn=(BottomNavigationView)findViewById(R.id.botton_navigation);
        btn.setSelectedItemId(R.id.home);
       btn.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               switch (item.getItemId())
               {
                   case R.id.about:
                       startActivity(new Intent(getApplicationContext(),About_Activity.class));
                       overridePendingTransition(0,0);
                       finish();
                       return true;
                   case R.id.home:
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
    }

    public void btnc(View view) {

    //jdata(link);
        Intent intent=new Intent(Home.this,Tutorial_Activity.class);
        intent.putExtra("c","C tutorial");
        intent.putExtra("link","https://obepoint.000webhostapp.com/tutorialc.php");
        startActivity(intent);

    }

    public void java(View view) {
        Intent intent=new Intent(Home.this,Tutorial_Activity.class);
        intent.putExtra("c","Java tutorial");
        intent.putExtra("link","https://obepoint.000webhostapp.com/tutorialjava.php");
        startActivity(intent);

    }

    public void androiTest(View view) {
        Intent intent=new Intent(Home.this,Tutorial_Activity.class);
        intent.putExtra("c","Android Tutorial");
        intent.putExtra("link","https://obepoint.000webhostapp.com/tutorialandroid.php");
        startActivity(intent);
    }


    public void python(View view) {
        Intent intent=new Intent(Home.this,Tutorial_Activity.class);
        intent.putExtra("c","Python Tutorial");
        intent.putExtra("link","https://obepoint.000webhostapp.com/tutorialpython.php");
        startActivity(intent);
    }

    public void php(View view) {
        Intent intent=new Intent(Home.this,Tutorial_Activity.class);
        intent.putExtra("c","Python Tutorial");
        intent.putExtra("link","https://obepoint.000webhostapp.com/tutorialphp.php");
        startActivity(intent);
    }

    public void about(View view) {

        Intent intent=new Intent(Home.this,Tutorial_Activity.class);
        intent.putExtra("c","Mysql");
        intent.putExtra("link","https://obepoint.000webhostapp.com/tutorialmysql.php");
        startActivity(intent);



    }

}