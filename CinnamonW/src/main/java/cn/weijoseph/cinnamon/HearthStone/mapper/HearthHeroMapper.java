package cn.weijoseph.cinnamon.HearthStone.mapper;

import cn.weijoseph.cinnamon.HearthStone.domain.HearthHero;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author weirenjie
 * @date 2018/7/24
 */
@Mapper
public interface HearthHeroMapper {
    /**
     * 添加一位新的炉石英雄
     *
     * @param hearthHero
     */
    void insertHero(HearthHero hearthHero);
}
