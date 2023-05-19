package com.example.experience.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.experience.Models.Ragister_Data;
import com.example.experience.R;
import com.example.experience.Retro;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Ragister_Activity extends AppCompatActivity {

    EditText name, email, password;
    Button btnragister;
    TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ragister);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btnragister = findViewById(R.id.btnragister);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnragister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!name.getText().toString().isEmpty()
                        && !email.getText().toString().isEmpty()
                        && !password.getText().toString().isEmpty()) {

                    if (password.length() == 4) {

                        Retro.getInstance().retroAPI.Ragister_data(name.getText().toString()
                                        , email.getText().toString()
                                        , password.getText().toString())
                                .enqueue(new Callback<Ragister_Data>() {

                                    @Override
                                    public void onResponse(Call<Ragister_Data> call, Response<Ragister_Data> response) {

                                        if (response.body().getConnection() == 1) {
                                            if (response.body().getResult() == 1) {

                                                name.setText("");
                                                email.setText("");
                                                password.setText("");

                                                Toast.makeText(Ragister_Activity.this, "Successfully Ragister!", Toast.LENGTH_SHORT).show();

                                            } else if (response.body().getResult() == 2) {
                                                Toast.makeText(Ragister_Activity.this, "Already Ragister!", Toast.LENGTH_SHORT).show();
                                            } else {
                                                Toast.makeText(Ragister_Activity.this, "Something went Wrong!", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<Ragister_Data> call, Throwable t) {

                                        Toast.makeText(Ragister_Activity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                });

                    } else {
                        Toast.makeText(Ragister_Activity.this, "Password lengh is only 4 Character!", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(Ragister_Activity.this, "Enter Proper Enput!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}