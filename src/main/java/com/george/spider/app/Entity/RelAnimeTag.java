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
public class RelAnimeTag implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标签
     */
    private String tagId;

    /**
     * 动漫id
     */
    private Integer animeId;

    @TableField("createAt")
    private LocalDateTime createat;

    @TableField("updatedAt")
    private LocalDateTime updatedat;


}
