package util;

/**
 *   创建 gson 实例, 单例模式
 *
 * @author xiangtch
 * @date 2019/7/17 1:08
 * @email xiangtch6@gmail.com
 */
public class GsonUtil {

    private static  GsonUtil gsonUtil;

    private GsonUtil(){

    }

    public GsonUtil getGsonUtil(){
        gsonUtil = new GsonUtil();
        return gsonUtil;
    }
}
