package cn.weijoseph.cinnamon.HearthStone.service;

import cn.weijoseph.cinnamon.HearthStone.domain.HearthHero;
import cn.weijoseph.cinnamon.HearthStone.mapper.HearthHeroMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author weirenjie
 * @date 2018/7/24
 */

@Service
public class HearthService {
    @Autowired
    HearthHeroMapper hearthHeroMapper;

    public void insert(Integer id, String name, String profession) {
        HearthHero hearthHero = new HearthHero();
        hearthHero.setId(id);
        hearthHero.setName(name);
        hearthHero.setProfession(profession);
        hearthHeroMapper.insertHero(hearthHero);
    }
}
