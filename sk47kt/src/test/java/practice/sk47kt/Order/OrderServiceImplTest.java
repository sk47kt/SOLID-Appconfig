package practice.sk47kt.Order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import practice.sk47kt.AutoAppconfig;
import practice.sk47kt.discount.FixDiscountPolicy;
import practice.sk47kt.member.Grade;
import practice.sk47kt.member.Member;
import practice.sk47kt.member.MemoryMemberRepository;
import practice.sk47kt.order.Order;
import practice.sk47kt.order.OrderServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {


    @Test
    void createOrder() {
        MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
        memoryMemberRepository.save(new Member(1L,"name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memoryMemberRepository , new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}