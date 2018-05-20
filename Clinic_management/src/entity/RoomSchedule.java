package entity;

import java.sql.Timestamp;

public class RoomSchedule extends iEntity {
    private int id, tblUserId, tblRoomId;
    private Timestamp startTime, endTime;

    public RoomSchedule() {}

    public RoomSchedule(int id, int tblUserId, int tblRoomId, Timestamp startTime, Timestamp endTime) {
        this.id = id;
        this.tblUserId = tblUserId;
        this.tblRoomId = tblRoomId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTblUserId() {
        return tblUserId;
    }

    public void setTblUserId(int tblUserId) {
        this.tblUserId = tblUserId;
    }

    public int getTblRoomId() {
        return tblRoomId;
    }

    public void setTblRoomId(int tblRoomId) {
        this.tblRoomId = tblRoomId;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }
}
