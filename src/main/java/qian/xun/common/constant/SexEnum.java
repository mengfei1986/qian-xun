// Generated by the lark-cli v0.8.  DO NOT EDIT!
// Changes to this file may cause incorrect behavior and will be lost if the code is regenerated.
package qian.xun.common.constant;


import qian.xun.common.constant.abstarct.EnumDisplayNameSupport;
import qian.xun.common.constant.abstarct.EnumValueSupport;
import qian.xun.common.constant.abstarct.Enums;

/**
 *
 */
public enum SexEnum implements EnumValueSupport, EnumDisplayNameSupport {
    /**
     * 男
     */
    MAN(1, "男"),
    /**
     * 女
     */
    WOMAN(2, "女");

    private int value;
    private String displayName;

    private SexEnum(int value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    /**
     * 获取枚举的 int 值,用于数据保存以及序列化
     *
     * @return 枚举的 int 值
     */

    public int value() {
        return this.value;
    }

    /**
     * 获取枚举的显示名称
     *
     * @return 枚举的显示名称
     */

    public String displayName() {
        return this.displayName;
    }
    
    /**
     * 根据 int 值构建一个枚举对象
     *
     * @param value 需要构建枚举的 int 的值
     * @return 返回相应 value 值的枚举对象
     */
    public static SexEnum valueOf(int value) {
        return Enums.valueOf(SexEnum.class, value);
    }
}
