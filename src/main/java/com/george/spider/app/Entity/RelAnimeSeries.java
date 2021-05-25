package com.george.spider.app.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2021-05-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RelAnimeSeries implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("seriesId")
    private Integer seriesid;

    @TableField("animeId")
    private Integer animeid;

    @TableField("createdAt")
    private LocalDateTime createdat;

    @TableField("updatedAt")
    private LocalDateTime updatedat;


}
