package com.george.spider.app.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Error<T>{
    public static final int errorCode = 1;
    private Integer code = errorCode;
    private String message ;
    private T data;
}
