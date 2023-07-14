package practice.sk47kt.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
