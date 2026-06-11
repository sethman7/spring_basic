package studio.thinkground.springbasic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import studio.thinkground.springbasic.repository.MemberRepository;
import studio.thinkground.springbasic.repository.MemoryMemberRepository;
import studio.thinkground.springbasic.service.MemberService;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
