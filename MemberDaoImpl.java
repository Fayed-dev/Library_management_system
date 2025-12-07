package DAO;

import Model.Member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static DAO.DBConnection.getConnection;

public class MemberDaoImpl implements MembersDAO {
    @Override
    public void addMember(Member member) {
        String sql = "INSERT INTO Members (member_name , phone ) VALUES(?,?)";

        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, member.getMemberName());
            preparedStatement.setString(2, member.getMemberPhone());

            ResultSet re = preparedStatement.executeQuery();

            getConnection().close();


        } catch (SQLException sq) {
            sq.printStackTrace();
        }
    }

    @Override
    public void updateMember(Member member) {

    }

    @Override
    public void deleteMember(Member member) {
        String sql = "DELETE FROM Members WHERE member_id = ?";

        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, member.getMemberId());
            ResultSet re = preparedStatement.executeQuery();

            getConnection().close();


        } catch (SQLException sq) {
            sq.printStackTrace();
        }


    }

    @Override
    public void deleteMemberByName(Member member) {
        String sql = "DELETE FROM Members WHERE member_name = ?";

        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, member.getMemberName());
            ResultSet re = preparedStatement.executeQuery();
            getConnection().close();

        } catch (SQLException sq) {
            sq.printStackTrace();
        }


    }

    @Override
    public List<Member> getAllMember() {
        String sql = "SELECT*FROM Members";
        List<Member> allMembers = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Member member = new Member(resultSet.getInt("member_id"),
                        resultSet.getString("member_name"),
                        resultSet.getString("phone"));
                allMembers.add(member);
            }
            getConnection().close();
            return allMembers;

        } catch (SQLException sq) {
            sq.printStackTrace();
        }


        return List.of();
    }

    @Override
    public List<Member> getMemberByName(Member memberName) {
        String sql = "SELECT*FROM Members WHERE member_name LIKE %?% ";
        List<Member> members = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, memberName.getMemberName());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Member newMember = new Member(resultSet.getInt("member_id"),
                        resultSet.getString("member_name"),
                        resultSet.getString("phone"));

                members.add(newMember);

            }
            getConnection().close();
            return members;
        } catch (SQLException sq) {
            sq.printStackTrace();
        }


        return List.of();
    }

    @Override
    public Member getMemberById(Member memberId) {

        String sql = "SELECT*FROM Members WHERE member_id LIKE %?% ";
        //List<Member> members = new ArrayList<>();
        Member newMember = null;
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, memberId.getMemberId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                newMember = new Member(resultSet.getInt("member_id"),
                        resultSet.getString("member_name"),
                        resultSet.getString("phone"));
            }
            getConnection().close();

        } catch (SQLException sq) {
            sq.printStackTrace();
        }
        return newMember;
    }
}
