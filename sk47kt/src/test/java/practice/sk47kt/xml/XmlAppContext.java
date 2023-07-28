package practice.sk47kt.xml;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import practice.sk47kt.member.MemberService;
import practice.sk47kt.member.MemberServiceImpl;

import java.lang.reflect.GenericArrayType;

import static org.assertj.core.api.Assertions.*;

public class XmlAppContext {

    @Test
    void xmlAppContext(){
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        MemberService bean = ac.getBean("memberService", MemberService.class);
        assertThat(bean).isInstanceOf(MemberServiceImpl.class);
    }
}
