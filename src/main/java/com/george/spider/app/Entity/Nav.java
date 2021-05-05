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
public class Nav implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nav;

    private String url;

    @TableField("createdAt")
    private LocalDateTime createdat;

    @TableField("updatedAt")
    private LocalDateTime updatedat;

    /**
     * 状态 1启用 2关闭
     */
    private Integer status;


}
