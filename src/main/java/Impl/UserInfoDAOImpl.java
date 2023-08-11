package Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.common.MybatisConfig;
import com.web.vo.UserInfoVO;

import dao.UserInfoDAO;

public class UserInfoDAOImpl implements UserInfoDAO {

	@Override
	public List<UserInfoVO> selectUserInfoList(SqlSession session, UserInfoVO uiNum) {
		return session.selectList("com.web.mapper.UserInfoMapper.selectUserInfo",uiNum);
		
	}

	@Override
	public int selectUserInfo(SqlSession session, UserInfoVO uiNum) {
		return session.selectOne("com.web.mapper.UserInfoMapper.selectUserInfo",uiNum);
		
	}

	@Override
	public int insertUserInfo(SqlSession session, UserInfoVO user) {
		return session.insert("com.web.mapper.UserInfoMapper.insertUserInfo",user);
	
	}

	@Override
	public int updateUserInfo(SqlSession session, UserInfoVO user) {
		return session.update("com.web.mapper.UserInfoMapper.updateUserInfo",user);
	
	}

	@Override
	public int deleteUserInfo(SqlSession session, int uiNum) {
		return session.delete("com.web.mapper.UserInfoMapper.deleteUserInfo",uiNum);
	}
	public static void main(String[] args) {
		try(SqlSession session = MybatisConfig.getSqlSessionFactory().openSession()){
			UserInfoDAO uiDAO = new UserInfoDAOImpl();
			List<UserInfoVO> userList = uiDAO.selectUserInfoList(session, null);
			for(UserInfoVO user : userList) {
				System.out.println(user);
			}
			UserInfoVO user = uiDAO.selectUserInfo(session, 6);
			System.out.println("select one : " + user);
//			user.setUiId("dao");
//			int result = uiDAO.insertUserInfo(session, user);
	
			user.setUiName("변경");
			int result = uiDAO.updateUserInfo(session, user);
			System.out.println("insert : " + result);
			result = uiDAO.deleteUserInfo(session, 6);
			System.out.println("delete : " + result);
			session.commit();
		}
	}
}
