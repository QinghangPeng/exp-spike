# exp-spike
java高并发秒杀方案

# 问题记录
```markdown
1. 当我使用WebMvcConfigurerAdapter进行参数的个性化配置时,发现该方法过时,因此转而使用WebMvcConfigurationSupport,
   此时,功能一切正常,但是静态资源却无法读取,所有的js包,图片等信息都404
解决方案: 阅读源码后发现WebMvcConfigurerAdapter只是对WebMvcConfigurer的空实现,而WebMvcConfigurationSupport在
         实现WebMvcConfigurer接口时,增加了一些更全面的东西,这里面可能就包括对静态资源的拦截
         解决方法为重写addResourceHandlers方法:
         @Override
         protected void addResourceHandlers(ResourceHandlerRegistry registry) {
             registry.addResourceHandler("/**")
                     .addResourceLocations("classpath:/resources/")
                     .addResourceLocations("classpath:/static/")
                     .addResourceLocations("classpath:/templates/");
             super.addResourceHandlers(registry);
         }
```
