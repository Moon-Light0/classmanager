package com.just.manager.service;

import com.just.manager.domain.HeadMaster;

public interface IHeadMasterService {

    HeadMaster getByHNo(String hNo);

    public boolean checkUserNameAndPassword(String username,String password);

    int update(HeadMaster master);
}
