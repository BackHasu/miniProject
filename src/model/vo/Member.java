package model.vo;

public class Member {

	private String memberName;
	private String memberNumber;
	private int memberPoint;

	public Member() {
	}

	public Member(String memberName, String memberNumber) {
		this.memberName = memberName;
		this.memberNumber = memberNumber;
		this.memberPoint = 0;
	}

	public Member(String memberName, String memberNumber, int memberPoint) {
		this.memberName = memberName;
		this.memberNumber = memberNumber;
		this.memberPoint = memberPoint;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(String memberNumber) {
		this.memberNumber = memberNumber;
	}

	public int getMemberPoint() {
		return memberPoint;
	}

	public void setMemberPoint(int memberPoint) {
		this.memberPoint = memberPoint;
	}

	@Override
	public String toString() {
		return "memberName=" + memberName + ", memberNumber=" + memberNumber + ", memberPoint=" + memberPoint;
	}

}

/*
 * ���� �׷��Է��� �����ϴ� ��!
 * ���� �׷��Է��� �����ϴ� ��!
 * 
 * ������ ���� �� ������
 * �������� �� �� ���Ѵٰ� ���� ġ�鼭 ȭ���ٸ鼭��  ????? 
 * �ʼһ�~~~~~~
 * 
 * 
 * ��  �ľ��Ұſ��� ������ �̿��� ����j���ФФФФФ�
 * �߻�ƿ� ������~
 */
