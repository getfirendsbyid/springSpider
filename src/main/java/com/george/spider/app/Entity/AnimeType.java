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
 * 动漫类型表
 * </p>
 *
 * @author George
 * @since 2021-05-21
 */
@Data
@Component
@EqualsAndHashCode(callSuper = false)
public class AnimeType implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 类型
     */
    private String type;

    @TableField("createdAt")
    private LocalDateTime createdat;

    @TableField("updatedAt")
    private LocalDateTime updatedat;


}
