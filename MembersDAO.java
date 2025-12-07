package DAO;

import Model.Member;

import java.util.List;

public interface MembersDAO {

    public void addMember(Member member);

    public void updateMember(Member member);

    public void deleteMember(Member member);

    void deleteMemberByName(Member member);

    public List<Member> getAllMember();

    public List<Member> getMemberByName(Member memberName);

    public Member getMemberById(Member memberId);




}
