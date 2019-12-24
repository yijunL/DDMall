package xmu.oomall.util;

import java.util.List;

/**
 * @Author lyj
 * @Description: PageCut
 * @create 2019/12/16 20:49
 */
public class PageCut {

    public static List<? extends Object> pageCut(List<? extends Object> list,Integer page,Integer limit)   //输入总列表，页码，每页限制，返回该页内容（List）
    {
        int begin=(page-1)*limit;
        int end=begin+limit;
        if(begin>=list.size()) {
            return null;
        }
        //处于最后一页时
        else if(list.size()<end) {
            return list.subList(begin, list.size());
        }
        else {
            return list.subList(begin, end);
        }
    }
}