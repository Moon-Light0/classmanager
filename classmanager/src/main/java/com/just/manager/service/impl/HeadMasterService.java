package com.just.manager.service.impl;

import com.just.manager.dao.IHeadMasterMapper;
import com.just.manager.domain.HeadMaster;
import com.just.manager.service.IHeadMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HeadMasterService implements IHeadMasterService {
    @Autowired
    private IHeadMasterMapper mapper;

    @Override
    public HeadMaster getByHNo(String hNo) {
        return mapper.getByHNo(hNo);
    }

    @Override
    public boolean checkUserNameAndPassword(String username, String password) {
        return mapper.checkUserNameAndPassword(username,password);
    }

    @Override
    public int update(HeadMaster master) {
        return mapper.update(master);
    }
}
