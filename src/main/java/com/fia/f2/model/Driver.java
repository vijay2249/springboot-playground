package com.fia.f2.model;

import java.util.List;

public class Driver {
    private String driverName;
    private String teamName;
    private long driverNo;
    private String teamPrincipal;
    private boolean isRetired;
    private List<ContractDetails> career;
    private String id;

//    public Driver(){}

    public Driver(String driverName, String teamName, long driverNo, String teamPrincipal, boolean isRetired, List<ContractDetails> career, String id) {
        this.driverName = driverName;
        this.teamName = teamName;
        this.driverNo = driverNo;
        this.teamPrincipal = teamPrincipal;
        this.isRetired = isRetired;
        this.career = career;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDriverName() {return driverName;}

    public void setDriverName(String driverName) {this.driverName = driverName;}

    public String getTeamName() {return teamName;}

    public void setTeamName(String teamName) {this.teamName = teamName;}

    public long getDriverNo() {return driverNo;}

    public void setDriverNo(long driverNo) {this.driverNo = driverNo;}

    public String getTeamPrincipal() {return teamPrincipal;}

    public void setTeamPrincipal(String teamPrincipal) {this.teamPrincipal = teamPrincipal;}

    public boolean isRetired() {return isRetired;}

    public void setRetired(boolean retired) {isRetired = retired;}

    public List<ContractDetails> getCareer() {return career;}

    public void setCareer(List<ContractDetails> career) {this.career = career;}

    @Override
    public String toString() {
        return "Driver{" +
                "driverName='" + driverName + '\'' +
                ", teamName='" + teamName + '\'' +
                ", driverNo=" + driverNo +
                ", teamPrincipal='" + teamPrincipal + '\'' +
                ", isRetired=" + isRetired +
                ", career=" + career +
                ", id='" + id + '\'' +
                '}';
    }
}
