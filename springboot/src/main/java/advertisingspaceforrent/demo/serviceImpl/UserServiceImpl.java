package advertisingspaceforrent.demo.serviceImpl;

import advertisingspaceforrent.demo.data.UserMapper;
import advertisingspaceforrent.demo.po.User;
import advertisingspaceforrent.demo.service.UserService;
import advertisingspaceforrent.demo.vo.UpdateMoneyForm;
import advertisingspaceforrent.demo.vo.LoginForm;
import advertisingspaceforrent.demo.vo.ResponseVO;
import advertisingspaceforrent.demo.vo.SignUpForm;
import advertisingspaceforrent.demo.vo.UpdateMoneyForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

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
    public ResponseVO signUp(SignUpForm signUpForm) {
        try{
            User user = userMapper.selectUserByUsername(signUpForm.getUsername());
            if(null != user){
                return ResponseVO.buildFailure("用户名已被注册!");
            }
            int success = userMapper.insertMessage(signUpForm);
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
    public ResponseVO updateMoney(UpdateMoneyForm updateMoneyForm){
        try {
            User user = userMapper.selectUserByUserid(updateMoneyForm.getUserid());
            if(null == user){
                return ResponseVO.buildFailure("用户ID不存在!");
            }
            int rest = userMapper.getRestMoney(updateMoneyForm);
            if(rest+updateMoneyForm.getMoney() < 0){
                return ResponseVO.buildFailure("余额不足!");
            }
            int success = userMapper.updateMoney(updateMoneyForm);
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
