package com.sd.hz;

import com.sd.hz.mapper.primary.UserMapper;
import com.sd.hz.mapper.secondary.SecondaryUserMapper;
import com.sd.hz.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private SecondaryUserMapper secondayUserMapper;

	@Test
	public void testMapper(){
		List<User> allUsers = userMapper.findAllUsers();
		System.out.println(allUsers.size());

		List<User> llUsers = secondayUserMapper.findAllUsers();
		System.out.println(llUsers.size());
	}


	@Test
	public void contextLoads() {
	}

}
