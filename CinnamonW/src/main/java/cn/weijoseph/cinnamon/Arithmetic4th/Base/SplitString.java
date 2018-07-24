package cn.weijoseph.cinnamon.Arithmetic4th.Base;

import java.util.Arrays;
import java.util.List;

/**
 * @author weirenjie
 * @date 2018/7/6
 */
public class SplitString {
    public final String rdsHotwords = "前端;语言;媒体;课程;项目;课堂;动画;零玩;axure;photoshop;web;springboot;游戏;测试;免费;秋叶;thinkphp;ps;设计;运营;计算机;营销;javaweb;html;pr;excel;物理;经理;ppt;原理;go;jquery;教程;算法;php;vba;数据库;linux;编程;公众;学习;吴恩达;python;mysql;素描;管理;爬虫;开发;ui;大学;入门;js;sql;java;vue;数学;软件;淘宝;线性;ai;分析;李南江;产品;人工智能;程序;系统;吉他;李涛;安全;概率;高中;matlab;unity;网络;视频;机器;处理;高数;英语;深度;电路;数据;spring;oracle;日语;会计;react;word;cad;结构;区块链;代数;javascript;博士;实战;ae;摄影;高等数学;基础;android";

    public List<String> splitStringByArrays(String str) {
        List<String> resultList = Arrays.asList(str.split(";"));
        return resultList;
    }
}
