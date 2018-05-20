package entity;

import java.util.Date;

public class Patient extends iEntity {
    private int id;
    private Date dob;
    private String fullName, gender, address, healthInsuranceCardNumber, indentityCardNumber;

    public Patient() {}

    public Patient(int id, Date dob, String fullName, String gender, String address, String healthInsuranceCardNumber, String indentityCardNumber) {
        this.id = id;
        this.dob = dob;
        this.fullName = fullName;
        this.gender = gender;
        this.address = address;
        this.healthInsuranceCardNumber = healthInsuranceCardNumber;
        this.indentityCardNumber = indentityCardNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHealthInsuranceCardNumber() {
        return healthInsuranceCardNumber;
    }

    public void setHealthInsuranceCardNumber(String healthInsuranceCardNumber) {
        this.healthInsuranceCardNumber = healthInsuranceCardNumber;
    }

    public String getIndentityCardNumber() {
        return indentityCardNumber;
    }

    public void setIndentityCardNumber(String indentityCardNumber) {
        this.indentityCardNumber = indentityCardNumber;
    }
}
