package practice.sk47kt.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Testconfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        int userA=statefulService1.order("userA",10000); // A 사용자 10000 원 주문
        int userB=statefulService2.order("userB",20000); // B 사용자 20000 원 주문

        //int price = statefulService1.getPrice(); // 사용자A 주문금액 조회 내부 this.price 이슈

        //Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
        assertThat(userA).isNotSameAs(userB);
    }

    static class Testconfig {
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}