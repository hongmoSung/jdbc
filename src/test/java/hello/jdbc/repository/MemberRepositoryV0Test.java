package hello.jdbc.repository;

import hello.jdbc.domain.Member;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class MemberRepositoryV0Test {

    MemberRepositoryV0 memberRepositoryV0 = new MemberRepositoryV0();


    @Test
    void saveMember() throws SQLException {
        Member memberV0 = new Member("memberV0", 10000);
        memberRepositoryV0.save(memberV0);
    }

}