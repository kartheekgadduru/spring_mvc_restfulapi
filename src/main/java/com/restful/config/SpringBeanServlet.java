package com.restful.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.restful.dao.StudentDao;
import com.restful.dao.StudentDaoImpl;

@Configuration
@EnableWebMvc
@ComponentScan("com.restful.contoller")
@PropertySource(value= {"classpath:databasedetails.properties"})
public class SpringBeanServlet extends WebMvcConfigurationSupport{

	@Autowired
	private Environment env;

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
		ds.setUrl(env.getRequiredProperty("jdbc.url"));
		ds.setUsername(env.getRequiredProperty("jdbc.username"));
		ds.setPassword(env.getRequiredProperty("jdbc.password"));

		return ds;
	}

	@Bean
	public StudentDao getStudentDao() {
		StudentDaoImpl stdDaoImpl = new StudentDaoImpl();
		stdDaoImpl.setDs(getDataSource());
		return stdDaoImpl;
	}

}
