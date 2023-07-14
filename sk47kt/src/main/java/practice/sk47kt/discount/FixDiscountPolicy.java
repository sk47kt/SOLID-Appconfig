package practice.sk47kt.discount;

import practice.sk47kt.member.Grade;
import practice.sk47kt.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount=1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP){
            return discountFixAmount;
        }
        else{
            return 0;
        }
    }
}
