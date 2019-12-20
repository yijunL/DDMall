package xmu.oomall.dao;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.BeSharedItem;
import xmu.oomall.domain.ShareItem;
import xmu.oomall.domain.ShareRulePo;
import xmu.oomall.mapper.OomallShareItemMapper;
import xmu.oomall.mapper.OomallShareRuleMapper;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Repository
public class ShareItemDao {

    @Autowired
    private OomallShareItemMapper shareItemMapper;
    @Autowired
    private OomallShareRuleMapper shareRuleMapper;

    public static void ListSort2(List<BeSharedItem> list)
    {
        Collections.sort(list, new Comparator<BeSharedItem>() {
            @Override
            public int compare(BeSharedItem beSharedItem1, BeSharedItem beSharedItem2) {
                try {
                    if (beSharedItem1.getBirthTime().isBefore(beSharedItem2.getBirthTime())) {
                        return 1;
                    } else if (beSharedItem1.getBirthTime().isAfter(beSharedItem2.getBirthTime())) {
                        return -1;
                    } else {
                        return 0;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return 0;
            }
        });
    }

    public static void ListSort(List<ShareItem> list)
    {
        Collections.sort(list, new Comparator<ShareItem>() {
            @Override
            public int compare(ShareItem beSharedItem1, ShareItem beSharedItem2) {
                try {
                    if (beSharedItem1.getGmtCreate().isBefore(beSharedItem2.getGmtCreate())) {
                        return 1;
                    } else if (beSharedItem1.getGmtCreate().isAfter(beSharedItem2.getGmtCreate())) {
                        return -1;
                    } else {
                        return 0;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return 0;
            }
        });
    }

    public int Calculate(Integer sucessnum,Integer low,Integer up)
    {

        return 0;
    }

    public Integer updateShareItemSuccessNumAndCalculate(List<BeSharedItem> beSharedItemList) {
        ListSort2(beSharedItemList);
        for(BeSharedItem beSharedItem:beSharedItemList)//同一商品，不同的人
        {
            ShareRulePo shareRulePo=shareRuleMapper.findByGoodsId(beSharedItem.getGoodsId());
            String strategy=shareRulePo.getShareLevelStrategy();
           /* JSONObject jsonObject = JSONObject.fromObject(strategy);
            jsonObject.get("type");
            JSONArray jsonArray=new JSONArray(Collections.singletonList(strategy));
            JSONArray jsonobj = new JSONArray();
            jsonArray = jsonobj.getJSONArray(Integer.parseInt("strategy"));//获取数组
            jsonArray.getJSONObject(0).get("lowerbound");
            jsonArray.getJSONObject(0).get("upperbound");
            jsonArray.getJSONObject(0).get("rate");

            */
           Integer lowerbound=100;
           Integer upperbound=1000;
           double rate=0.8;
           int type=0;

            List<ShareItem> shareItemList=shareItemMapper.findByGoodsIdAndUserId(beSharedItem.getGoodsId(),beSharedItem.getSharerId());
            ListSort(shareItemList);
            if(type==0) {
                ShareItem validShareItem = new ShareItem();
                for (ShareItem shareItem : shareItemList) {
                    if (shareItem.getBeDeleted() == false)
                    { validShareItem = shareItem;break;}
                }
                if (validShareItem == null) {
                    ShareItem shareItem = new ShareItem();
                    shareItem.setGoodsId(beSharedItem.getGoodsId());
                    shareItem.setSuccessNum(1);
                    shareItem.setUserId(beSharedItem.getSharerId());
                    shareItem.setGmtCreate(LocalDateTime.now());
                    shareItem.setGmtModified(LocalDateTime.now());
                    shareItemMapper.insertSelective(shareItem);
                } else if (validShareItem != null) {
                    validShareItem.setGmtModified(LocalDateTime.now());
                    validShareItem.setSuccessNum(validShareItem.getSuccessNum() + 1);
                    shareItemMapper.updateById(validShareItem, validShareItem.getId());
                }
                break;
            }
            else if(type==1){
                ShareItem validShareItem = new ShareItem();
                Integer validnum=1/beSharedItemList.size();
                for (ShareItem shareItem : shareItemList) {
                    if (shareItem.getBeDeleted() == false)
                    {  validShareItem = shareItem;break; }
                }
                if (validShareItem == null) {
                    ShareItem shareItem = new ShareItem();
                    shareItem.setGoodsId(beSharedItem.getGoodsId());
                    shareItem.setSuccessNum(validnum);
                    shareItem.setUserId(beSharedItem.getSharerId());
                    shareItem.setGmtCreate(LocalDateTime.now());
                    shareItem.setGmtModified(LocalDateTime.now());
                    shareItemMapper.insertSelective(shareItem);
                } else if (validShareItem!= null) {


                    validShareItem.setGmtModified(LocalDateTime.now());
                    validShareItem.setSuccessNum(validShareItem.getSuccessNum() +validnum );
                    shareItemMapper.updateById(validShareItem, validShareItem.getId());

                }
            }

        }
        return 0;
    }


}
