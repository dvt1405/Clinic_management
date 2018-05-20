package entity;

public class TestingData extends iEntity {
    private int id, testingRoomId;
    private float price;
    private String name, description;

    public TestingData() {}

    public TestingData(int id, int testingRoomId, float price, String name, String description) {
        this.id = id;
        this.testingRoomId = testingRoomId;
        this.price = price;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTestingRoomId() {
        return testingRoomId;
    }

    public void setTestingRoomId(int testingRoomId) {
        this.testingRoomId = testingRoomId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}