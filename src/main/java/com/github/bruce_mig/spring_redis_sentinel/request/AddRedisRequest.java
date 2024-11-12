package com.github.bruce_mig.spring_redis_sentinel.request;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddRedisRequest {
	
	private String key;
	private String value;
	private Integer expireMinutes;

}
