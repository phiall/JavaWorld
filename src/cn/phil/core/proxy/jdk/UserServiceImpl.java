package cn.phil.core.proxy.jdk;

/**
 * @author px
 * @date 2021/3/8 15:34
 */
public class UserServiceImpl implements UserService {
    @Override
    public String getUser(Long id) {
        return "User {id=1, name=Jack}";
    }
}
