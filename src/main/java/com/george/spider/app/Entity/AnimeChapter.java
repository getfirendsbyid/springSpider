package com.george.spider.app.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 
 * </p>
 *
 * @author George
 * @since 2021-05-21
 */
@Data
@Component
@EqualsAndHashCode(callSuper = false)
public class AnimeChapter implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 集数名称
     */
    private String title;

    @TableField("playId")
    private String playid;

    /**
     * 描述
     */
    private String desc;

    /**
     * 集数
     */
    @TableField("EpName")
    private String epname;

    /**
     * 播放地址
     */
    @TableField("PlayVid")
    private String playvid;

    @TableField("EpPic")
    private String eppic;

    @TableField("Ex")
    private String ex;

    @TableField("createdAt")
    private LocalDateTime createdat;

    @TableField("updatedAt")
    private LocalDateTime updatedat;

    /**
     * 线路
     */
    private Integer way;


}
