package itravel.model;

public class CommentPost {
    private String id;
    private String postId;
    private String userId;
    private String content;

    public CommentPost() {
        this.id         = "";
        this.postId     = "";
        this.userId     = "";
        this.content    = "";
    }

    public CommentPost(String id, String postId, String userId, String content) {
        this.id         = id;
        this.postId     = postId;
        this.userId     = userId;
        this.content    = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
