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
public class Tag implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * tag名称
     */
    private String tag;

    @TableField("createdAt")
    private LocalDateTime createdat;

    @TableField("updatedAt")
    private LocalDateTime updatedat;


}
