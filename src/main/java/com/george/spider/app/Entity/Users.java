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
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;

    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 账号状态 1 正常 2冻结
     */
    private Boolean status;

    @TableField("createdAt")
    private LocalDateTime createdat;

    @TableField("updatedAt")
    private LocalDateTime updatedat;

    /**
     * 头像
     */
    private String avatar;

    private String phone;


}
