package com.george.spider.app.Entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author George
 * @since 2021-05-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Banner implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * banner图片地址
     */
    private String image;

    /**
     * 动漫id
     */
    private Integer animeId;

    @TableField("createdAt")
    private LocalDateTime createdat;

    @TableField("updatedAt")
    private LocalDateTime updatedat;


}
