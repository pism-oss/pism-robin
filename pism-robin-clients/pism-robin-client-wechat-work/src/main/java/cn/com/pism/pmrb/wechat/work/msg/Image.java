package cn.com.pism.pmrb.wechat.work.msg;

import cn.com.pism.pmrb.core.util.ImageUtil;
import cn.com.pism.pmrb.core.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

import static cn.com.pism.pmrb.wechat.work.msg.enums.WechatWorkMsgTypeEnum.IMAGE;

/**
 * @author perccyking
 * @since 2024/5/5 12:38
 */
public class Image extends WechatWorkMsg {

    protected final Logger logger = LoggerFactory.getLogger(getClass());


    private static final String IMAGE_MSG = "{\"base64\":\"%s\",\"md5\":\"%s\"}";

    public Image() {
        super(IMAGE);
    }

    public static Image instance() {
        return new Image();
    }

    /**
     * 文件，直接使用file，会自动计算base64 和md5 可以不再单独设置
     */
    private File file;

    /**
     * <p>图片内容的base64编码，优先级高于file</p>
     * 必填：是
     */
    private String base64;

    /**
     * <p>图片内容（base64编码前）的md5值，优先级高于file</p>
     * 必填：是
     */
    private String md5;

    public Image file(File file) {
        this.file = file;
        return this;
    }

    public Image base64(String base64) {
        this.base64 = base64;
        return this;
    }

    public Image md5(String md5) {
        this.md5 = md5;
        return this;
    }

    @Override
    public String getMsgContent() {
        if (StringUtil.isNotBlank(base64) && StringUtil.isNotBlank(md5)) {
            return String.format(IMAGE_MSG, base64, md5);
        }
        if (file != null) {
            return String.format(IMAGE_MSG, ImageUtil.base64(file), ImageUtil.md5(file));
        }
        return String.format(IMAGE_MSG, "", "");
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }
}
