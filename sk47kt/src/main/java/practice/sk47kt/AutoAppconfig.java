package practice.sk47kt;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import practice.sk47kt.member.MemberRepository;
import practice.sk47kt.member.MemberServiceImpl;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Configuration.class),
        basePackages = "practice.sk47kt.member",
        basePackageClasses = AutoAppconfig.class
) //다른 예제코드 @Configuration 제외
public class AutoAppconfig{

}
