package com.example.fetchdatauserretrofit1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerview;
    RecyclerView.Adapter mAdapter;
    List<ServiceData> serviceData;
    ArrayList<HashMap<String, String>> arrayListServise;
    RecyclerView.LayoutManager mLayoutManager;
    public static MyInterface serviceApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        serviceApi = RetrofitClient.getApiClient(MyInterface.JSONURL).create(MyInterface.class);

        mRecyclerview = findViewById(R.id.reclerview);
        mLayoutManager = new LinearLayoutManager(MainActivity.this);
        mRecyclerview.setLayoutManager(mLayoutManager);

       /* mRecyclerview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent i1 = new Intent(MainActivity.this,Main2Activity.class);
                 startActivity(i1);
            }
        });*/

        refresh_services();
    }

    private void refresh_services() {
        Call<List<ServiceData>> userCall = MainActivity.serviceApi.get_services();
        userCall.enqueue(new Callback<List<ServiceData>>()
        {
            @Override
            public void onResponse(Call<List<ServiceData>> call, Response<List<ServiceData>> response) {
                serviceData = response.body();
                mAdapter = new Servicepojo(MainActivity.this,serviceData);
                mRecyclerview.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<ServiceData>> call, Throwable t) {

            }
        });


    }


}
