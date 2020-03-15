package com.example.myfeaturemodule.models;

import com.google.gson.annotations.SerializedName;

public class DummyResponse {

    @SerializedName("id")
    private long id;

    @SerializedName("employee_name")
    private String name;

    @SerializedName("employee_salary")
    private int salary;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }
}
