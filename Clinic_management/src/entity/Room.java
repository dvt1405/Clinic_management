package entity;

public class Room extends iEntity {
    private int id;
    private String name, type, clinicType;

    public Room() {}

    public Room(int id, String name, String type, String clinicType) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.clinicType = clinicType;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClinicType() {
        return clinicType;
    }

    public void setClinicType(String clinicType) {
        this.clinicType = clinicType;
    }
}
