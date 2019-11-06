package com.just.manager.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.pagehelper.PageInfo;
/**
 * 使用Spring测试模块提供的测试请求功能，测试增删改查的正确性
 * @author MrXu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration //拿到web容器
@ContextConfiguration(locations= {"classpath:applicationContext.xml","classpath:springmvc.xml"})
public class MVTest {
	//传入Springmvc的ioc
	@Autowired
	WebApplicationContext context;
	//虚拟mvc请求,需要创建出来
	MockMvc mvc;
	
	@Before
	public void initMockMvc() {
		//传入context
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	@Test
	public void testPage() throws Exception {
		//模拟发送请求
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "8")).andReturn();
		PageInfo info = (PageInfo) result.getRequest().getAttribute("page");
		System.out.println(info.getPageNum() + "-->当前页码");
		System.out.println(info.getPages()+ "-->总页码");
		System.out.println(info.getTotal() + "-->总记录数");
		System.out.println("当前连续显示的页码：");
		int[] nums = info.getNavigatepageNums();
		for(int i : nums) {
			System.out.print(i);
		}
		
		/*List list = info.getList();
		Iterator<Employee> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}*/
	}
}
