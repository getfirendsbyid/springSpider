package com.george.spider.app.Mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.george.spider.app.Entity.Anime;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author George
 * @since 2021-05-25
 */
public interface AnimeMapper extends BaseMapper<Anime> {

    List<Anime> selectNameAndIdAndCoversmallimgById(@Param("id") Integer id);
}
