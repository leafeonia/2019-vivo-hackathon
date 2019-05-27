package advertisingspaceforrent.demo.serviceImpl;

import advertisingspaceforrent.demo.data.UserMapper;
import advertisingspaceforrent.demo.po.User;
import advertisingspaceforrent.demo.service.UserService;
import advertisingspaceforrent.demo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    public ResponseVO login(String username, String password) {
        try {
            User user = userMapper.selectUserByUsername(username);
            if (null == user) {
                return ResponseVO.buildFailure("用户名不存在!");
            }
            if (!user.getPassword().equals(password)) {
                return ResponseVO.buildFailure("密码错误!");
            }
            return ResponseVO.buildSuccess(user);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("登录失败!");
        }
    }

    @Override
    public ResponseVO signUp(String username, String password, String email) {
        try{
            User user = userMapper.selectUserByUsername(username);
            if(null != user){
                return ResponseVO.buildFailure("用户名已被注册!");
            }
            int success = userMapper.insertAccount(username, password, email);
            if(success == 0){
                return ResponseVO.buildFailure("插入失败!");
            }
            return ResponseVO.buildSuccess();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("注册失败!");
        }
    }

    @Override
    public ResponseVO updateMoney(Integer userid, Integer money){
        try {
            User user = userMapper.selectUserByUserid(userid);
            if(null == user){
                return ResponseVO.buildFailure("用户ID不存在!");
            }
            int rest = userMapper.getRestMoney(userid);
            if(rest+money < 0){
                return ResponseVO.buildFailure("余额不足!");
            }
            int success = userMapper.updateMoney(userid, money);
            if(success == 0){
                return ResponseVO.buildFailure("加钱失败!");
            }
            return ResponseVO.buildSuccess();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("加钱失败!");
        }
    }
}
