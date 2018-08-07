package cn.weijoseph.cinnamon.Controller;

import cn.weijoseph.cinnamon.Arithmetic4th.DailyTest.TestAES;
import cn.weijoseph.cinnamon.Arithmetic4th.ObjectDemo.LearnRecordParam;
import cn.weijoseph.cinnamon.Arithmetic4th.ObjectDemo.UserLearnRecordSubmitDto;
import cn.weijoseph.cinnamon.HearthStone.service.HearthService;
import com.alibaba.fastjson.JSON;
import org.apache.catalina.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    public static final String LEARN_RECORD_SUBMIT_KEY = "learntime_submit";

    @RequestMapping(value = "/hello")
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

    @RequestMapping(value = "/insertHero")
    @ResponseBody
    public String InsertHero() {
        hearthService.insert(2, "2234", "DK");
        return "success or failure";
    }

    @RequestMapping(value = "/testJsonParse", method = RequestMethod.POST)
    @ResponseBody
    public String tryToGetJson(@RequestBody LearnRecordParam learnRecordParam) {
        String signature = learnRecordParam.getSignature();
        UserLearnRecordSubmitDto data = learnRecordParam.getData();
        UserLearnRecordSubmitDto checkDto = JSON.parseObject(TestAES.decryptAES_ECP_128(signature, LEARN_RECORD_SUBMIT_KEY), UserLearnRecordSubmitDto.class);
        if (data.equals(checkDto)) {
            return "true";
        }
        return "false";
    }
    @Test
    public void checkObjectEquals() {
        UserLearnRecordSubmitDto data1 = new UserLearnRecordSubmitDto();
        UserLearnRecordSubmitDto data2 = new UserLearnRecordSubmitDto();
        data1.setStartTime(1L);
        data2.setStartTime(1L);
        System.out.println(data1.equals(data2));
    }

    // @RequestMapping(value = "/test2", method = RequestMethod.POST)
    // @ResponseBody
    // public String tryToGetJson(@RequestBody String str) {
    //     LearnRecordParam learnRecordParam = JSON.parseObject(str, LearnRecordParam.class);
    //     String data = learnRecordParam.getData();
    //     String signature = learnRecordParam.getSignature();
    //     String encrypteData = TestAES.encryptAES_ECB_128(data, LEARN_RECORD_SUBMIT_KEY);
    //     if (signature.equals(encrypteData)) {
    //         return "true";
    //     }
    //     return encrypteData;
    // }
}
