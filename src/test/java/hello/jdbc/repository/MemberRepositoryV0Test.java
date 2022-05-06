package hello.jdbc.repository;

import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

@Slf4j
class MemberRepositoryV0Test {

    MemberRepositoryV0 memberRepositoryV0 = new MemberRepositoryV0();


    @Test
    void crudTest() throws SQLException {
        Member memberV0 = new Member("memberV0", 10000);
        memberRepositoryV0.save(memberV0);

        Member findMember = memberRepositoryV0.findById(memberV0.getMemberId());
        log.info("findMember -> {}", findMember);

        Assertions.assertThat(memberV0).isEqualTo(findMember);
    }

}