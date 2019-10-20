package com.yaoln.usercenter.enums;

/**
 * @Auther: F~cjy
 * @Date: 2019/10/17 12:44
 */
public enum  AppTypeEnum {

    ONE(1, "one"),
    TWO(2, "two"),
    THREE(3, "three"),
    FOUR(4, "four"),
    FIVE(5, "five"),
    SIX(6, "six"),
    SEVEN(7, "seven"),
    EIGHT(8, "eight"),
    NINE(9, "nine"),
    TEN(10, "ten");

    /**
     * typeCode
     */
    private Integer typeCode;
    /**
     * 中文值
     */
    private String typeValue;

    public static String getValue(Integer typeCode) {
        for(AppTypeEnum obj : AppTypeEnum.values()){
            if (obj.getTypeCode().equals(typeCode)) {
                return obj.getTypeValue();
            }
        }
        return "";
    }

    public static AppTypeEnum[] getAllType(){
        return AppTypeEnum.values();
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

    AppTypeEnum(Integer typeCode, String typeValue) {
        this.typeCode = typeCode;
        this.typeValue = typeValue;
    }

}
