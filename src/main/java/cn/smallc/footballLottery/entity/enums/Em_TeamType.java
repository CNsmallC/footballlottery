package cn.smallc.footballLottery.entity.enums;

public enum Em_TeamType {
    NATIONAL_TEAM("国家队"),
    CLUB("俱乐部");

    private String value;

    Em_TeamType(String value){this.value = value;}

    public String getValue() {
        return this.value;
    }
}
