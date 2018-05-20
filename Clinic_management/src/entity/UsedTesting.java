package entity;

public class UsedTesting extends iEntity {
    private int id, quantity, tblTestingDataId, tblPatientProfileId, isPaid;
    private float amount;
    private String testResults;

    public UsedTesting() {}

    public UsedTesting(int id, int quantity, int tblTestingDataId, int tblPatientProfileId, int isPaid, float amount, String testResults) {
        this.id = id;
        this.quantity = quantity;
        this.tblTestingDataId = tblTestingDataId;
        this.tblPatientProfileId = tblPatientProfileId;
        this.isPaid = isPaid;
        this.amount = amount;
        this.testResults = testResults;
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

    public int getTblTestingDataId() {
        return tblTestingDataId;
    }

    public void setTblTestingDataId(int tblTestingDataId) {
        this.tblTestingDataId = tblTestingDataId;
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

    public String getTestResults() {
        return testResults;
    }

    public void setTestResults(String testResults) {
        this.testResults = testResults;
    }
}
