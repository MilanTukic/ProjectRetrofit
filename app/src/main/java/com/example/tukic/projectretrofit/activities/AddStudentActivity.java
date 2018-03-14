package com.example.tukic.projectretrofit.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.example.tukic.projectretrofit.R;
import com.example.tukic.projectretrofit.model.Student;
import com.example.tukic.projectretrofit.service.ApiUtils;
import com.example.tukic.projectretrofit.service.Client;

import retrofit2.Call;
import retrofit2.Callback;

public class AddStudentActivity extends Activity {

    private TextView mResponseTv;
    private Client mAPIService;

    EditText eT1;
    EditText eT2;
    EditText eT3;
    ImageButton insert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        eT1 = (EditText) findViewById(R.id.addName);
        eT2 = (EditText) findViewById(R.id.addLastName);
        eT3 = (EditText) findViewById(R.id.addIndex);
        insert = (ImageButton) findViewById(R.id.btnAddStudent);
        mResponseTv = (TextView) findViewById(R.id.tv_response);
        mAPIService = ApiUtils.getAPIService();
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddStudentActivity.this, "Added!", Toast.LENGTH_LONG).show();
                String FirstName = eT1.getText().toString().trim();
                String SecondName = eT2.getText().toString().trim();
                String IndexNumber = eT3.getText().toString().trim();
                if (!TextUtils.isEmpty(FirstName) && !TextUtils.isEmpty(SecondName) && !TextUtils.isEmpty(IndexNumber)) {
                     sendPost(FirstName, SecondName, IndexNumber);
                }
            }
        });}

        public void sendPost(String FirstName, String SecondName, String IndexNumber) {
            mAPIService.savePost(FirstName, SecondName, IndexNumber, 1).enqueue(new Callback<Student>() {
                public static final String TAG = "Posting user";

                @Override
                public void onResponse(Call<Student> call, retrofit2.Response<Student> response) {
                    if(response.isSuccessful()) {
                        showResponse(response.body().toString());
                        Log.i(TAG, "post submitted to API." + response.body().toString());
                    }
                    Intent i = new Intent(AddStudentActivity.this, MainActivity.class);
                    startActivity(i);
                }

                @Override
                public void onFailure(Call<Student> call, Throwable t) {
                    Log.e(TAG, "Unable to submit post to API.");
                }
            });
        }

        public void showResponse(String response) {
                if(mResponseTv.getVisibility() == View.GONE) {
                    mResponseTv.setVisibility(View.VISIBLE);
                }
                mResponseTv.setText(response);
            }
}
