package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class SpringBootMysqlApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        // 查看数据库默认数据源
        System.out.println(dataSource.getClass());
        // 获取连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        // 释放
        connection.close();
    }

}
