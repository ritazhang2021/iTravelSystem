package itravel.model;

public class Post {
    private String id;
    private String userId;
    private String image;
    private String title;
    private String content;
    private String category;
    private String tags;
    private String time;
    private String location;
    //check Notification
    private boolean notification;

    private boolean likeStatus;
    private int countlike = 0;


    public int getCountLike() {
        return countlike;
    }

    public void setCountLike(int addCount) {
        this.countlike += addCount;
    }

    public boolean isLikeStatus() {
        return likeStatus;
    }

    public void setLikeStatus(boolean likeStatus) {
        this.likeStatus = likeStatus;
    }







    public boolean isNotification() {
        return notification;
    }

    public void setNotification(boolean notification) {
        this.notification = notification;
    }



    // Using for admin
    private boolean status; // active, deActive

    public Post() {
        this.id         = "";
        this.userId     = "";
        this.image      = "";
        this.title      = "";
        this.content    = "";
        this.category   = "";
        this.tags       = "";
        this.time       = "";
        this.location   = "";
        this.notification = false;
        // using for admin
        this.status     = true;
        this.likeStatus = false;
    }

    public Post(String id, String userId, String image, String title, String content, String category, String tags, String time, String location) {
        this.id         = id;
        this.userId     = userId;
        this.image      = image;
        this.title      = title;
        this.content    = content;
        this.category   = category;
        this.tags       = tags;
        this.time       = time;
        this.location   = location;
        this.notification = false;
        // using for admin
        this.status     = true;
        this.likeStatus = false;
    }

    public Post(Post post) {
        this.id         = post.id;
        this.userId     = post.userId;
        this.image      = post.image;
        this.title      = post.title;
        this.content    = post.content;
        this.category   = post.category;
        this.tags       = post.tags;
        this.time       = post.time;
        this.location   = post.location;
        this.notification = post.notification;
        // using for admin
        this.status     = post.status;
        this.likeStatus = post.likeStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", category='" + category + '\'' +
                ", tags='" + tags + '\'' +
                ", date='" + time + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
