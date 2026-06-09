package studio.thinkground.springbasic.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import studio.thinkground.springbasic.domain.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.ClearStore();
    }


    @Test
    public void save() {
        //given
        Member member = new Member();
        member.setName("test");

        //when
        repository.save(member);

        //then
        Member result = repository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }


    @Test
    public void findByName() {
        //given
        Member member1 = new Member();
        member1.setName("test1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("test2");
        repository.save(member2);

        //when
        Member result = repository.findByName("test1").get();

        //then
        assertThat(result).isEqualTo(member1);
    }


    @Test
    public void findAll() {
        //given
        Member member1 = new Member();
        member1.setName("test1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("test2");
        repository.save(member2);

        //when
        List<Member> result = repository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
    }


}
