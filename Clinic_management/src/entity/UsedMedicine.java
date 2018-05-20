package entity;

public class UsedMedicine extends iEntity {
    private int id, quantity, tblMedicineDataId, tblPatientProfileId, isPaid;
    private float amount;

    public UsedMedicine() {}

    public UsedMedicine(int id, int quantity, int tblMedicineDataId, int tblPatientProfileId, int isPaid, float amount) {
        this.id = id;
        this.quantity = quantity;
        this.tblMedicineDataId = tblMedicineDataId;
        this.tblPatientProfileId = tblPatientProfileId;
        this.isPaid = isPaid;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTblMedicineDataId() {
        return tblMedicineDataId;
    }

    public void setTblMedicineDataId(int tblMedicineDataId) {
        this.tblMedicineDataId = tblMedicineDataId;
    }

    public int getTblPatientProfileId() {
        return tblPatientProfileId;
    }

    public void setTblPatientProfileId(int tblPatientProfileId) {
        this.tblPatientProfileId = tblPatientProfileId;
    }

    public int getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(int isPaid) {
        this.isPaid = isPaid;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
