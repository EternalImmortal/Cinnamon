package cn.weijoseph.cinnamon.Arithmetic4th.ObjectDemo;

import java.io.Serializable;

/**
 * @author weirenjie
 * @date 2018/8/7
 */
public class LearnRecordParam implements Serializable {

    private static final long serialVersionUID = 7605285644418633762L;

    private UserLearnRecordSubmitDto data;
    private String signature;

    public UserLearnRecordSubmitDto getData() {
        return data;
    }

    public void setData(UserLearnRecordSubmitDto data) {
        this.data = data;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
