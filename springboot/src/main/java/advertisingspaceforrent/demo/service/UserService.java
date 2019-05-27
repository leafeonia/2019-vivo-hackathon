package advertisingspaceforrent.demo.service;

import advertisingspaceforrent.demo.vo.ResponseVO;

public interface UserService {

    /**
     * 登陆
     * @param username : 用户名
     * @param password : 密码
     * @return None
     */
    ResponseVO login(String username, String password);

    /**
     * 注册
     * @param username : 用户名
     * @param password : 密码
     * @param email : 邮箱
     * @return None
     */
    ResponseVO signUp(String username, String password, String email);

    /**
     * 加钱
     * @param userid : 用户Id
     * @param money : 变动的钱数
     * @return None
     */
    ResponseVO updateMoney(Integer userid, Integer money);
}