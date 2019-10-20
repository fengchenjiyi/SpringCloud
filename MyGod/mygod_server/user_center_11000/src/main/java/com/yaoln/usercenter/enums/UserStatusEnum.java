package com.yaoln.usercenter.enums;

/**
 * @Auther: F~cjy
 * @Date: 2019/10/17 12:44
 */
public enum UserStatusEnum {

    NORMAL(1, "正常"),
    ABNORMAL(0, "异常");

    /**
     * typeCode
     */
    private Integer typeCode;
    /**
     * 中文值
     */
    private String typeValue;

    public static String getValue(Integer typeCode) {
        for(UserStatusEnum obj : UserStatusEnum.values()){
            if (obj.getTypeCode().equals(typeCode)) {
                return obj.getTypeValue();
            }
        }
        return "";
    }

    public static UserStatusEnum[] getAllType(){
        return UserStatusEnum.values();
    }

    public Integer getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(Integer typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue;
    }

    UserStatusEnum(Integer typeCode, String typeValue) {
        this.typeCode = typeCode;
        this.typeValue = typeValue;
    }

}
