package xmu.oomall.dao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.BeSharedItem;
import xmu.oomall.domain.ShareItem;
import xmu.oomall.domain.ShareRulePo;
import xmu.oomall.mapper.OomallShareItemMapper;
import xmu.oomall.mapper.OomallShareRuleMapper;


import java.math.BigDecimal;
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


    /**
     * 被分享表按时间排序

     */

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

    /**
     * 分享表按时间排序

     */

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


    /**
     * 计算具体返点

     */

    public Integer  Calculate(Integer sucessnum, BigDecimal price,Integer validnum,int[] lowerbound,int[] upperbound,double[] rate)
    {

        int piece=validnum;//对应successnum每次增加件数
        if(sucessnum<lowerbound[0])
            return 0;

        for(int i=0;i<lowerbound.length;i++)
        {
            if(sucessnum>=lowerbound[i]*100&&sucessnum<=upperbound[i]*100)
            {
                System.out.println(3);
            if(sucessnum-piece<upperbound[i]*100)
            {
                double newRate=rate[i];
                if(i>=1)
                {
                    newRate=rate[i]-rate[i-1];
                }
            return Integer.valueOf((price.multiply(new BigDecimal(100)).multiply(new BigDecimal(newRate)))
                    .setScale(0, BigDecimal.ROUND_HALF_UP).toString());}
            else return 0;}
        }

        if(sucessnum>upperbound[upperbound.length-1]*100) {
            ShareItem shareItem=new ShareItem();
            shareItem.getId();
            shareItem.setGmtModified(LocalDateTime.now());
            shareItemMapper.deleteById(shareItem.getId(),shareItem);
        return 0;
    }
        return 0;
    }

    /**
     * 更新successnum并计算返点

     */

    public Integer updateShareItemSuccessNumAndCalculate(List<BeSharedItem> beSharedItemList,BigDecimal price) {

        ListSort2(beSharedItemList);
        Integer rebate = 0;

        //获取分享规则

        ShareRulePo shareRulePo=shareRuleMapper.findByGoodsId(beSharedItemList.get(0).getGoodsId());
        String strategyLevel=shareRulePo.getShareLevelStrategy();
        JSONObject jsonObject = JSONObject.fromObject(strategyLevel);
        int type= jsonObject.getInt("type");
        JSONArray strategys = jsonObject.getJSONArray("strategy");
        int[] lowerbound=new int[strategys.size()];
        int[] upperbound=new int[strategys.size()];
        double[] rate=new double[strategys.size()];
        for(int i=0;i<strategys.size();i++)
        {
            JSONObject strategy = strategys.getJSONObject(i);
            lowerbound[i] = strategy.getInt("lowerbound");
            upperbound[i] = strategy.getInt("upperbound");
            rate[i]=strategy.getDouble("rate");
        }

        for(BeSharedItem beSharedItem:beSharedItemList)//同一商品，不同的人
        {

            List<ShareItem> shareItemList=shareItemMapper.findByGoodsIdAndUserId(beSharedItem.getGoodsId(),beSharedItem.getSharerId());
            ListSort(shareItemList);
            if(type==0) {                //返点方法1
                ShareItem validShareItem = new ShareItem();
                for (ShareItem shareItem : shareItemList) {
                    if (shareItem.getBeDeleted() == false)
                    { validShareItem = shareItem;break;}
                }
                if (validShareItem == null) {    //生成分享表
                    ShareItem shareItem = new ShareItem();
                    shareItem.setGoodsId(beSharedItem.getGoodsId());
                    shareItem.setSuccessNum(1);
                    shareItem.setUserId(beSharedItem.getSharerId());
                    shareItem.setGmtCreate(LocalDateTime.now());
                    shareItem.setGmtModified(LocalDateTime.now());
                    shareItemMapper.insertSelective(shareItem);
                } else if (validShareItem != null) {
                    validShareItem.setGmtModified(LocalDateTime.now());
                    validShareItem.setSuccessNum(validShareItem.getSuccessNum() + 100);
                    shareItemMapper.updateById(validShareItem, validShareItem.getId());
                }
               rebate= Calculate(validShareItem.getSuccessNum() + 100,price,100,lowerbound,upperbound,rate);

                break;
            }
            else if(type==1){   //返点方法2
                ShareItem validShareItem = new ShareItem();
                Integer validnum=0;
                if(beSharedItemList.size()>=100)
                validnum=1;
                else
                    validnum=1/beSharedItemList.size()*100;
                for (ShareItem shareItem : shareItemList) {
                    if (shareItem.getBeDeleted() == false)
                    {  validShareItem = shareItem;break; }
                }
                if (validShareItem == null) {    //生成分项表
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
                Integer rebate2=0;
                rebate2= Calculate(validShareItem.getSuccessNum() + validnum,price,validnum,lowerbound,upperbound,rate);
                if(rebate2!=0)
                    rebate=rebate2;
            }


        }
        return rebate;
    }


}
