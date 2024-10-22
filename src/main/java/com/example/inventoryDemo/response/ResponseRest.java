package com.example.inventoryDemo.response;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;

@Getter
public class ResponseRest {

    private final HashMap<String, String>  data = new HashMap<>();

    public void setData(String type, String code, String message) {
        data.put("type", type);
        data.put("code", code);
        data.put("message", message);
    }
}
