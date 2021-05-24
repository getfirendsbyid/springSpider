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
public class Anime implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * agefans id
     */
    @TableField("aId")
    private Integer aid;

    /**
     * 地区Id
     */
    @TableField("areaId")
    private Integer areaid;

    /**
     * R动画种类
     */
    @TableField("typeId")
    private Integer typeid;

    /**
     * R动画名称
     */
    private String name;

    /**
     * R原版名称
     */
    @TableField("trueName")
    private String truename;

    /**
     * R其它名称
     */
    @TableField("otherName")
    private String othername;

    /**
     * R字母索引
     */
    @TableField("letterId")
    private Integer letterid;

    /**
     * R原作
     */
    private String author;

    /**
     * R制作公司
     */
    private String company;

    /**
     * R首播时间
     */
    @TableField("playTime")
    private String playtime;

    /**
     * R播放状态
     */
    @TableField("statusId")
    private Integer statusid;

    /**
     * R新番标题
     */
    @TableField("latestName")
    private String latestname;

    /**
     * R网盘资源
     */
    @TableField("cloudDisk")
    private String clouddisk;

    /**
     * R视频尺寸
     */
    @TableField("videoSize")
    private String videosize;

    /**
     * R官方网站
     */
    private String website;

    /**
     * R更新时间
     */
    @TableField("newUpdateAt")
    private LocalDateTime newupdateat;

    /**
     * R推荐星级
     */
    private Integer star;

    /**
     * R封面图
     */
    @TableField("coverImg")
    private String coverimg;

    /**
     * R封面图小
     */
    @TableField("coverSmallImg")
    private String coversmallimg;

    /**
     * R简介
     */
    @TableField("descText")
    private String desctext;

    /**
     * R首播年份
     */
    @TableField("yearId")
    private Integer yearid;

    /**
     * R首播季度
     */
    @TableField("seasonId")
    private Integer seasonid;

    /**
     * 排名点击
     */
    @TableField("rankCnt")
    private Integer rankcnt;

    @TableField("updatedAt")
    private LocalDateTime updatedat;

    @TableField("createdAt")
    private LocalDateTime createdat;


}
