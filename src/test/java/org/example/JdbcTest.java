//package org.example;
//
//
//import org.example.domain.UserMy;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//public class JdbcTest {
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @Test
//    public void createUserTable() throws Exception{
//        String sql = "CREATE TABLE `user` (\n" +
//                "  `id` int(10) NOT NULL AUTO_INCREMENT,\n" +
//                "  `username` varchar(100) DEFAULT NULL,\n" +
//                "  `password` varchar(100) DEFAULT NULL,\n" +
//                "  PRIMARY KEY (`id`)\n" +
//                ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;\n" +
//                "\n";
//
//        jdbcTemplate.execute(sql);
//
//    }
//    @Test
//    public void saveUser() throws  Exception{
//        String sql = " insert into user(username,password) values('qinjinwei','123456')";
//        int rows = jdbcTemplate.update(sql);
//        System.out.println(rows);
//    }
//
//    @Test
//    public void getUser() throws  Exception{
//        String name = "qinjinwei";
//        String sql = "select * from user where username = ?";
//        List<UserMy> list = jdbcTemplate.query(sql,new UserMy(),new Object[]{name});
//       for(UserMy user :list){
//           System.out.println(user);
//           System.out.println(1);
//       }
//    }
//}
