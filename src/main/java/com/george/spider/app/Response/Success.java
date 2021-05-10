package com.george.spider.app.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Success<T>{
    public static final int successCode = 200;
    private Integer code = successCode;
    private String message ;
    private T data;

}
