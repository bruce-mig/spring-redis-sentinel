package com.github.bruce_mig.spring_redis_sentinel.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.bruce_mig.spring_redis_sentinel.request.AddRedisRequest;
import com.github.bruce_mig.spring_redis_sentinel.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/redis")
@RequiredArgsConstructor
public class RedisController {

	private final RedisService redisService;

	@PostMapping("/add")
	public ResponseEntity<?> addRedisKeyValue(@RequestBody AddRedisRequest redisRequest){

		redisService.addRedis(redisRequest);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.CREATED);
	}

	@GetMapping()
	public ResponseEntity<?> getFromCache(@RequestParam(value = "key") String key) throws JsonProcessingException {

		String value = redisService.getValue(key);
		return new ResponseEntity<String>(value, HttpStatus.OK);
	}

}
