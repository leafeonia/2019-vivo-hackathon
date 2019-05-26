package advertisingspaceforrent.demo.data;

import advertisingspaceforrent.demo.po.User;
import advertisingspaceforrent.demo.vo.SignUpForm;
import advertisingspaceforrent.demo.vo.UpdateMoneyForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User selectUserByUsername(@Param("username") String username);
    User selectUserByUserid(@Param("useid") Integer userid);
    int insertMessage(@Param("signUpForm") SignUpForm signUpForm);
    int updateMoney(@Param("updateMoneyForm") UpdateMoneyForm updateMoneyForm);
    int getRestMoney(@Param("getMoney") UpdateMoneyForm updateMoneyForm);
}
