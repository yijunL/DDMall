package xmu.oomall.VO;
import xmu.oomall.domain.Coupon;
import xmu.oomall.domain.CouponRule;


public class CouponVo {

    /**
     * 优惠劵规则信息
     */
    private Coupon coupon;

    /**
     * 单张优惠劵信息
     */
    private CouponRule couponRule;

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public CouponRule getCouponRule() {
        return couponRule;
    }

    public void setCouponRule(CouponRule couponRule) {
        this.couponRule = couponRule;
    }
}
