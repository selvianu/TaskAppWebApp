package in.spinsoft.users.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@org.springframework.context.annotation.Configuration
public class Configuration {

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		System.out.println("JdbcTemplate object created and instance is ready");
//			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  //Constructor injection
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource); // setter injection
		return jdbcTemplate;
	}
}
