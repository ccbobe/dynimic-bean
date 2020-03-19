package com.ccbobe;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User {
	/**
	 * 年龄
	 */
	private Integer age =20;
	/**
	 * 名称
	 */
	private String name ="ccbobe";
	/**
	 * 用户Id
	 */
	private Integer userId;
}
