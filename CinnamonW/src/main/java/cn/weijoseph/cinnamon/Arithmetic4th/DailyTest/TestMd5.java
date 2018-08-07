package cn.weijoseph.cinnamon.Arithmetic4th.DailyTest;

import com.netease.edu.util.cipher.MD5MsgDigestUtils;
import org.junit.Test;

/**
 * @author weirenjie
 * @date 2018/7/27
 */

public class TestMd5 {
    String originJson = "{startTime:1532570732946,endTime:1532570733946}";
    String originJson2 = "{key:\"test\", data:{startTime: 1532570732946, endTime: 1532570733946}}";
    @Test
    public void digest() {
        String md5 = MD5MsgDigestUtils.digest(originJson);
        System.out.println(md5);
    }
}
