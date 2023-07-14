package practice.sk47kt.Order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;
import practice.sk47kt.AppConfig;
import practice.sk47kt.discount.FixDiscountPolicy;
import practice.sk47kt.member.*;
import practice.sk47kt.order.Order;
import practice.sk47kt.order.OrderService;
import practice.sk47kt.order.OrderServiceImpl;

public class OrderServiceTest {
    
    MemberService memberService;
    OrderService orderservice;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderservice = appConfig.orderService();
    }

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderservice.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
