package com.just.manager.service.impl;

import com.just.manager.dao.IHeadMasterMapper;
import com.just.manager.dao.IStudentMapper;
import com.just.manager.domain.Student;
import com.just.manager.service.IUserService;
import com.just.manager.domain.HeadMaster;
import com.just.manager.domain.Power;
import com.just.manager.utils.BCryptPasswordEncoderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserService implements IUserService {

    @Autowired
    private IStudentMapper mapper2;
    @Autowired
    private IHeadMasterMapper mapper1;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        HeadMaster master = mapper1.getByHNo(username);
        User user = null;
        if (master == null || !master.getStuNo().equals(username)){
            System.out.println("vvvvvvvvvvvvvvvvv");
            Student student = mapper2.selectByStuNo(username);
            List<Power> powers2 = student.getPowers();
            List<SimpleGrantedAuthority> authorities = getAuthority(powers2);
            user = new User(student.getStuNo(), BCryptPasswordEncoderUtils.encodePassword(student.getStuPwd()),
                    true,true,true,true,authorities);
        }else{
            List<Power> powers = master.getPowers();
            List<SimpleGrantedAuthority> authorities = getAuthority(powers);
            user = new User(master.getStuNo(), BCryptPasswordEncoderUtils.encodePassword(master.getStuPwd()),
                    true,true,true,true,authorities);

        }
        return user;
    }
    private List<SimpleGrantedAuthority> getAuthority(List<Power> powers){
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for(Power power : powers){
            list.add(new SimpleGrantedAuthority("ROLE_"+power.getRole()));
            System.out.println("ROLE_"+power.getRole());
        }
        return list;
    }

}
