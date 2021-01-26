package com.phoenixhell.boot.actualtor.MyEndPoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

/**
 * @author phoenixhell
 * @create 2021/1/16 0016-上午 9:48
 */
@Component
@Endpoint(id="myendpoint") //endpoint的名字 瘦子,首字母必须小写
public class MyCustomEndPoint {
    @ReadOperation //端点的读操作
    public Map getDockerInfo(){
        return  Collections.singletonMap("dockerinfo","docker statup ...");
    }
    @WriteOperation //jconsole 里面可以控制
    public void stopDocker(){
        System.out.println("docker stoped...");
    }
}
