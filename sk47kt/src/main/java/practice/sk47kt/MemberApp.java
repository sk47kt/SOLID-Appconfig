package practice.sk47kt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import practice.sk47kt.member.*;
import practice.sk47kt.order.OrderService;

public class MemberApp {

    public static void main(String[] args) {

        /*AppConfig appconfig = new AppConfig();
        MemberService memberService = appconfig.memberService();*/

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member =  " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
