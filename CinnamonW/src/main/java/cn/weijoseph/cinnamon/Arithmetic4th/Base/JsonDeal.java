package cn.weijoseph.cinnamon.Arithmetic4th.Base;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.*;

/**
 * @author weirenjie
 * @date 2018/6/29
 */
public class JsonDeal {
    public String formatJson1(String jsonStr) {
        if (null == jsonStr || "".equals(jsonStr)) return "";
        StringBuilder sb = new StringBuilder();
        char last = '\0';
        char current = '\0';
        int indent = 0;
        for (int i = 0; i < jsonStr.length(); i++) {
            last = current;
            current = jsonStr.charAt(i);
            switch (current) {
                case '{':
                case '[':
                    sb.append(current);
                    sb.append('\n');
                    indent++;
                    addIndentBlank(sb, indent);
                    break;
                case '}':
                case ']':
                    sb.append('\n');
                    indent--;
                    addIndentBlank(sb, indent);
                    sb.append(current);
                    break;
                case ',':
                    sb.append(current);
                    if (last != '\\') {
                        sb.append('\n');
                        addIndentBlank(sb, indent);
                    }
                    break;
                default:
                    sb.append(current);
            }
        }

        return sb.toString();
    }

    /**
     * 添加space
     * @param sb
     * @param indent
     */
    private static void addIndentBlank(StringBuilder sb, int indent) {
        for (int i = 0; i < indent; i++) {
            sb.append('\t');
        }
    }

    public StringBuffer formatJson2(Object json, int num, boolean isArray){
        StringBuffer buffer=new StringBuffer();
        if(json instanceof JSONObject){
            JSONObject jsonObject=(JSONObject) json;
            num+=5;
            if(isArray){
                buffer.append(getKg(num)+"{</br>");
            }else{
                buffer.append("{</br>");
            }
            for(String k:jsonObject.keySet()){
                buffer.append(getKg(num+2)+k+" : ");
                formatJson2(jsonObject.get(k), num,false); //格式化子目录
            }
            buffer.append(getKg(num)+"}</br>");
        }
        else if(json instanceof JSONArray){
            JSONArray jsonArray=(JSONArray) json;
            num+=5;
            buffer.append("[</br>");
            for(int k=0;k<jsonArray.size();k++){
                formatJson2(jsonArray.get(k), num,true); //格式化子目录
            }
            buffer.append(getKg(num)+"]</br>");
        }else{ //如果不是json对象就直接打印值
            buffer.append(json.toString()+"</br>");
        }

        return buffer;

    }

    /**
     * 获取num个数个空格
     * @param num
     * @return
     */
    private String getKg(Integer num){
        StringBuffer kg=new StringBuffer();
        for(int i=0;i<num;i++){
            kg.append("&nbsp;");
        }
        return kg.toString();
    }

    public String formatJson3(String uglyJSONString){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(uglyJSONString);
        String prettyJsonString = gson.toJson(je);
        return prettyJsonString;
    }
}
