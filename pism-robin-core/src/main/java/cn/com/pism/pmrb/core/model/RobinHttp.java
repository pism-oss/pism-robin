package cn.com.pism.pmrb.core.model;

/**
 * http 客户端
 *
 * @author perccyking
 * @since 2024/5/5 10:00
 */
public interface RobinHttp {

    /**
     * <p>
     * 发送post请求
     * </p>
     * by PerccyKing
     *
     * @param url  : 请求地址
     * @param json : json
     * @since 2024/5/5 10:26
     */
    void doPost(String url, String json);
}
