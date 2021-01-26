package com.phoenixhell.boot.config;

import ch.qos.logback.classic.pattern.MessageConverter;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.phoenixhell.boot.ImportSelector.MyImportBeanDefinitionRegistrar;
import com.phoenixhell.boot.ImportSelector.MyimportSelector;
import com.phoenixhell.boot.aop.LogAspect;
import com.phoenixhell.boot.bean.*;
import com.phoenixhell.boot.condition.WindowCondition;
import com.phoenixhell.boot.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.filter.OrderedCharacterEncodingFilter;
import org.springframework.boot.web.servlet.server.Encoding;
import org.springframework.context.annotation.*;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.smile.MappingJackson2SmileHttpMessageConverter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.StringUtils;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.security.PrivateKey;
import java.util.*;

/**
 * @author phoenixhell
 * @create 2021/1/9 0009-上午 10:50
 */

/**
 * 当@Bean方法在没有使用@Configuration注释的类中声明时，它们被称为在Lite模式下处理。
 * 它包括：在@Component中声明的@Bean方法，甚至只是在一个非常普通的类中声明的Bean方法，
 * 都被认为是Lite版的配置类。@Bean方法是一种通用的工厂方法（factory-method）机制。
 */
/*
    true 单例模式 false 多例模式  beanfactory
    Each call to the method will pass through the proxy and assuming singleton scoped beans,
    it will return the same instance each time the method is called.
    Bean Lite Modeでは、Spring Containerにより通常のFactory Methodとして処理されます。つまり、CGLIB Proxyを利用しません。
    そのため、inter-bean referencesは機能せず、普通にmethod callして再取得、という形になっています。
    简单来说 就是不在容器中注册 加快加载速度  只用factory生产bean 对象依旧是容器管理只是不保证是唯一的了
 */
//@PropertySource("classpath:/person.properties") springboot 不用 @ConfigurationProperties(prefix = "user")
    //applicationContext.getEnvironment().getproeprtiy("值")  也可以
@Configuration(proxyBeanMethods = false)//true为代理对象调用方法检查组件是否在容器中有实例 单实例 false  组件不被其他组件依赖 可以加快加载速度
//@ConditionalOnMissingBean(name = "user")
@Import({User.class,MyimportSelector.class, MyImportBeanDefinitionRegistrar.class})//不用在下面写 user bean了 不用new了
//如果在这边import注册到容器 User bean就不用加@component 初始化数据 根据@ConfigurationProperties(prefix = "user")
//从yaml里面获取  在 configclass 里面声明bean 需要自己new构造函数初始化
//@Import({User.class})
//@ImportResource("oldbean.xml")
//@EnableTransactionManagement
/**
 * 如果 classpath 下有 spring-aop 的 jar 和有 EnableAspectJAutoProxy 类等，
 * conditiononbean
 * 它就会自动开启 spring-aop。并且此自动配置类还能通过 SpringBoot 的配置文件
 * application.properties 中配置的 AOP 相关属性进行选择，使用哪一种代理模式
 * @EnableAspectJAutoProxy
 *我们不需要在启动类加上启动 Aop 的注解 EnableAspectJAutoProxy
 */

@EnableConfigurationProperties(PropertiesBean.class)
public class ConfigClass {
//    @Profile("prod")
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//    @Scope("prototype")
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.H2));
        return interceptor;
    }

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> configuration.setUseDeprecatedExecutor(false);
    }

    @Bean
//    @Lazy //懒加载
    @Conditional({WindowCondition.class})
    public Dept dept() {
        return new Dept("1","人事部");
    }

    @Bean
    public LogAspect logAspect(){
        return new LogAspect();
    }
    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
//    @Bean
//    //car 可以@autowired 不标  直接获取
////    @Autowired
//    public Boss boss(@Autowired Car car){
//
//    }

//    @Bean("moreBean2")
//    @Primary
    public MoreBean moreBean(){
        MoreBean moreBean = new MoreBean();
        moreBean.name="moreBeanConfig-----------------------";
        return moreBean;
    }
//    @Bean
//    p ublic InternalResourceViewResolver internalResourceViewResolver(){
//        return new InternalResourceViewResolver("/WEB-INF/view/",".jsp");
//    }
//    @Bean
//    public User user(Dept dept){
//        return new User("柠檬","fuck",dept);
//    }
//    @Bean
//    public CharacterEncodingFilter characterEncodingFilter(){
//        return  new CharacterEncodingFilter("UTF_8");
//    }


    /**
     * 定制springmvc
     *
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
                Map<String,MediaType> map =new HashMap<>();//支持类型
                map.put("json",MediaType.APPLICATION_JSON);
                map.put("xml",MediaType.APPLICATION_XML);
                map.put("gg",MediaType.parseMediaType("application/x-gugui"));
                //参数策略
                ParameterContentNegotiationStrategy strategy = new ParameterContentNegotiationStrategy(map);
                strategy.setParameterName("format");//改变format的名字

                //数组不可变 大小为1    arrays.aslist 数组长度固定 可set 改变值 java.util.arrays
                // 内部类  不具有 arraylist 方法
                HeaderContentNegotiationStrategy headerStrategy = new HeaderContentNegotiationStrategy();

                configurer.strategies(Arrays.asList(strategy,headerStrategy));
            }

//            @Profile("prod")  方法上不起左右
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                LoginInterceptor loginInterceptor = new LoginInterceptor();
//                InterceptorRegistration interceptor = registry.addInterceptor(loginInterceptor);
//                interceptor.addPathPatterns("/**");
//                System.out.println("里面的");
//                interceptor.excludePathPatterns("/","/login","/static");
//            }

            //自定义返回类型
//            @Override
//            public void addFormatters(FormatterRegistry registry) {
//                registry.addConverter(new Converter<String, User>() {
//                    @Override
//                    public User convert(String s) {
//                        if(!StringUtils.isEmpty(s)){
//                            User user =new User();
//                            user.setUsername(s.split(",")[0]);
//                            user.setPassword(s.split(",")[1]);
//                             return user;
//                        }
//                        return null;
//                    }
//                });
//            }
            //覆盖默认
//            @Override
//            public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//
//            }
            //扩展
            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                //注册自定义convter add
                //mappingjkson 虽然能读写user 类型 但是不支持写入 x-guigu协议类型 只能是json
               converters.add(new HttpMessageConverter<User>() {
                   @Override
                   public boolean canRead(Class<?> aClass, MediaType mediaType) {
                       return false;
                   }

                   @Override
                   public boolean canWrite(Class<?> aClass, MediaType mediaType) {
                       return aClass.isAssignableFrom(User.class);
                   }

                   @Override
                   public List<MediaType> getSupportedMediaTypes() {
                       return MediaType.parseMediaTypes("application/x-guigu");
                   }

                   @Override
                   public User read(Class<? extends User> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
                       return null;
                   }

                   @Override
                   public void write(User user, MediaType mediaType, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
                       String data=user.getPassword();
                       httpOutputMessage.getBody().write(data.getBytes());
                   }
               });
            }

        };

    }
//    @Bean
//        public CharacterEncodingFilter characterEncodingFilter(){
//        CharacterEncodingFilter filter = new OrderedCharacterEncodingFilter();
//        filter.setEncoding(this.properties.getCharset().name());
//        filter.setForceRequestEncoding(this.properties.shouldForce(org.springframework.boot.web.servlet.server.Encoding.Type.REQUEST));
//        filter.setForceResponseEncoding(this.properties.shouldForce(org.springframework.boot.web.servlet.server.Encoding.Type.RESPONSE));
//        return filter;
//    }
}

