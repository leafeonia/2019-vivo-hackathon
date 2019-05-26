package advertisingspaceforrent.demo.data;

import advertisingspaceforrent.demo.po.User;
import advertisingspaceforrent.demo.vo.SignUpForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    User selectUserByUsername(@Param("username") String username);
    int insertMessage(@Param("signUpForm") SignUpForm signUpForm);
}
