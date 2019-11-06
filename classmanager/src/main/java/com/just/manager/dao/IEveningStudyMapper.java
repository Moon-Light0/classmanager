package com.just.manager.dao;

import com.just.manager.domain.EveningStudy;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.method.P;

import java.util.Date;
import java.util.List;

public interface IEveningStudyMapper {

    /**
     * 新增一条学生晚自习信息
     * @param study
     * @return 成功返回1，失败返回
     */
    public int insertByStuNo(EveningStudy study);

    /**
     * 根据日期查询一个学生晚自习考勤信息
     * @param eDateStr
     * @param stuNo
     * @return
     */
    public EveningStudy selectByEDateStrAndStuNo(@Param("eDateStr") String eDateStr, @Param("stuNo") String stuNo);

    //根据日期查询所有晚自习未/已签到学生信息
    public List<EveningStudy> selectByEDateStrAndStuNoAndIsSign(
            @Param("eDateStr") String eDateStr, @Param("stuNo") String stuNo,@Param("isSign")Integer isSign);
}
