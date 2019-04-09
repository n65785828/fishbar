package top.study01.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.*;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Configuration
public class MySpringBootConfig {


    /**
     * 配置druid数据源
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "druid")
    public DataSource dataSource(){
        DruidDataSource  dataSource = new DruidDataSource();
        return dataSource;
    }


    //配置Druid的监控
//1、配置一个管理后台的Servlet
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),
                "/druid/*");
        Map<String,String> initParams = new HashMap<>();
        initParams.put("loginUsername","admin");
        initParams.put("loginPassword","123456");
        initParams.put("allow","");//默认就是允许所有访问
        //initParams.put("deny","192.168.15.21");//禁止某ip访问
        bean.setInitParameters(initParams);
        return bean;
    }
    //2、配置一个web监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String,String> initParams = new HashMap<>();
        initParams.put("exclusions","*.js,*.css,/druid/*,*.png,*.icon,*jpeg,*.jpg");
        bean.setInitParameters(initParams);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }


    /**
     * 配置额外的视图解析器
     * 添加映射规则
     * @return
     */
    @Bean
    public WebMvcConfigurer myWebMvcConfigurer(){
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
//                registry.addViewController("/home").setViewName("home");
//                registry.addViewController("/portfolio").setViewName("portfolio");
                registry.addViewController("/index.html").setViewName("index");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(handlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/","/index.html","/login","/index","/asserts/**");
            }

        };
        return webMvcConfigurer;
    }


    /**
     * 自定义地区语言解析器
     * @return
     */
    @Bean
    public LocaleResolver localeResolver(){
        LocaleResolver myLocaleResolver = new LocaleResolver() {
            @Override
            public Locale resolveLocale(HttpServletRequest httpServletRequest) {
                String l = httpServletRequest.getParameter("l");
                if(l==null){
                    return Locale.getDefault();
                }
                if(l.equals("zh_CN")){
                    return Locale.SIMPLIFIED_CHINESE;
                }

                if(l.equals("en_US")){
                    return Locale.US;
                }
                return Locale.getDefault();
            }

            @Override
            public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

            }

        };
        return myLocaleResolver;
    }

    /**
     * 拦截未登录，重定向至首页
     * @return
     */
    public HandlerInterceptor handlerInterceptor(){
        HandlerInterceptor handlerInterceptor = new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                if(request.getSession().getAttribute("user")!=null){
                    return true;
                }
                response.sendRedirect("index.html");
                return false;
            }

            @Override
            public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

            }

            @Override
            public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

            }
        };
        return handlerInterceptor;
    }

    /**
     * 文件上传配置
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 设置文件大小限制 ,超出设置页面会抛出异常信息，
        // 这样在文件上传的地方就需要进行异常信息的处理了;
        factory.setMaxFileSize("15MB"); // KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("20MB");
        // Sets the directory location where files will be stored.
        // factory.setLocation("路径地址");
        return factory.createMultipartConfig();
    }

}
