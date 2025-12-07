package Model;

public class Member {
    private int memberId;
    private String memberName;
    private String memberPhone;

    public Member(int memberId, String memberName, String memberPhone) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberPhone = memberPhone;
    }

    public Member(String memberName, String memberPhone) {
        this.memberName = memberName;
        this.memberPhone = memberPhone;
    }

    public Member(String memberName) {
        this.memberName = memberName;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }
}


