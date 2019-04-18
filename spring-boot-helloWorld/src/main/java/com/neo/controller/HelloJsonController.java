package com.neo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class HelloJsonController {
    /*
     *描述：自动将返回数据转换成json
     *参数：
     *返回值：
     */
@RequestMapping("/getUser")
public User mm(HttpServletRequest request, HttpServletResponse response ){
    User user = new User();
    user.setAge("01");
    user.setName("张三");
    return user;
}



    public  class User{
        private String name;
        private String age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }

}
