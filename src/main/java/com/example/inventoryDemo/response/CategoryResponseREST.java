package com.example.inventoryDemo.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResponseREST extends ResponseRest {
    private CategoryResponse categoryResponse = new CategoryResponse();
}
