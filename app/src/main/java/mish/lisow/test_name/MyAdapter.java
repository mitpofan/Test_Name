package mish.lisow.test_name;

import android.annotation.SuppressLint;
import android.content.Context;

import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lisow on 13.09.2018.
 */

class BoxAdapter extends BaseAdapter{
    Context ctx;
    LayoutInflater lInflater;
    List<Offers> objects;
    ImageView imageView;
    TextView short_des, Company_Name;
    Button button;

    BoxAdapter(Context context, List<Offers> offers) {
        ctx = context;
        objects = offers;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // кол-во элементов
    @Override
    public int getCount() {
        return objects.size();
    }

    // элемент по позиции
    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    // id по позиции
    @Override
    public long getItemId(int position) {
        return position;
    }

    // пункт списка
    @SuppressLint("ResourceType")
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // используем созданные, но не используемые view
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.list_item_1, parent, false);

        }

        final Offers of = getProduct(position);

        imageView = (ImageView) view.findViewById(R.id.Logo);
        short_des = (TextView) view.findViewById(R.id.short_des);
        Company_Name = (TextView) view.findViewById(R.id.Offer_name);
        button = (Button) view.findViewById(R.id.button1);
        if(of.getEnabled()) {
            short_des.setText(of.getDes());
            Company_Name.setText(of.getName());
            if (!(of.getBtn1().equals("null"))) {
                button.setText(of.getBtn1());
            }

            Picasso.with(ctx)
                    .load(of.getLogo())
                    .into(imageView);
        }
        else{
           short_des.setVisibility(view.GONE);
           imageView.setVisibility(view.GONE);
            Company_Name.setVisibility(view.GONE);
            button.setVisibility(view.GONE);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gson gson = new Gson();
                String myJson = gson.toJson(of);
                Intent intent = new Intent(ctx, Screen2.class);
                intent.putExtra("SampleObjext",  myJson);
                ctx.startActivity(intent);
            }
        });
        return view;
    }

    // товар по позиции
    Offers getProduct(int position) {
        return ((Offers) getItem(position));
    }

}