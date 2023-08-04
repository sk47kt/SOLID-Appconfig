package practice.sk47kt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import practice.sk47kt.discount.DiscountPolicy;
import practice.sk47kt.discount.FixDiscountPolicy;
import practice.sk47kt.discount.RateDiscountPolicy;
import practice.sk47kt.member.MemberRepository;
import practice.sk47kt.member.MemberService;
import practice.sk47kt.member.MemberServiceImpl;
import practice.sk47kt.member.MemoryMemberRepository;
import practice.sk47kt.order.OrderService;
import practice.sk47kt.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
    
}
