package itravel.model;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DataFactory {
    private static Data instance;
    private  DataFactory(){}
    public static Data getInstance(){
        if(instance == null) {
            synchronized (Data.class) {
                if(instance == null) {
                    instance = new Data();
                    initUsersData();
                    init_PostsData();
                    initCommentsData();
                    initFollowsData();
                    initWordFiltersData();
                    initBooksData();
                    initPostsData();
                    initNotifyPost2UsersData();
                }
            }
        }
        return instance;
    }

    private static void initUsersData (){
        instance.getUserList().add(new User(true, "userId001", "user", "Guta Fida", "M", "IA", "Fairfield", "1000 N 4th", "52557", 1990, "user", "user"));
        instance.getUserList().add(new User(true, "userId002", "admin", "Guta Fida", "M", "IA", "Fairfield", "1000 N 4th", "52557", 1990, "admin", "admin"));

        instance.getUserList().add(new User("userId003", "user", "Guta Fida", "M", "IA", "Fairfield", "1000 N 4th", "52557", 1990, "gfida@mum.edu", "g"));
        instance.getUserList().add(new User("userId004", "user", "Yohannes Mulualem", "M", "IA", "Fairfield", "1000 N 4th", "52557", 1990, "ymulualem@miu.edu", "y"));
        instance.getUserList().add(new User("userId005", "user", "Eyob Weldeyohannes", "M", "IA", "Fairfield", "1000 N 4th", "52557", 1990, "eweldeyohannes@miu.edu", "e"));
        instance.getUserList().add(new User("userId006", "user", "Abrha Gebreslassie Berhe", "M", "IA", "Fairfield", "1000 N 4th", "52557", 1990, "aberhe@miu.edu", "a"));
        instance.getUserList().add(new User("userId007", "user", "Henok Abraham Haile", "M", "IA", "Fairfield", "1000 N 4th", "52557", 1990, "habraham@miu.edu", "h"));
        instance.getUserList().add(new User("userId008", "user", "Hailian Zhang", "M", "IA", "Fairfield", "1000 N 4th", "52557", 1990, "hzhang@miu.edu", "h"));
        instance.getUserList().add(new User("userId009", "user", "Dang Thu Ha Le", "M", "IA", "Fairfield", "1000 N 4th", "52557", 1990, "dthle@miu.edu", "d"));
        instance.getUserList().add(new User("userId010", "user", "Hailian Zhang", "M", "IA", "Fairfield", "1000 N 4th", "52557", 1990, "hzhang@miu.edu", "h"));
        instance.getUserList().add(new User("userId011", "user", "Hailian Zhang", "M", "IA", "Fairfield", "1000 N 4th", "52557", 1990, "hzhang@miu.edu", "h"));

        instance.getUserList().add(new User("userId012", "user", "Le Hieu Le", "M", "IA", "Fairfield", "1000 N 4th", "52557", 1990, "lle@mum.edu", "l"));
        // set active user/admin: using for present
        instance.getUserList().add(new User(true, "u111", "user", "Hailain", "F", "IA", "Fairfield", "1000 N 4th", "52557", 1990, "111", ""));
        instance.getUserList().add(new User(true, "a222", "admin", "Hieu Le", "M", "IA", "Fairfield", "1000 N 4th", "52557", 1990, "222", ""));
    }
    private static void initPostsData(){
//        String[] userId = new String[] {"1", "2", "000-11-0319", "000-11-0930", "000-11-0931","000-61-1519", "000-61-1699", "000-61-1775", "000-61-1525", "000-61-1785", "000-61-1795", "000-61-1635"};

        for (int i = 1; i <= 30; i++) {
            //String strUserID = String.valueOf(j);

            String strID = String.format("%d", i);
            String strUserID = String.format("userId%03d", i % 5);

            String strImage = String.format("Image %03d", i);
            String strTitle = String.format("Title %03d", i);
            String strContent = String.format("Content %03d", i);
            String strCategory = String.format("Category %03d", i);
            String strTags = String.format("Tags %03d", i);
            String strTime = LocalDate.of(2020, 11, i).toString();
            String strLocation = String.format("Location %03d", i);
            instance.getPostList().add(new Post(strID, strUserID, strImage, strTitle, strContent, strCategory, strTags, strTime, strLocation));
            int commentId = i;
            int likeId = i;

        }
    }


    private static void init_PostsData (){
//        for (int i = 1; i <= 30; i++)
//        {
//            String strID 	= String.format("%03d", i);
//            String strUserID= String.format("%03d", i % 5);
//            String strImage = String.format("Image %03d", i);
//            String strTitle = String.format("Title %03d", i);
//            String strContent = String.format("Content %03d", i);
//            String strCategory = String.format("Category %03d", i);
//            String strTags = String.format("Tags %03d", i);
//            String strTime = String.format("Time %03d", i);
//            String strLocation = String.format("Location %03d", i);
//
//            instance.get_PostList().add(new _Post(strID, strUserID, strImage, strTitle, strContent, strCategory, strTags, strTime, strLocation));
//        }
//        // Update more post base userID
    }

    private static void initCommentsData (){
        for (int i = 1; i <= 30; i++)
        {
            String strID 	= String.format("%d", i);
            String strPostID   = String.format("%d", i);
            String strUserID= String.format("userId%03d", i);
            String strContent = String.format("Content %03d", i);
            instance.getCommentList().add(new CommentPost(strID, strPostID, strUserID, strContent));
        }
    }

    private static void initFollowsData (){
        for (int i = 1; i <= 12; i++)
        {
            String strID 	= String.format("%d", i);
            String strTravellerID= String.format("userId%03d", i%3 + 1);
           // String strUserID= String.format("userId001");
           String strUserID= String.format("userId%03d", i);
            instance.getFollowList().add(new Follow(strID, strTravellerID, strUserID));
        }
    }

    private static void initNotifyPost2UsersData (){
        for (int i = 1; i <= 30; i++)
        {
            String strID 	= String.format("%d", i);
            String strPostID= String.format("%d", i%3 + 1);
            // String strUserID= String.format("userId001");
            String strUserID= String.format("userId%03d", i);
            instance.getNotifyPost2UserList().add(new NotifyPost2User(strID, strPostID, strUserID));
        }
    }

    private static void initWordFiltersData (){
        for (int i = 1; i <= 20; i++)
        {
            String strID    = String.format("%03d", i);
            String strValue = String.format("%03d", i);
            instance.getWordFilterList().add(new WordFilter(strID, strValue));
        }
        instance.getWordFilterList().add(new WordFilter("345", "^abc$"));
        instance.getWordFilterList().add(new WordFilter("345", "hello"));
        instance.getWordFilterList().add(new WordFilter("345", "^aaa"));
    }

    private static void initBooksData (){
        for (int i = 1; i <= 7; i++)
        {
            String strID 	= String.format("%03d", i);
            String strTitle = String.format("Title %03d", i);
            String strAuthor = String.format("Author %03d", i);
            String strSubject = String.format("Subject %03d", i);
            String strIsbn = String.format("ISBN%03d", i);
            instance.getBookList().add(new Book(strID, strTitle, strAuthor, strSubject, strIsbn));
        }
    }
}
