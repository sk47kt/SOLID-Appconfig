package practice.sk47kt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import practice.sk47kt.discount.FixDiscountPolicy;
import practice.sk47kt.member.*;
import practice.sk47kt.order.Order;
import practice.sk47kt.order.OrderService;
import practice.sk47kt.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        /*AppConfig appconfig = new AppConfig();
        MemberService memberService = appconfig.memberService();
        OrderService orderService = appconfig.orderService();
*/
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order cal = " + order.calculatePrice());
    }
}
