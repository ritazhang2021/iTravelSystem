package itravel.model;

import java.util.List;

public class NotifyPost2User {
    private String id;
    private String postId;
    private String userId;
    private boolean isRead;

    public NotifyPost2User() {
        this.id     = "";
        this.postId = "";
        this.userId = "";
        this.isRead = false;
    }

    public NotifyPost2User(String id, String postId, String userId) {
        this.id     = id;
        this.postId = postId;
        this.userId = userId;
        this.isRead = false;
    }

    public NotifyPost2User(NotifyPost2User newItem) {
        this.id     = newItem.id;
        this.postId = newItem.postId;
        this.userId = newItem.userId;
        this.isRead = newItem.isRead;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
