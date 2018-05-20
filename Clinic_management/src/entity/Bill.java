package entity;

import java.sql.Timestamp;

public class Bill extends iEntity {
    private int id, nurseId, tblPatientProfileId;
    private float amount, amountPaid;
    private Timestamp payTime;

    public Bill() {}

    public Bill(int id, int nurseId, int tblPatientProfileId, float amount, float amountPaid, Timestamp payTime) {
        this.id = id;
        this.nurseId = nurseId;
        this.tblPatientProfileId = tblPatientProfileId;
        this.amount = amount;
        this.amountPaid = amountPaid;
        this.payTime = payTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNurseId() {
        return nurseId;
    }

    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }

    public int getTblPatientProfileId() {
        return tblPatientProfileId;
    }

    public void setTblPatientProfileId(int tblPatientProfileId) {
        this.tblPatientProfileId = tblPatientProfileId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(float amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Timestamp getPayTime() {
        return payTime;
    }

    public void setPayTime(Timestamp payTime) {
        this.payTime = payTime;
    }
}
