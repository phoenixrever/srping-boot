package com.phoenixhell.boot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.phoenixhell.boot.bean.Custom;
import com.phoenixhell.boot.bean.CustomPage;
import com.phoenixhell.boot.bean.PropertiesBean;
import com.phoenixhell.boot.bean.User;
import com.phoenixhell.boot.service.Impl.CustomServiceImpl;
import com.phoenixhell.boot.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author phoenixhell
 * @create 2021/1/9 0009-上午 9:44
 * RequestResponseBodyMethodProcessor 处理responsebody 注解
 *MappingJackson2HttpMessageConverter  转化json
 */
//@ResponseBody
//@Controller

//@Data 必须加上@data set get 方法 @ConfigurationProperties(prefix = "person") 才能取值 或者autiweied 注入
@Controller
//@ConfigurationProperties(prefix = "person")
public class UserController {
    @Autowired
    private PropertiesBean pbean;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Value("${JAVA_HOME}")
    private String javahome;

    @Autowired
    private UserServiceImpl userService;

    //    必须加上@data set get 方法 才能取值
    @Value("${person.name:'张三'}")
//    @Autowired 注入对象
    private  String name;

    @Autowired
    CustomServiceImpl customService;


@GetMapping("/pages")
@ResponseBody
public CustomPage<Custom> getPage(){
//    Custom byId = customService.getById("1");
//    System.out.println(customService);
//    return customService.getById("1");
    Page<Custom> page = customService.page(new Page<Custom>(1, 10), new QueryWrapper<Custom>().orderBy(true, true, "id"));
    boolean next = page.hasNext();
    boolean previous = page.hasPrevious();
    String hasPrevious = previous?"1":"0";
    String hasNext=next?"1":"0";
    CustomPage<Custom> customPage = new CustomPage<>();
    customPage.setHasNext(hasNext);
    customPage.setHasPrevious(hasPrevious);
    customPage.setPage(page);
    return customPage;
}


    @GetMapping("/profile")
    @ResponseBody
    public String profile(){
        return "profile"+name;
    }

//    public Resource
    @RequestMapping(value = "/pbean")
    public PropertiesBean pbean(){
        return pbean;
    }

//    @GetMapping("/hello/{username}")
//    @ResponseBody
//    public User hello(@PathVariable("username")String username, HttpServletRequest request){
//       return "xxxx";
//    }

    @RequestMapping("/index/{id}")
    @ResponseBody
    public User index(@PathVariable("id") String id){
//        System.out.println(jdbcTemplate);
//        String sql="select * from users";
//        String sql1="select count(*) from users";
//        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
//        Long aLong = jdbcTemplate.queryForObject(sql1, Long.class);
//        System.out.println(users);
//        System.out.println(aLong);
        return userService.getUser(id);
    }
    @RequestMapping("/index")
    @ResponseBody
    public List<User> index(){
        return userService.getUsers();
    }


    @GetMapping("th")
    public String th(Map<String,Object> map, Model model, HttpSession session){
//        System.out.println(1/0);
        map.put("hello","world");
        model.addAttribute("hello","fuckddddddddddd");
        session.setAttribute("hello","sessionddddddddddddddddddd");
        return "redirect:success";
    }
    @GetMapping("success")
    public String success(Map<String,Object> map,Model model){
        model.addAttribute("add","addsuccess");
        return "success";
    }
//    @PostMapping("/upload") //@requestbody 接收的是是json字符串
//    public String upload(@RequestPart("file") MultipartFile file,MultipartFile[] files) throws IOException {
//        if(!file.isEmpty()){
//            file.transferTo(Paths.get("D:\\" + file.getOriginalFilename()));
//        }
//    }
}
