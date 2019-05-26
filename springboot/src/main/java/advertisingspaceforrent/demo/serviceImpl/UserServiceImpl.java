package advertisingspaceforrent.demo.serviceImpl;

import advertisingspaceforrent.demo.data.UserMapper;
import advertisingspaceforrent.demo.po.User;
import advertisingspaceforrent.demo.service.UserService;
import advertisingspaceforrent.demo.vo.LoginForm;
import advertisingspaceforrent.demo.vo.ResponseVO;
import advertisingspaceforrent.demo.vo.SignUpForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public ResponseVO login(LoginForm loginForm) {
        try {
            User user = userMapper.selectUserByUsername(loginForm.getUsername());
            if (null == user) {
                return ResponseVO.buildFailure("用户名不存在!");
            }
            if (!user.getPassword().equals(loginForm.getPassword())) {
                return ResponseVO.buildFailure("密码错误!");
            }
            return ResponseVO.buildSuccess(user);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("登录失败!");
        }
    }

    @Override
    public ResponseVO signup(SignUpForm signUpForm) {
        try{
            User user = userMapper.selectUserByUsername(signUpForm.getUsername());
            if(null != user){
                return ResponseVO.buildFailure("用户名已被注册!");
            }
            userMapper.insertMessage(signUpForm);
            return ResponseVO.buildSuccess();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("注册失败");
        }
    }
}
