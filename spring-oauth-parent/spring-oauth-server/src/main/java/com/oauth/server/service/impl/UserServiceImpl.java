package com.oauth.server.service.impl;



import com.oauth.server.beans.User;
import com.oauth.server.beans.UserExample;
import com.oauth.server.mapper.UserExMapper;
import com.oauth.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.upms.service.impl
 * @ClassName: UserServiceImpl
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/15 14:45
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/15 14:45
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserExMapper mapper;

    @Override
    public User findByUserName(String userName) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(userName.trim());
        List<User> list=mapper.selectByExample(example);
        return  list.size()>0?list.get(0):null;
    }
}
