package mish.lisow.test_name;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class Screen2 extends AppCompatActivity implements View.OnClickListener {
    TextView name,full_des;
    Button buttonURL, btnBack;
    ImageView imageView;
    Context ctx = this;
    public Offers offers2;
    public WebView browser = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_2);
        Gson gson = new Gson();
        offers2 = gson.fromJson(getIntent().getStringExtra("SampleObjext"),Offers.class);


        imageView = (ImageView) findViewById(R.id.Logo_2);
        name = (TextView) findViewById(R.id.Company_Name2);
        name.setText(offers2.getName());
        if(!(offers2.getDes_full().equals("null")) ){
            full_des = (TextView) findViewById(R.id.Full_des);
            full_des.setText(offers2.getDes_full());
        }
        buttonURL = (Button) findViewById(R.id.URL);
        if(!(offers2.getBtn2().equals("null"))) {
            buttonURL.setText(offers2.getBtn2());
        }
        Picasso.with(this)
                .load(offers2.getLogo())
                .into(imageView);
        btnBack = (Button) findViewById(R.id.back);
        btnBack.setOnClickListener(this);
        buttonURL.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                   onBackPressed();
                break;
            case R.id.URL:
                if(offers2.getBrowser()){
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(offers2.getURL()));
                    startActivity(myIntent);
                }
                else {
                    Gson gson = new Gson();
                    String myJson = gson.toJson(offers2);
                    Intent int1 = new Intent(this, Web.class);
                    int1.putExtra("ForWeb", myJson);
                    startActivity(int1);
                    break;
                }
        }

    }

}
