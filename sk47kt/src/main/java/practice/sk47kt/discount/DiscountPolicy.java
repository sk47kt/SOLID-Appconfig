package practice.sk47kt.discount;

import practice.sk47kt.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);

}
