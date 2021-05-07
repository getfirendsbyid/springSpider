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
 * @since 2021-05-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Anime implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 番剧
     */
    private String anime;

    /**
     * 描述
     */
    private String sign;

    /**
     * 集数
     */
    private Integer episode;

    @TableField("playTime")
    private LocalDateTime playtime;

    @TableField("cratedAt")
    private LocalDateTime cratedat;

    @TableField("updatedAt")
    private LocalDateTime updatedat;

    /**
     * 封面
     */
    private String cover;

    /**
     * 所扒平台的id
     */
    private Integer jiId;

    private Integer status;


}
