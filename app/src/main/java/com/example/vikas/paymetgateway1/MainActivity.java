package com.example.vikas.paymetgateway1;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    TextView name, companyName, price;
    ImageView imageView;
    private ListView listView;
    CustomAdapter customAdapter;
    int[] Images = {R.drawable.beauty_horizontal_recycler_view,
            R.drawable.daily_need_horizontal_recycler_view,
            R.drawable.fashion_horizontal_recycler_view,
            R.drawable.horizontal_recycler_view_electronics,
            R.drawable.horizontal_recycler_view_women,
            R.drawable.jacqueline,
            R.drawable.men_horizontal_recycler_view,

    };
     String Name[] = {"Nike", "Adidass", "Reebok", "Puma", "Jordan", "LV", "Levi's"};

     String CompanyName[] = {"Goa Mah", "Goa Mah", "Goa Mah", "Goa Mah", "Goa Mah", "Goa Mah", "Goa Mah"};
     int Price[] = {1000, 2132, 1999, 1499, 2499, 2998, 998};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);
        customAdapter=new CustomAdapter();
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(MainActivity.this,PayMent.class);
        intent.putExtra("COST",String.valueOf(Price[position]));
        startActivity(intent);
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return Images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            convertView = getLayoutInflater().inflate(R.layout.list_items, null);


            name = (TextView)convertView.findViewById(R.id.product_name);
            companyName = (TextView)convertView.findViewById(R.id.product_company);
            price = (TextView)convertView.findViewById(R.id.product_cost);
            imageView = (ImageView)convertView.findViewById(R.id.image_view);

            imageView.setImageResource(Images[position]);
            name.setText(Name[position]);
            companyName.setText(CompanyName[position]);
            price.setText(String.valueOf(Price[position]));

            return convertView;
        }
    }
}
