package com.neo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
public class HelloJsonController implements Serializable {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;




    /*
     *描述：自动将返回数据转换成json
     *参数：
     *返回值：
     */
@RequestMapping("/setUser")
public User mm(HttpServletRequest request, HttpServletResponse response ){
    User user = new User();
    user.setAge("01");
    user.setName("你看这个面！");
    stringRedisTemplate.opsForValue().set("name",user.getName());
    stringRedisTemplate.opsForValue().set("age",user.getAge());
    redisTemplate.opsForValue().set("user",user);

    return user;
}
    @RequestMapping("/getUser")
    public void getUser(HttpServletRequest request, HttpServletResponse response ){
        User user = (User) redisTemplate.opsForValue().get("user");
        System.out.println(user);


    }




    //序列化
    public static byte [] serialize(Object obj){
        ObjectOutputStream obi=null;
        ByteArrayOutputStream bai=null;
        try {
            bai=new ByteArrayOutputStream();
            obi=new ObjectOutputStream(bai);
            obi.writeObject(obj);
            byte[] byt=bai.toByteArray();
            return byt;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //反序列化
    public static Object unserizlize(byte[] byt){
        ObjectInputStream oii=null;
        ByteArrayInputStream bis=null;
        bis=new ByteArrayInputStream(byt);
        try {
            oii=new ObjectInputStream(bis);
            Object obj=oii.readObject();
            return obj;
        } catch (Exception e) {

            e.printStackTrace();
        }


        return null;
    }

}
