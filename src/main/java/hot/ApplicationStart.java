package hot;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


@SpringBootApplication
public class ApplicationStart {
    public  static void main(String[] args){
        SpringApplication.run(ApplicationStart.class,args);}

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://bizmeaoxektymsx9iifm-mysql.services.clever-cloud.com:3306/bizmeaoxektymsx9iifm?useTimezone=true&serverTimezone=UTC&useSSL=false");
        dataSource.setUsername("u7ymgdyzzbsm52q9");
        dataSource.setPassword("KJTBGJYYa2dlzBiCa4dH");
        return dataSource;
    }
}
