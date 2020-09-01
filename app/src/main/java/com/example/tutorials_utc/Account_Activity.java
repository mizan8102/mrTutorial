package com.example.tutorials_utc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Account_Activity extends AppCompatActivity {
    String d="https://obepoint.000webhostapp.com/jobc.php";
    RecyclerView recyclerView;
    jobAdapter jobA;
    List<Jobinfo> list;
    private ProgressDialog pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_);
        getSupportActionBar().setTitle("Interview Question");
       recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        list=new ArrayList<>();
        jdata(d);
        BottomNavigationView btn=(BottomNavigationView)findViewById(R.id.botton_navigation);
        btn.setSelectedItemId(R.id.account);
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
                        startActivity(new Intent(getApplicationContext(), Home.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;
                    case R.id.account:

                        return true;

                }




                return false;
            }
        });

    }
    void jdata(String link){
        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();
        final Jobinfo info=new Jobinfo();
        final RequestQueue requestQueue= Volley.newRequestQueue(getApplication());
        StringRequest stringRequest=new StringRequest(Request.Method.POST, link, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {


                    JSONArray jsonArray=new JSONArray(response);
                    hidePDialog();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        Jobinfo info=new Jobinfo();
                        JSONObject jo=jsonArray.getJSONObject(i);
                        info.setHeader(jo.getString("jheader"));
                        info.setDes(jo.getString("des"));
                        list.add(info);
                    }




                } catch (JSONException e) {
                    e.printStackTrace();
                }


                setuprecyclerview(list);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                hidePDialog();
                new AlertDialog.Builder(Account_Activity.this)
                        .setIcon(R.drawable.logo)
                        .setTitle("UTC TUTORIAL")
                        .setMessage("Your connection is too weak.Please!re-connect your network." +
                                " Go to Back")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(Account_Activity.this,Home.class));
                                finish();
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .create()
                        .show();
                Toast.makeText(getApplication(),"Network Error",Toast.LENGTH_SHORT).show();
                requestQueue.stop();
            }

        });
        requestQueue.add(stringRequest);


    }
    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }
    private void setuprecyclerview(List<Jobinfo> lstAnime) {


        jobAdapter myadapter = new jobAdapter(this,lstAnime) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);

    }
}