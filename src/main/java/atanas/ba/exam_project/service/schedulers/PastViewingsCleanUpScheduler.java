package atanas.ba.exam_project.service.schedulers;

import atanas.ba.exam_project.service.ViewingService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
public class PastViewingsCleanUpScheduler {

    private final ViewingService viewingService;

    public PastViewingsCleanUpScheduler(ViewingService viewingService) {
        this.viewingService = viewingService;
    }

    @Scheduled(timeUnit = TimeUnit.HOURS, fixedDelay =  12)
    public void cleanUp(){
//        System.out.println("Commencing clean up right now!" + LocalDateTime.now());
        viewingService.cleanUpMeetings();
    }
}
