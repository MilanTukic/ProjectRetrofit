package com.example.tukic.projectretrofit.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.view.View;

import com.example.tukic.projectretrofit.R;
import com.example.tukic.projectretrofit.model.Student;
import com.example.tukic.projectretrofit.service.ApiUtils;
import com.example.tukic.projectretrofit.service.Client;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.R.attr.id;

public class ItemActivity extends AppCompatActivity {
    ImageButton delete;
    ImageButton update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        final EditText edT = (EditText) findViewById(R.id.addName);
        final EditText edT1 = (EditText) findViewById(R.id.addLastName);
        final EditText edT2 = (EditText) findViewById(R.id.addIndex);
      //  int id = getIntent().getIntExtra("ID",0);
        Bundle extras = getIntent().getExtras();
        final long id = extras.getLong("ID", 0);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://192.168.1.251:96/api/students/")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

        final Client client = retrofit.create(Client.class);
        Call<Student> call = client.getStudentItem(id);
        call.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {
               // List<Student> repos = response.body();
                Student repo = response.body();
                //Student repo = new Student();
                edT.setText(repo.getFirstName());
                edT1.setText(repo.getSecondName());
                edT2.setText(repo.getIndexNumber());
            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {
                Toast.makeText(getBaseContext(), "nooo", Toast.LENGTH_SHORT).show();
            }
        });

        delete = (ImageButton) findViewById(R.id.deleteStudent);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit.Builder builder = new Retrofit.Builder()
                        .baseUrl("http://192.168.1.251:96/api/students/")
                        .addConverterFactory(GsonConverterFactory.create());
                Retrofit retrofit = builder.build();

                Client client = retrofit.create(Client.class);
                Call<Void> call = client.deletePost(id);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Toast.makeText(getBaseContext(), "Deleted.", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(ItemActivity.this, MainActivity.class);
                        startActivity(i);
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(getBaseContext(), "Non deleted.", Toast.LENGTH_SHORT).show();
                    }
                });
            }

        });

        update = (ImageButton) findViewById(R.id.updateStudent);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student stud = new Student();
                stud.setId(id);
                stud.setFirstName(edT.getText().toString());
                stud.setSecondName(edT1.getText().toString());
                stud.setIndexNumber(edT2.getText().toString());

                Retrofit.Builder builder = new Retrofit.Builder()
                        .baseUrl("http://192.168.1.251:96/api/students/")
                        .addConverterFactory(GsonConverterFactory.create());

                Retrofit retrofit = builder.build();
                Client client = retrofit.create(Client.class);
                Call<Void> call = client.updateStud(id, stud);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Toast.makeText(getBaseContext(), "Updated!", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(ItemActivity.this, MainActivity.class);
                        startActivity(i);
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                        Toast.makeText(getBaseContext(), "Non updated.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
