package cn.com.pism.pmrb.core.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author perccyking
 * @since 2024/5/1 23:12
 */
public class RobinMsg<M> {

    /**
     * 消息
     */
    private M msg;

    /**
     * 附加参数
     */
    private Map<String, Object> params;

    public RobinMsg(M msg, Map<String, Object> params) {
        this.msg = msg;
        this.params = params;
    }

    public RobinMsg<M> msg(M msg) {
        this.msg = msg;
        return this;
    }

    public RobinMsg<M> params(Map<String, Object> params) {
        this.params = params;
        return this;
    }

    public M getMsg() {
        return msg;
    }

    public RobinMsg<M> setMsg(M msg) {
        this.msg = msg;
        return this;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public RobinMsg<M> setParams(Map<String, Object> params) {
        this.params = params;
        return this;
    }

    public RobinMsg<M> addParam(String key, Object value) {
        if (params == null) {
            params = new HashMap<>();
        }
        params.put(key, value);
        return this;
    }
}
