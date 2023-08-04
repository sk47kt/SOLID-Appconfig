package practice.sk47kt.order;

import practice.sk47kt.discount.DiscountPolicy;
import practice.sk47kt.discount.FixDiscountPolicy;
import practice.sk47kt.discount.RateDiscountPolicy;
import practice.sk47kt.member.Member;
import practice.sk47kt.member.MemberRepository;
import practice.sk47kt.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }

    //테스트용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}

