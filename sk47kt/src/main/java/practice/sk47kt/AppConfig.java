package practice.sk47kt;

import practice.sk47kt.discount.DiscountPolicy;
import practice.sk47kt.discount.FixDiscountPolicy;
import practice.sk47kt.member.MemberService;
import practice.sk47kt.member.MemberServiceImpl;
import practice.sk47kt.member.MemoryMemberRepository;
import practice.sk47kt.order.OrderService;
import practice.sk47kt.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
    
}
