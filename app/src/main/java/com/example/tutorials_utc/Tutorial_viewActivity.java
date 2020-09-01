package com.example.tutorials_utc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Tutorial_viewActivity extends AppCompatActivity {
TextView des,code;
ImageView pic;
    String c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_view);
        des=(TextView)findViewById(R.id.txtdes);
        code=(TextView)findViewById(R.id.txtcode) ;
        pic=(ImageView)findViewById(R.id.txtdpic);

        Intent i=getIntent();
        String h =i.getStringExtra("header");
        String d=i.getStringExtra("des");
        c=i.getStringExtra("code");
        String p=i.getStringExtra("pic");
        getSupportActionBar().setTitle(h);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        des.setText(d);
        code.setText(c);
        Picasso.get().load(p).into(pic);
    }

    public void sharebtn(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, c);
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, "Share Code");
        startActivity(shareIntent);
    }
}