package xmu.oomall.VO;

import xmu.oomall.dao.FootPrintItem;
import xmu.oomall.domain.Goods;
/**
 * admin端的 GET /footprints 请求VO
 */
public class FootPrintsItemVo {
    /**
     * 商品
     */

    private Goods goods;

    /**
     * 足迹
     */
    private FootPrintItem footPrintItem;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public FootPrintItem getFootPrintItem() {
        return footPrintItem;
    }

    public void setFootPrintItem(FootPrintItem footPrintItem) {
        this.footPrintItem = footPrintItem;
    }
}
