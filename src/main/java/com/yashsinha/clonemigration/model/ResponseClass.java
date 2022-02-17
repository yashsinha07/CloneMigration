package com.yashsinha.clonemigration.model;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class ResponseClass {
    
    private String httpCode;
    private DataJSON data;
}
