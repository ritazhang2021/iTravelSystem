package itravel.test;

import itravel.model.Data;
import itravel.model.DataFactory;
import itravel.model.Page;
import itravel.model.WordFilter;
import org.junit.Test;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.List;

/**
 * @author Hailian
 * @Poject name iTravel2020
 * @creat2020-11-16 5:31 PM
 */
public class FilterWordsTest {

    @Test
    public void test1(){
        Data data = DataFactory.getInstance();
        Page<WordFilter> filterPage = data.getwordFilterPage();
        //List<WordFilter>list = data.getWordFilterList();
        //list.subList(filterPage.getPageNo(),filterPage.getPageSize());
        Page<WordFilter> page = data.filterWordsPage(filterPage.getPageNo(),filterPage.getPageSize());
        System.out.println(page.getItems());
        List<WordFilter> wordFilterListlist = data.getWordFilterList();
        for(WordFilter wordFilter: wordFilterListlist){
            System.out.println(wordFilter.getValue());
        }


    }
}
