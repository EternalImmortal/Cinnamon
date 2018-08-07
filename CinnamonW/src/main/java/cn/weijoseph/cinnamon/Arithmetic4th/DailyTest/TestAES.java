package cn.weijoseph.cinnamon.Arithmetic4th.DailyTest;

import cn.weijoseph.cinnamon.Arithmetic4th.AnnotationOfWRJ.TimeCount;
import cn.weijoseph.cinnamon.HearthStone.domain.HearthHero;
import com.netease.edu.util.cipher.AESCipherUtils;
import org.bouncycastle.util.encoders.Base64;
import org.junit.Test;
import com.alibaba.fastjson.JSON;

/**
 * @author weirenjie
 * @date 2018/8/6
 */
public class TestAES {
    public static final String DEFAULT_CHARSET = "utf-8";
    @Test
    public void stringAndJsonDeal() {
        try {
            HearthHero hearthHero = new HearthHero();
            hearthHero.setProfession("rugue");
            hearthHero.setName("Valleera");
            hearthHero.setId(2);
            System.out.println("初始Json字符串：\n" + JSON.toJSON(hearthHero));
            String key = "learntime_submit";
            String plainText = "{\"recordType\":1,\"targetId\":\"746022\",\"targetType\":0,\"unitId\":\"914133\",\"startTime\":1533540679062,\"endTime\":1533540699067}";


            byte[] plainData = plainText.getBytes(DEFAULT_CHARSET);
            // byte[] keyData = Base64.decode(key.getBytes(DEFAULT_CHARSET));
            byte[] keyData = key.getBytes(DEFAULT_CHARSET);
            System.out.println("重新编码之后的key：" + keyData);
            System.out.println("key的长度是：" + keyData.length);
            byte[] encryptData = AESCipherUtils.encrypt(plainData, keyData);
            System.out.println("加密后的比特：\n" + encryptData);
            String endText = new String(Base64.encode(encryptData), DEFAULT_CHARSET);
            System.out.println("加密后的字符串：\n" + endText);

            String encrypt = endText;
            byte[] encryptData1 = Base64.decode(encrypt.getBytes(DEFAULT_CHARSET));
            // byte[] encryptData1 = encrypt.getBytes(DEFAULT_CHARSET);
            System.out.println("要解密的比特：\n" + encryptData1);
            byte[] plainData1 = AESCipherUtils.decrypt(encryptData1, keyData);
            String startText = new String(plainData1, DEFAULT_CHARSET);
            System.out.println("解密之后的：" + startText);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void test1() {
        try {
            String key = "LearnRecord";
            String plainText = "{\"recordType\":1,\"targetId\":\"746022\",\"targetType\":0,\"unitId\":\"914133\",\"startTime\":1533540679062,\"endTime\":1533540699067}";
            String t1 = AESCipherUtils.encryptBase64Utf8String(plainText, key);
            String t2 = AESCipherUtils.decryptBase64Utf8String(t1, key);
            System.out.println(t2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * AES_ECB_128加密
     * @param plainText
     * @param key
     * @return
     */
    // @TimeCount(name = "AES加密")
    public static String encryptAES_ECB_128(String plainText, String key) {
        try {
            byte[] plainData = plainText.getBytes(DEFAULT_CHARSET);
            byte[] keyData = key.getBytes(DEFAULT_CHARSET);
            byte[] encryptData = AESCipherUtils.encrypt(plainData, keyData);
            String encryptText = new String(Base64.encode(encryptData), DEFAULT_CHARSET);
            return encryptText;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "加密过程中出现错误！";
        }
    }

    /**
     * AES_ECB_128解密
     * @param encryptText
     * @param key
     * @return
     */
    @TimeCount(name = "AES解密")
    public static String decryptAES_ECP_128(String encryptText, String key) {
        try {
            byte[] encryptData = Base64.decode(encryptText.getBytes(DEFAULT_CHARSET));
            byte[] keyData = key.getBytes(DEFAULT_CHARSET);
            byte[] decryptData = AESCipherUtils.decrypt(encryptData, keyData);
            String decryptTest = new String(decryptData, DEFAULT_CHARSET);
            return decryptTest;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "解密过程中出现错误！";
        }
    }


}