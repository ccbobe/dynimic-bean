package com.ccbobe;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.liquibase.SpringPackageScanClassResolver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/")
public class IndexController {

	@Autowired
	protected ApplicationContext ctx;

	@RequestMapping("addClass")
	public String addClass(String className) throws Exception{
		//将applicationContext转换为ConfigurableApplicationContext
		ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext)ctx;
		// 获取bean工厂并转换为DefaultListableBeanFactory
		DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) configurableApplicationContext.getBeanFactory();
		// 通过BeanDefinitionBuilder创建bean定义
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
		defaultListableBeanFactory.registerBeanDefinition("user", beanDefinitionBuilder.getRawBeanDefinition());

		//删除bean.
		//defaultListableBeanFactory.removeBeanDefinition("user");

		User user = (User) ApplicationUtils.getApplicationContext().getBean("user");
		return user.getName();
	}


	@RequestMapping("removeClass")
	public String removeClass(String className) throws Exception{
		//将applicationContext转换为ConfigurableApplicationContext
		ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext)ctx;
		// 获取bean工厂并转换为DefaultListableBeanFactory
		DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) configurableApplicationContext.getBeanFactory();

		defaultListableBeanFactory.removeBeanDefinition("user");
		return className;
	}


}
