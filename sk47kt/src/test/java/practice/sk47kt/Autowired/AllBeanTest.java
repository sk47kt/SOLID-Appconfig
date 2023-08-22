package practice.sk47kt.Autowired;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import practice.sk47kt.AutoAppconfig;
import practice.sk47kt.discount.DiscountPolicy;
import practice.sk47kt.discount.DiscountPolicyConfig;
import practice.sk47kt.member.Grade;
import practice.sk47kt.member.Member;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class AllBeanTest {

    @Test
    void findAllBean(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(DiscountPolicyConfig.class, DiscountService.class);

        DiscountService discountService = ac.getBean(DiscountService.class);
        Member userA = new Member(1L, "userA", Grade.VIP);
        int fixDiscountPolicy = discountService.discount(userA, 10000, "fixDiscountPolicy");

        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(fixDiscountPolicy).isEqualTo(1000);

        Member userB = new Member(1L, "userB", Grade.VIP);
        int rateDiscountPolicy = discountService.discount(userA, 20000, "rateDiscountPolicy");

        assertThat(rateDiscountPolicy).isEqualTo(2000);

    }

    static class DiscountService {
        private final Map<String,DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        @Autowired
        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = " + policies);
        }

        public int discount(Member userA, int price, String discountCode) {
            DiscountPolicy discountPolicy = policyMap.get(discountCode);
            return discountPolicy.discount(userA,price);

        }
    }
}
