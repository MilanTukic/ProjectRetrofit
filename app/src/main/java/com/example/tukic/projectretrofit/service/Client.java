package com.example.tukic.projectretrofit.service;

import com.example.tukic.projectretrofit.model.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Tukic on 6/9/2017.
 */

public interface Client {

    @GET("/api/students/")
    Call<List<Student>> repoForUser();

    @GET("/api/students/{id}")
    Call<Student> getStudentItem(@Path("id") long id);

    @POST("/api/students/")
    @FormUrlEncoded
    Call<Student> savePost(@Field("FirstName") String FirstName,
                           @Field("SecondName") String SecondName,
                           @Field("IndexNumber") String IndexNumber,
                           @Field("Id") long Id);

    @DELETE("/api/students/{id}")
    Call<Void> deletePost(@Path("id") long Id);

    @PUT("/api/students/{id}")
    Call<Void> updateStud(@Path("id") long id, @Body Student stud);
}
