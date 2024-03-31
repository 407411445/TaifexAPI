package com.youzhan.tailfex.model;

import javax.persistence.*;

@Entity
@Table(name="TAIFEX")
public class Taifex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USD_NTD")
    private double usd2ntd;

    @Column(name = "RMB_NTD")
    private double rmb2ntd;

    @Column(name = "USD_RMB")
    private double usd2rmb;

    @Column(name = "UPDATETIME")
    private String datetime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getUsd2ntd() {
        return usd2ntd;
    }

    public void setUsd2ntd(double usd2ntd) {
        this.usd2ntd = usd2ntd;
    }

    public double getRmb2ntd() {
        return rmb2ntd;
    }

    public void setRmb2ntd(double rmb2ntd) {
        this.rmb2ntd = rmb2ntd;
    }

    public double getUsd2rmb() {
        return usd2rmb;
    }

    public void setUsd2rmb(double usd2rmb) {
        this.usd2rmb = usd2rmb;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
