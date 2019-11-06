package com.just.manager.test;

import com.just.manager.dao.*;
import com.just.manager.domain.EveningStudy;
import com.just.manager.domain.Reward;
import com.just.manager.service.IHeadMasterService;
import com.just.manager.utils.DateUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *	测试dao层的工作
 * @author MrXu
 *	推荐Spring的项目就可以使用Spring的单元测试组件
 *	1.导入单元测试spring-test
 *	2.@ContextConfiguration指定spring配置文件的位置
 *	3.直接autowired组件
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	IStudentMapper mapper;
	@Autowired
	IHeadMasterMapper mapper2;
	@Autowired
	IEveningStudyMapper mapper3;
	@Autowired
	IRewardMapper mapper4;
	@Autowired
	IScoreMapper mapper5;
	@Autowired
	IPowerMapper mapper6;
	@Autowired
	SqlSession sqlSession;
	@Test
	public void testEveningMapper(){
		System.out.println(mapper3.selectByEDateStrAndStuNoAndIsSign("2019-10-27","168111545237",1));
//		EveningStudy s = new EveningStudy("9e49b91a-d9ae-4da5-a1c0-20d0051a5","",new Date(),"",1,""," ");
//		System.out.println(mapper3.insertByStuNo(s)); //成功返回
	}
	@Test
	public void testRewardMapper() throws ParseException {
//		System.out.println(mapper4.selectByIsGood(1));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = format.parse("2019-10-31 16:59:59");
//		System.out.println(date);
		//System.out.println(mapper4.update(new Reward(date,"168111545243","mmmmm",1)));
		System.out.println(mapper4.selectByRewardDate(date));


		//System.out.println(mapper4.deleteByRewardDate(date));
		//System.out.println(mapper4.insert(new Reward(cal.getTime(),"168111545237","aaaaa",1)));
        System.out.println(mapper4.selectAll());
		//System.out.println(mapper4.selectByIsGood(1));
//		List<Date> list = new ArrayList<>();
//		list.add(DateUtil.string2Date("yyyy-MM-dd hh:mm:ss","2019-10-29 20:47:35"));
//		list.add(DateUtil.string2Date("yyyy-MM-dd hh:mm:ss","2019-10-29 21:15:20"));
//		System.out.println(mapper4.deleteByRewardDates(list));

	}
	@Test
	public void testHead(){
		System.out.println(mapper2);
		System.out.println(mapper2.getByHNo("12321"));
		System.out.println(mapper2);
	}
	@Test
	public void testScore(){
		System.out.println(mapper6.selectByStuNo("168111545237"));
	}
	@Test
	public void testCURD() {
		//创建springioc容器
//		ApplicationContext context = new ClassPathXmlApplicationContext();
//		//从容器中获取mapper
//		DepartmentMapper department = (DepartmentMapper) context.getBean(Department.class);
//		System.out.println(mapper);
		System.out.println(mapper.selectByStuNo("168111545237"));
		System.out.println(mapper.selectAll());
//		System.out.println(mapper.selectStuNameByStuNo("168111545237"));

//		System.out.println(new Department(1,"manager"));
		//1.插入几个部门
//		departmentMapper.insertSelective(new Department(null,"runner"));
		//2.生成员工数据
//		employeeMapper.insertSelective(new Employee(null,"xu","男", "xxx@qq.com",1));
		//3.批量插入多个员工
//		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//		for(int i = 0; i < 100; i++) {
//			String uid = UUID.randomUUID().toString().substring(0, 6)+i;
//			mapper.insertSelective(new Employee(null, uid,"男",uid+"@ep.com",1));
//		}
//		System.out.println("批量生产");
		
		//4.测试删除部门，员工
//		departmentMapper.deleteByPrimaryKey(2);
	}
	
}
