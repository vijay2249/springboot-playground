package com.fia.f2.model;

import java.time.LocalDate;

public class ContractDetails {
    private String teamName;
    private String teamPrincipal;
    private LocalDate contractStartDate;
    private LocalDate contractEndDate;

//    public ContractDetails(){}

    public ContractDetails(String teamName, String teamPrincipal, LocalDate contractStartDate, LocalDate contractEndDate) {
        this.teamName = teamName;
        this.teamPrincipal = teamPrincipal;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
    }

    public String getTeamName() {return teamName;}

    public void setTeamName(String teamName) {this.teamName = teamName;}

    public String getTeamPrincipal() {return teamPrincipal;}

    public void setTeamPrincipal(String teamPrincipal) {this.teamPrincipal = teamPrincipal;}

    public LocalDate getContractStartDate() {return contractStartDate;}

    public void setContractStartDate(LocalDate contractStartDate) {this.contractStartDate = contractStartDate;}

    public LocalDate getContractEndDate() {return contractEndDate;}

    public void setContractEndDate(LocalDate contractEndDate) {this.contractEndDate = contractEndDate;}

    @Override
    public String toString() {
        return "ContractDetails{" +
                "teamName='" + teamName + '\'' +
                ", teamPrincipal='" + teamPrincipal + '\'' +
                ", contractStartDate=" + contractStartDate +
                ", contractEndDate=" + contractEndDate +
                '}';
    }
}
