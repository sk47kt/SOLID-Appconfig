package practice.sk47kt.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.sk47kt.member.Grade;
import practice.sk47kt.member.Member;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 는 10% 할인이 적용")
    void vip_o(){
        Member vip = new Member(1L, "VIP", Grade.VIP);
        int discount = discountPolicy.discount(vip , 10000);
        assertThat(discount).isEqualTo(1000);

    }

    @Test
    @DisplayName("VIP 가 아니면 할인적용X")
    void vip_x(){
        Member basic = new Member(1L, "BASIC", Grade.BASIC);
        int discount = discountPolicy.discount(basic,10000);
        assertThat(discount).isEqualTo(0 );
    }
}