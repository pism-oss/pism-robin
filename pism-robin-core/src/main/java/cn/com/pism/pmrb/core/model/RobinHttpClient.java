package cn.com.pism.pmrb.core.model;

import cn.hutool.http.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author perccyking
 * @since 2024/5/5 10:17
 */
public class RobinHttpClient implements RobinHttp {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void doPost(String url, String json) {
        String res = HttpUtil.post(url, json);
        if (logger.isInfoEnabled()) {
            logger.info("doPost res:{}", res);
        }
    }

}
