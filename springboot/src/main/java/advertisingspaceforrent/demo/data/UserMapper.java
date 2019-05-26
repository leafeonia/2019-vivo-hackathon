package advertisingspaceforrent.demo.data;

import advertisingspaceforrent.demo.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    User selectUserByUsername(@Param("username") String username);

    User selectUserByUserid(@Param("userid") Integer userid);

    int insertAccount(@Param("username") String username,
                      @Param("password") String password,
                      @Param("email") String email);

    int updateMoney(@Param("userid") Integer userid,
                    @Param("money") Integer money);

    int getRestMoney(@Param("userid") Integer userid);
}
