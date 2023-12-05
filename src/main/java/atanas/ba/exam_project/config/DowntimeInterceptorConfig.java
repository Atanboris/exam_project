package atanas.ba.exam_project.config;

import atanas.ba.exam_project.config.Interceptors.DowntimeInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class DowntimeInterceptorConfig implements WebMvcConfigurer {

    private final DowntimeInterceptor downtimeInterceptor;

    public DowntimeInterceptorConfig(DowntimeInterceptor downtimeInterceptor) {
        this.downtimeInterceptor = downtimeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(downtimeInterceptor);
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
