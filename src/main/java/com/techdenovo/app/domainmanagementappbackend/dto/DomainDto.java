package com.techdenovo.app.domainmanagementappbackend.dto;

public class DomainDto {
    private String domainName;

    private String tlds;

    public String getDomainName() {
        return domainName;
    }

    public String getTlds() {
        return tlds;
    }

    public void setTlds(String tlds) {
        this.tlds = tlds;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }
}
