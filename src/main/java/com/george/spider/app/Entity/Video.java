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
public class Video implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标题
     */
    private String title;

    @TableField("coverImgUrl")
    private String coverimgurl;

    /**
     * 番剧id
     */
    @TableField("animeId")
    private Integer animeid;

    /**
     * 番剧月份集合Id
     */
    @TableField("animeConllentId")
    private Integer animeconllentid;

    /**
     * 视频地址
     */
    @TableField("videoUrl")
    private String videourl;

    @TableField("createdAt")
    private LocalDateTime createdat;

    @TableField("updatedAt")
    private LocalDateTime updatedat;


}
