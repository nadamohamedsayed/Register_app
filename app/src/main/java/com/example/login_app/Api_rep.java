package com.example.login_app;

import com.google.gson.annotations.SerializedName;

public class Api_rep {

    @SerializedName("response")
    private String response;

    @SerializedName("name")
    private String name;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
