/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Dezeross
 */
public class DetailTesting extends iEntity {
    private int id;
    private String name;
    private Date examinationDate;
    private Date dob;

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
    private int quatity;
    private float amount;
    private String HeathInsurenceCardNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExaminationDate() {
        return examinationDate;
    }

    public void setExaminationDate(Date examinationDate) {
        this.examinationDate = examinationDate;
    }

    public int getQuatity() {
        return quatity;
    }

    public void setQuatity(int quatity) {
        this.quatity = quatity;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getHeathInsurenceCardNumber() {
        return HeathInsurenceCardNumber;
    }

    public void setHeathInsurenceCardNumber(String HeathInsurenceCardNumber) {
        this.HeathInsurenceCardNumber = HeathInsurenceCardNumber;
    }
}
