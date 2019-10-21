package com.shonan.config;

import com.shonan.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
  // 读取到配置里面的静态资源访问路径
//  @Value("${spring.mvc.static-path-pattern}")
//  private String staticPathPattern;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    //拦截带有admin/所有的请求路径
    registry.addInterceptor(new LoginInterceptor())
            .addPathPatterns("/admin/**")
            .excludePathPatterns("/admin")
            .excludePathPatterns("/admin/login")
//            .excludePathPatterns("/static/admin/blogs").excludePathPatterns("/admin/blogs/input")
            .excludePathPatterns("/static/dist/**").excludePathPatterns("/static/plugins/**")
            .excludePathPatterns("/static/blog/amaze/**").excludePathPatterns("/static/blog/plugins/**")
            .excludePathPatterns("/static/js/**")
            .excludePathPatterns("/static/lib/**");
  }
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    //配置静态资源映射
   /* registry.addResourceHandler("/css/animate.css", "/css/me.css", "/css/typo.css").addResourceLocations("classpath:/static/");
    registry.addResourceHandler("/images/aliPayCode.png", "/images/payCode2.png", "/images/wechat.jpg", "/images/shonan.jpg").addResourceLocations("classpath:/static/");
    registry.addResourceHandler("/lib/**").addResourceLocations("classpath:/static/lib/");
    registry.addResourceHandler("/admin/plugins/jqgrid-5.3.0/jquery.jqGrid.min.js", "/admin/plugins/jquery/jquery.min.js",
            "/admin/plugins/jqgrid-5.3.0/grid.locale-cn.js", "/admin/plugins/jQueryUI/jquery-ui.min.js", "/admin/plugins/bootstrap/js/bootstrap.bundle.min.js",
            "/admin/plugins/sweetalert/sweetalert.min.js");
    registry.addResourceHandler("/static/admin/*","/admin/**" ).addResourceLocations("classpath:/static/admin/");
    registry.addResourceHandler("/admin/dist/**").addResourceLocations("classpath:/static/admin/dist/");
    registry.addResourceHandler("/admin/plugizns").addResourceLocations("classpath:/static/admin/plugins");
    registry.addResourceHandler("/adminlte.min.js", "public.js", "comment.js").addResourceLocations("classpath:/static/admin/js/");
    registry.addResourceHandler("/static/admin/**").addResourceLocations("classpath:/static/admin/");
    registry.addResourceHandler("/admin/dist/js/**").addResourceLocations("classpath:/static/admin/js");
    registry.addResourceHandler("/admin/plugins/**").addResourceLocations("classpath:/static/admin/plugins");
*/
    registry.addResourceHandler("/css/animate.css", "/css/me.css", "/css/typo.css").addResourceLocations("classpath:/static/");
    registry.addResourceHandler("/images/aliPayCode.png", "/images/payCode2.png", "/images/wechat.jpg", "/images/shonan.jpg").addResourceLocations("classpath:/static/");
    registry.addResourceHandler("/lib/**").addResourceLocations("classpath:/static/lib/");
/*    registry.addResourceHandler("/static/plugins/jqgrid-5.3.0/jquery.jqGrid.min.js", "/static/plugins/jquery/jquery.min.js",
            "/static/plugins/jqgrid-5.3.0/grid.locale-cn.js", "/static/plugins/jQueryUI/jquery-ui.min.js", "/static/plugins/bootstrap/js/bootstrap.bundle.min.js",
            "/static/plugins/sweetalert/sweetalert.min.js");*/
//    registry.addResourceHandler("/static/*" ).addResourceLocations("classpath:/static/");
    registry.addResourceHandler("/admin/dist/**").addResourceLocations("classpath:/static/admin/dist/");
    registry.addResourceHandler("/admin/plugins/**").addResourceLocations("classpath:/static/admin/plugins/");
    registry.addResourceHandler("/adminlte.min.js", "public.js", "comment.js").addResourceLocations("classpath:/static/dist/js/");
    registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//    registry.addResourceHandler("/dist/ js/**").addResourceLocations("classpath:/static/dist/js/");
//    registry.addResourceHandler("/static/plugins/**").addResourceLocations("classpath:/static/plugins");
    registry.addResourceHandler("/static/blog/**").addResourceLocations("classpath:/static/blog/");
//    registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    registry.addResourceHandler("/editormd.min.js").addResourceLocations("classpath:/static/lib/editormd/editormd.min.js");
    registry.addResourceHandler("/static/lib/editormd/**").addResourceLocations("classpath:/static/lib/editormd/");
    registry.addResourceHandler("/codemirror/**").addResourceLocations("classpath:/static/lib/editormd/lib/codemirror/");
    registry.addResourceHandler("/blog/plugins/comment/**").addResourceLocations("classpath:/static/blog/plugins/comment/");
  }
}
