package itravel.model;

import java.util.ArrayList;
import java.util.List;

public class Follow {
    private String id;
    private String travellerId;
    private String userId;

    public Follow() {
        this.id             = "";
        this.travellerId    = "";
        this.userId         = "";
    }

    public Follow(String id, String travellerId, String userId) {
        this.id             = id;
        this.travellerId    = travellerId;
        this.userId         = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTravellerId() {
        return travellerId;
    }

    public void setTravellerId(String travellerId) {
        this.travellerId = travellerId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Traveler{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", travelerId='" + travellerId + '\'' +
                '}';
    }
}
