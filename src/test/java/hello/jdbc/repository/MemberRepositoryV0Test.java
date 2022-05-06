package hello.jdbc.repository;

import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Slf4j
class MemberRepositoryV0Test {

    MemberRepositoryV0 memberRepositoryV0 = new MemberRepositoryV0();


    @Test
    void crudTest() throws SQLException {

        // insert
        Member memberV0 = new Member("memberV0", 10000);
        memberRepositoryV0.save(memberV0);

        // select
        Member findMember = memberRepositoryV0.findById(memberV0.getMemberId());
        assertThat(memberV0).isEqualTo(findMember);

        // update
        memberRepositoryV0.update(20000, findMember.getMemberId());
        Member updateMember = memberRepositoryV0.findById(findMember.getMemberId());
        assertThat(updateMember.getMoney()).isEqualTo(20000);

        // delete
        memberRepositoryV0.delete(memberV0.getMemberId());
        assertThatThrownBy(() -> memberRepositoryV0.findById(memberV0.getMemberId()))
                .isInstanceOf(NoSuchElementException.class);
    }

}