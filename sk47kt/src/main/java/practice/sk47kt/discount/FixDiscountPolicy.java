package practice.sk47kt.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import practice.sk47kt.member.Grade;
import practice.sk47kt.member.Member;

@Component()
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
