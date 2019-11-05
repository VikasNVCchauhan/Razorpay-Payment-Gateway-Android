package com.example.vikas.paymetgateway1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

public class PayMent extends AppCompatActivity implements PaymentResultListener {

    private TextView price;
    String Data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_ment);

        price=(TextView)findViewById(R.id.price_is);
        Data= getIntent().getStringExtra("COST");

        startPayment(Data);
        Toast.makeText(this, ""+Data, Toast.LENGTH_SHORT).show();
        price.setText(Data);

    }

    private void startPayment(String data) {
        int cost=Integer.parseInt(data);
        Checkout checkout=new Checkout();
        checkout.setImage(R.drawable.beauty_horizontal_recycler_view);  //logo

        final Activity activity=this;

        try
        {
            JSONObject option=new JSONObject();
            option.put("Description","#order2342r4");
            option.put("Currency","INR");
            option.put("amount",cost*100);
            checkout.open(activity,option);

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onPaymentSuccess(String s) {

        Toast.makeText(this, "Payment Successful", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(this, "Payment Failed Due to few reasons", Toast.LENGTH_SHORT).show();
    }
}
