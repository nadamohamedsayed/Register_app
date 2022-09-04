package com.example.login_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Register extends AppCompatActivity {

    private Button registerbtn;
    private EditText edt1,edt2,edt3;
    public static Api_Interface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        apiInterface = Retrofitclient.getApiclient().create(Api_Interface.class);

        registerbtn = findViewById(R.id.but);
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        edt3 = findViewById(R.id.edt3);


        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                preformsignup();
            }
        });
    }

    public void preformsignup()
    {


        String name = edt1.getText().toString();
        String username = edt2.getText().toString();
        String password = edt3.getText().toString();

        //Api_Interface api_interface= retrofit.create(Api_Interface.class);
        Call<Api_rep> call = Retrofitclient.getApiclient().create(Api_Interface.class).performregistration(name,username,password);
        //Api_Interface apiinter = retrofit.create(Api_Interface.class);
        //Call<Api_rep> call = apiinter.performregistration(name,username,password);
        //Call<Api_rep> call = apiInterface.performregistration(name,username,password);
        call.enqueue(new Callback<Api_rep>() {
            @Override
            public void onResponse(Call<Api_rep> call, Response<Api_rep> response) {

                if(response.body().getResponse().equals("ok"))
                {
                    Toast.makeText(Register.this,"registered succesfully", Toast.LENGTH_SHORT).show();

                }
                else if(response.body().getResponse().equals("exist"))
                {
                    Toast.makeText(Register.this,"this user already exist", Toast.LENGTH_SHORT).show();
                }
                else if(response.body().getResponse().equals("error"))
                {
                    Toast.makeText(Register.this,"Something went wrong...", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Api_rep> call, Throwable t) {

                Toast.makeText(Register.this,"something went wrong 222...", Toast.LENGTH_SHORT).show();
            }
        });

        edt1.setText(" ");
        edt2.setText(" ");
        edt3.setText(" ");

    }
}