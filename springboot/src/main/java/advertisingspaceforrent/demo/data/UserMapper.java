package advertisingspaceforrent.demo.data;

import advertisingspaceforrent.demo.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    User selectUserByUsername(@Param("username") String username);

}
