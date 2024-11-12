package com.github.bruce_mig.spring_redis_sentinel.service;

import com.github.bruce_mig.spring_redis_sentinel.request.AddRedisRequest;
import com.github.bruce_mig.spring_redis_sentinel.util.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Service
public class RedisService {

	private final RedisUtil<String> redisStringUtil;

	public void addRedis(AddRedisRequest request) {
		redisStringUtil.putValue(request.getKey(), request.getValue());
		redisStringUtil.setExpire(request.getKey(), request.getExpireMinutes(), TimeUnit.MINUTES);
	}

	public String getValue(String key) {

		String value = redisStringUtil.getValue(key);
		return value;
	}

}