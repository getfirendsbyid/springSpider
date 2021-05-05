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
 * @since 2021-05-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AnimeConllent implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 新番集合名称
     */
    @TableField("animeConllentName")
    private String animeconllentname;

    @TableField("createdAt")
    private LocalDateTime createdat;

    @TableField("updatedAt")
    private LocalDateTime updatedat;


}
