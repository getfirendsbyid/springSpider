package com.george.spider.app.Request.Anime;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class ListValidator implements Serializable {

        @NotNull(message = "page不能为空" )
        private Integer page;

        @NotNull(message = "pageSize不能为空")
        private Integer pageSize;

}
