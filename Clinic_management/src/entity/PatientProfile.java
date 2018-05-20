package entity;

import java.util.Date;

public class PatientProfile extends iEntity {
    private int id, doctorId, tblPatientId;
    private float examinationPrice;
    private Date examinationDate;
    private String clinicResults;

    public PatientProfile() {}

    public PatientProfile(int id, int doctorId, int tblPatientId, float examinationPrice, Date examinationDate, String clinicResults) {
        this.id = id;
        this.doctorId = doctorId;
        this.tblPatientId = tblPatientId;
        this.examinationPrice = examinationPrice;
        this.examinationDate = examinationDate;
        this.clinicResults = clinicResults;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getTblPatientId() {
        return tblPatientId;
    }

    public void setTblPatientId(int tblPatientId) {
        this.tblPatientId = tblPatientId;
    }

    public float getExaminationPrice() {
        return examinationPrice;
    }

    public void setExaminationPrice(float examinationPrice) {
        this.examinationPrice = examinationPrice;
    }

    public Date getExaminationDate() {
        return examinationDate;
    }

    public void setExaminationDate(Date examinationDate) {
        this.examinationDate = examinationDate;
    }

    public String getClinicResults() {
        return clinicResults;
    }

    public void setClinicResults(String clinicResults) {
        this.clinicResults = clinicResults;
    }
}
