package cn.weijoseph.cinnamon.Arithmetic4th.DailyTest;

import cn.weijoseph.cinnamon.Arithmetic4th.ObjectDemo.UserLearnRecordSubmitDto;
import cn.weijoseph.cinnamon.HearthStone.domain.HearthHero;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @author weirenjie
 * @date 2018/8/7
 */
public class TestJSONParse {

    @Test
    public void json1() {
        HearthHero hearthHero = new HearthHero();
        hearthHero.setId(2);
        hearthHero.setName("Valeera");
        hearthHero.setProfession("rogue");

        String heroStr = JSON.toJSONString(hearthHero);
        System.out.println(heroStr);

        String str2 = "{\"id\":\"2\",\"name\":\"Valeera\",\"profession\":\"rogue\"}";
        HearthHero hearthHero1 = JSON.parseObject(str2, HearthHero.class);
        System.out.println(JSON.toJSONString(hearthHero1));
    }

    @Test
    public void json2() {
        String sumbitStr = "{\"recordType\":1,\"targetId\":\"746022\",\"targetType\":0,\"unitId\":\"914133\",\"startTime\":1533540679062,\"endTime\":1533540699067}";
        System.out.println(sumbitStr);
        UserLearnRecordSubmitDto userLearnRecordSubmitDto = JSON.parseObject(sumbitStr, UserLearnRecordSubmitDto.class);
        System.out.println(userLearnRecordSubmitDto.getUnitId());
        System.out.println(JSON.toJSONString(userLearnRecordSubmitDto));
    }
}
