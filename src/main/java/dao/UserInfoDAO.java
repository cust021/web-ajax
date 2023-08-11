package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.vo.UserInfoVO;

public interface UserInfoDAO {
	List<UserInfoVO> selectUserInfoList(SqlSession session, UserInfoVO uiNum);
	int selectUserInfo(SqlSession session, UserInfoVO uiNum);
	int insertUserInfo(SqlSession session, UserInfoVO user);
	int updateUserInfo(SqlSession session, UserInfoVO user);
	int deleteUserInfo(SqlSession session, int uiNum);
}
