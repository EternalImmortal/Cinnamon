package cn.weijoseph.cinnamon.Controller;

import cn.weijoseph.cinnamon.HearthStone.service.HearthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author weirenjie
 * @date 2018/7/19
 */
@Controller
public class WelcomeController {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    HearthService hearthService;

    @RequestMapping("/hello")
    @ResponseBody
    public String HelloWorld() {
        String whoIsSWS = "";
        try {
            redisTemplate.opsForValue().set("孙闻殊是什么", "猪");
            whoIsSWS = (String)redisTemplate.opsForValue().get("孙闻殊是什么");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return whoIsSWS;
    }

    @RequestMapping("/insertHero")
    @ResponseBody
    public String InsertHero() {
        hearthService.insert(2, "2234", "DK");
        return "success or failure";
    }
}
