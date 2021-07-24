package itravel.test;

import itravel.model.Data;
import itravel.model.DataFactory;
import itravel.model.Post;
import org.junit.Test;

import java.util.List;

/**
 * @author Hailian
 * @Poject name iTravel2020
 * @creat2020-11-16 9:05 AM
 */
public class PostTest {
    @Test
    public void test1(){

        Data data = DataFactory.getInstance();
        List<Post> postList = DataFactory.getInstance().getPostList();
        Post post = postList.get(postList.size() -1);
        System.out.println(post);

//        for(Post post : postList){
//            System.out.println(post);
//        }

        System.out.println(postList);
        //postList.add()

        //System.out.println(postList);
      // Post post = data.getPost("002");//这个确定是哪个
        //System.out.println(post);

//        System.out.println(post);
//        data.changePostActiveType(post);
//        System.out.println(post);
//        sendToClient(data, req, resp);
        //System.out.println(data.getWordFilterList());

    }
}
