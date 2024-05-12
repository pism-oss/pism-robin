package cn.com.pism.pmrb.core.model;

import java.util.ArrayList;
import java.util.List;

import static cn.com.pism.pmrb.core.model.RobinConstant.JSON;

/**
 * @author perccyking
 * @since 2024/5/12 18:35
 */
public class JsonConcat {

    /**
     * keyList
     */
    private List<String> keyList;

    public List<String> getKeyList() {
        return keyList;
    }

    public void setKeyList(List<String> keyList) {
        this.keyList = keyList;
    }

    public static JsonConcat instance() {
        return new JsonConcat();
    }

    public JsonConcat() {
        this.keyList = new ArrayList<>();
    }

    public JsonConcat concat(String key, Object value) {
        if (value != null) {
            this.keyList.add(String.format(key, value));
        }
        return this;
    }

    public String toJson() {
        return String.format(JSON, concat());
    }

    public String concat() {
        return String.join(",", keyList);
    }
}
