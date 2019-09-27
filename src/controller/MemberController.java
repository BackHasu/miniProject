package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import model.vo.Member;

public class MemberController {
   private ArrayList<Member> memberList = new ArrayList<>();// <Member>��ü�� ���� �� �ִ� ��� ����Ʈ ����
   private static final MemberController MEMBER_CONTROLLER = new MemberController();
   private MemberController() {
      memberInit("./src/memberTextFiles/member.txt", memberList);
   }

   private void memberInit(String address, ArrayList<Member> memberList) {
      try(BufferedReader memberBufferedReader 
            = new BufferedReader(new FileReader(new File(address)));)
      {
         // �ؽ�Ʈ���Ͽ� �Էµ� ������ �ӽ÷� ������ ���� ����
         String memberName;
         String memberNumber;
         String memberPoint;
         //����,"01000000000",30000 �������� �ؽ�Ʈ ���� ���������
         while ((memberName = memberBufferedReader.readLine()) != null) {
            String[] spt = memberName.split(",");
            memberName = spt[0];
            memberNumber = spt[1];
            memberPoint = spt[2];
            memberList.add(new Member(memberName, memberNumber, Integer.parseInt(memberPoint)));
         }//','�� �������� split�ؼ� ������ Name, Number, Point�� ����

      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public ArrayList<Member> getMemberList() {
      return memberList;
   }

   ////////////////////////////////////////����Ʈ ����/////////////////////////////////////////////
   public void sendSavingMethod(Member m, int totalAmount) {
      int i = memberCheck(m.getMemberNumber());
      if (i==-1) {
         newPointSaving(m, totalAmount);
         System.out.println("�ű�ȸ�� �޼ҵ� ����");
      } else {
         visitedPointSaving(i, totalAmount);
         System.out.println("����ȸ�� �޼ҵ� ����");
      }
   }

   public int memberCheck(String number) {// ����ȸ������ �ű�ȸ������ �Ǻ��ϴ� �޼ҵ� 
                                 // ����ȸ���̸� ���ϰ����� ����ȸ�� �ε������� ��ȯ�Ѵ�

      int check = -1;//index�� 0���� �����ϱ⶧���� -1�� �ʱ�ȭ

      for (int i = 0; i < memberList.size(); i++) {
         if (memberList.get(i).getMemberNumber().equals(number)) {
            check = i;// ������ ����ȣ�� ���� �ɹ� index���� ����
            break;
         }
      }
      return check;
   }

   //////////////////////////////////ȸ�� ����Ʈ ���� �޼ҵ�///////////////////////////////////////
   public void visitedPointSaving(int index, int totalAmount) {// ����ȸ�� ����Ʈ ����
      memberList.get(index).setMemberPoint(memberList.get(index).getMemberPoint() + (int)(totalAmount *0.1));
   }

   public void newPointSaving(Member m, int totalAmount) {// �ű�ȸ�� ����Ʈ ����
      m.setMemberPoint((int) (totalAmount * 0.1));
      memberList.add(new Member(m.getMemberName(), m.getMemberNumber(), m.getMemberPoint()));
   }

  

   
   public void fileSaveMemberList () {
      try (BufferedWriter memberBufferedWriter = new BufferedWriter(new FileWriter("./src/memberTextFiles/member.txt"));
            ) {
         for (int i = 0; i < getMemberList().size(); i++) {
            memberBufferedWriter.write(memberList.get(i).getMemberName()+",");
            memberBufferedWriter.write(memberList.get(i).getMemberNumber()+",");
            memberBufferedWriter.write(memberList.get(i).getMemberPoint()+(i != getMemberList().size()-1 ? "\n" : ""));
            System.out.println(memberList.get(i)+"�Է¿Ϸ�");
         }


      } catch (Exception e) {
         e.printStackTrace();
      }

   }
   
   public static MemberController getInstance() {
	      return MEMBER_CONTROLLER;
	   }

}