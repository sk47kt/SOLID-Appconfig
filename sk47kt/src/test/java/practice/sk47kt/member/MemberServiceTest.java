package practice.sk47kt.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.sk47kt.AppConfig;
import practice.sk47kt.order.OrderService;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();

    }
    @Test
    void join(){
        //given
        Member member = new Member(1L,"memberA", Grade.VIP);
        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //than
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
