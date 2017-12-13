package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.demo.domain.User;
@Service
public class RedisService {
	
	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	StringRedisTemplate stringRedisTemplate;
	
	public String test() {
		String uuid = UUID.randomUUID().toString();
//		stringRedisTemplate.opsForValue().set(uuid, "8888");
//		redisTemplate.opsForValue().set(uuid, "test");
//		redisTemplate.opsForValue().set("ttt", "3333");
		redisTemplate.opsForValue().set("666", uuid, 10000);
		Map<String,String> map = new HashMap<String,String>();
		map.put("name","wangxin");
		map.put("age", "22");
		map.put("qq", "8888");
		redisTemplate.opsForHash().putAll("user:001", map);
		stringRedisTemplate.opsForHash().putAll("user:002", map);
//		User user = new User();
//		redisTemplate.opsForValue().set("user:001", user);
		return "666";
	}
	
	@SuppressWarnings("all")
	public String serialize(User u) {
		redisTemplate.opsForValue().set("user:"+u.getId(), u);
		return u.toString();
	}
	
	public User getUser(String id) {
		User user = (User) redisTemplate.opsForValue().get(id);
		return user;
	}
}
