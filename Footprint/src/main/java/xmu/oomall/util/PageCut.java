package xmu.oomall.util;

import java.util.List;

/**
 * @Author yijunL
 * @create 2019/12/13 13:30
 */
public class PageCut {

    public static List<? extends Object> pageCut(List<? extends Object> list,Integer page,Integer limit)   //输入总列表，页码，每页限制，返回该页内容（List）
    {
        int begin = (page - 1) * limit;
        int end = begin + limit;
        if (begin >= list.size()) {
            return null;
        }
        else if(list.size() < end) {
            return list.subList(begin,list.size());
        }
        else {
            return list.subList(begin, end);
        }
    }
}