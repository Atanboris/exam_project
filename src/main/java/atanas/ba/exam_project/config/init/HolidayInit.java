package atanas.ba.exam_project.config.init;

import atanas.ba.exam_project.config.DateNagerConfig;
import atanas.ba.exam_project.models.dto.HolidayDateDTO;
import atanas.ba.exam_project.service.HolidayDateService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HolidayInit implements CommandLineRunner {
    private final RestTemplate restTemplate;
    private final DateNagerConfig dateNagerConfig;
    private final HolidayDateService holidayDateService;
    public HolidayInit(RestTemplate restTemplate, DateNagerConfig dateNagerConfig, HolidayDateService holidayDateService) {
        this.restTemplate = restTemplate;
        this.dateNagerConfig = dateNagerConfig;
        this.holidayDateService = holidayDateService;
    }
    @Override
    public void run(String... args) throws Exception {

        if(dateNagerConfig.isEnabled()){

            String dateNagerURLTemplate =
                    dateNagerConfig.getSchema()
                    + "://"
                    + dateNagerConfig.getHost()
                    + dateNagerConfig.getPath()
                    + dateNagerConfig.getYear() +
                            "/"
                            + dateNagerConfig.getCountry();



            HolidayDateDTO[] holidayDatesDTO = restTemplate
                    .getForObject(dateNagerURLTemplate, HolidayDateDTO[].class);

            this.holidayDateService.refreshDates(holidayDatesDTO);
        }

    }
}
