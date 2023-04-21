package com.majorProject.model;

public class CounterDTO {

    private String counterExecutiveName;
    private String password;
    private int serviceTypeId;

    public String getCounterExecutiveName() {
        return counterExecutiveName;
    }

    public void setCounterExecutiveName(String counterExecutiveName) {
        this.counterExecutiveName = counterExecutiveName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(int serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

}
