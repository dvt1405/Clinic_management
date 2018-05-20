package entity;

import java.sql.Timestamp;

public class RoomQueue extends iEntity {
    private int id, tblRoomId, tblPatientId;
    private Timestamp registerTime;

    public RoomQueue() {}

    public RoomQueue(int id, int tblRoomId, int tblPatientId, Timestamp registerTime) {
        this.id = id;
        this.tblRoomId = tblRoomId;
        this.tblPatientId = tblPatientId;
        this.registerTime = registerTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTblRoomId() {
        return tblRoomId;
    }

    public void setTblRoomId(int tblRoomId) {
        this.tblRoomId = tblRoomId;
    }

    public int getTblPatientId() {
        return tblPatientId;
    }

    public void setTblPatientId(int tblPatientId) {
        this.tblPatientId = tblPatientId;
    }

    public Timestamp getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Timestamp registerTime) {
        this.registerTime = registerTime;
    }
}
