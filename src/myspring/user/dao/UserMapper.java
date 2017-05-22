package myspring.user.dao;
import java.util.List;
import myspring.user.vo.UserVO;
@MyMapper
public interface UserMapper {
	/*mybatis mapper.xml파일의 아이디와 메소드 명이 일치해야 한다.!!!*/
	UserVO selectUserById(String id);
	List<UserVO> selectUserList();
	void insertUser(UserVO userVO);
	void updateUser(UserVO userVO);
	void deleteUser(String id);
}

