package com.simant.retrofitsampleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import android.widget.Toolbar;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // our codes
        recyclerView = findViewById(R.id.recyclerview_sample);
        // call function
        loadDate();

    }
    public void loadDate() {
        ApiInterface apiInterface = BaseURL.getRetrofit().create(ApiInterface.class);
        Call<PlayerInfoModalClass> playerNextClassCall = apiInterface.getInfo();
        playerNextClassCall.enqueue(new Callback<PlayerInfoModalClass>() {
            @Override
            public void onResponse(Call<PlayerInfoModalClass> call, Response<PlayerInfoModalClass> response) {
                if (response.isSuccessful()) {
                    if (response.body()!=null) {
                        System.out.println("Check " + response.body());
                        RecycviewAdapterPlayerInfo recycviewAdapterPlayerInfo = new
                                RecycviewAdapterPlayerInfo(getApplicationContext(), response.body().playerInfoModalClasses);
                        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                        recyclerView.setLayoutManager(linearLayoutManager);
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setAdapter(recycviewAdapterPlayerInfo);
                        recycviewAdapterPlayerInfo.notifyDataSetChanged();
                    } else {
                        Toast.makeText(getApplicationContext(), "Error tracked", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<PlayerInfoModalClass> call, Throwable t) {
                Log.d("MainActivity", t.getMessage());
                Toast.makeText(getApplicationContext(), "Error failure", Toast.LENGTH_SHORT).show();
            }
        });
    }
}