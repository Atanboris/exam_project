package atanas.ba.exam_project.config.Interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDate;
import java.time.LocalTime;


@Component
public class DowntimeInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String fromTime = "15:30:00";
        String toTime = "15:32:00";

        if(LocalTime.now().isBefore(LocalTime.parse(toTime))
        && LocalTime.now().isAfter(LocalTime.parse(fromTime))) {
            return false;
        }
        return true;
    }
}
