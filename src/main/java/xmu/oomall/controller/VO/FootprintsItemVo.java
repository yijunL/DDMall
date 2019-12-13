package xmu.oomall.controller.VO;

import xmu.oomall.domain.FootprintItem;
import xmu.oomall.domain.Goods;
/**
 * admin端的 GET /footprints 请求VO
 */
public class FootprintsItemVo {
    /**
     * 商品
     */

    private Goods goods;

    /**
     * 足迹
     */
    private FootprintItem footPrintItem;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public FootprintItem getFootPrintItem() {
        return footPrintItem;
    }

    public void setFootprintItem(FootprintItem footPrintItem) {
        this.footPrintItem = footPrintItem;
    }
}
