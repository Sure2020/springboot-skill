package com.example.template;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.example.template.entity.User;
import com.example.template.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TemplateApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testSelect() {
		System.out.println(("----- selectAll method test ------"));
		List<User> userList = userMapper.selectList(null);
		//Assert.isTrue(6 == userList.size(), "test msg");
		userList.forEach(System.out::println);
	}
	@Test
	public void testSelect2() {
		System.out.println(("----- select by name Jone ------"));
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("name", "Jone");  // 添加 name=Jone 条件

		List<User> userList = userMapper.selectList(queryWrapper);
		userList.forEach(System.out::println);
	}
	@Test
	public void testSelect3() {
		System.out.println(("----- select by name Jone ------"));
		LambdaQueryWrapper<User> lambdaQuery = new LambdaQueryWrapper<>();
		lambdaQuery.eq(User::getName, "Jone");  // 类型安全的方式

		List<User> userList = userMapper.selectList(lambdaQuery);
		userList.forEach(System.out::println);
	}


}
