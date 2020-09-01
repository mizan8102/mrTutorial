package com.example.tutorials_utc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Tutorial_Activity extends AppCompatActivity {
 RecyclerView recyclerView;
 List<Info_data> list;
    String header,hpic,des,code,dpic;
    private ProgressDialog pDialog;


 AdapterClass adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_);
        recyclerView=(RecyclerView)findViewById(R.id.recycler);

        Intent intent=getIntent();
       String m=intent.getStringExtra("c");
       String d=intent.getStringExtra("link");
       getSupportActionBar().setTitle(m);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        list=new ArrayList<>();

        jdata(d);







    }
    void jdata(String link){
        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();
        final Info_data info=new Info_data();
        final RequestQueue requestQueue= Volley.newRequestQueue(getApplication());
        StringRequest stringRequest=new StringRequest(Request.Method.POST, link, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {


                    JSONArray jsonArray=new JSONArray(response);
                    hidePDialog();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        Info_data info=new Info_data();
                        JSONObject jo=jsonArray.getJSONObject(i);
                        info.setHeader(jo.getString("header"));
                        info.setHpic(jo.getString("hpic"));
                        info.setCode(jo.getString("code"));
                        info.setDes(jo.getString("des"));
                        info.setDpic(jo.getString("dpic"));

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
                new AlertDialog.Builder(Tutorial_Activity.this)
                        .setIcon(R.drawable.logo)
                        .setTitle("UTC TUTORIAL")
                        .setMessage("Your connection is too weak.Please!re-connect your network." +
                                " Go to Back")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(Tutorial_Activity.this,Home.class));
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
    private void setuprecyclerview(List<Info_data> lstAnime) {


        AdapterClass myadapter = new AdapterClass(this,lstAnime) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);

    }
}