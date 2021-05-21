package com.george.spider.app.Entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("cloudDisk")
public class Clouddisk implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String title;

    private String link;

    /**
     * 提取码
     */
    private String code;

    /**
     * 动画id
     */
    @TableField("animeId")
    private Integer animeid;

    @TableField("createdAt")
    private LocalDateTime createdat;

    @TableField("updatedAt")
    private LocalDateTime updatedat;


}
