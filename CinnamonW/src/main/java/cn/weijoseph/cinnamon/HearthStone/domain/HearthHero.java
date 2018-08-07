package cn.weijoseph.cinnamon.HearthStone.domain;

import java.io.Serializable;

/**
 * @author weirenjie
 * @date 2018/7/24
 */
public class HearthHero implements Serializable {
    private static final long serialVersionUID = 8354812222289086140L;
    private Integer id;
    private String name;
    private String profession;

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
