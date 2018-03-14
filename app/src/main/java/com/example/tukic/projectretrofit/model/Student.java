package com.example.tukic.projectretrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Tukic on 6/9/2017.
 */

public class Student {



    @SerializedName("Id")
    @Expose
    private long Id;

    @SerializedName("FirstName")
    @Expose
    private String FirstName;

    @SerializedName("SecondName")
    @Expose
    private String SecondName;

    @SerializedName("IndexNumber")
    @Expose
    private String IndexNumber;

    public Student() {
    }

    public Student(long id, String firstName, String secondName, String indexNumber) {
        Id = id;
        FirstName = firstName;
        SecondName = secondName;
        IndexNumber = indexNumber;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String secondName) {
        SecondName = secondName;
    }

    public String getIndexNumber() {
        return IndexNumber;
    }

    public void setIndexNumber(String indexNumber) {
        IndexNumber = indexNumber;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("Id=").append(Id);
        sb.append(", FirstName='").append(FirstName).append('\'');
        sb.append(", SecondName='").append(SecondName).append('\'');
        sb.append(", IndexNumber='").append(IndexNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
