package cn.com.pism.pmrb.wechat.work.msg;

import cn.com.pism.pmrb.wechat.work.msg.enums.WechatWorkMsgTypeEnum;

/**
 * @author perccyking
 * @since 2024/5/1 23:31
 */
public abstract class WechatWorkMsg {

    public static final String WECHAT_WORK_MSG = "{\"msgtype\": \"%s\",\"%s\": %s}";

    public static final String AT_ALL = "@all";

    public static final String STR = "\"%s\"";

    private WechatWorkMsgTypeEnum msgType;

    protected WechatWorkMsg() {
    }

    protected WechatWorkMsg(WechatWorkMsgTypeEnum msgType) {
        this.msgType = msgType;
    }

    public WechatWorkMsgTypeEnum getMsgType() {
        return msgType;
    }

    protected abstract String getMsgContent();

    @Override
    public String toString() {
        return String.format(WECHAT_WORK_MSG, msgType.getType(), msgType.getType(), getMsgContent());
    }
}
