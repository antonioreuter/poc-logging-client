package poc.logging.controllers.api.v1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import poc.logging.auditing.AuditController;
import poc.logging.models.Data;
import poc.logging.services.StoreService;

import javax.validation.Valid;

/**
 * Created by 310280812 on 3/17/2017.
 */

@Slf4j
@RequestMapping(value = "/api/v1/processData")
@RestController("processDataController")
public class ProcessDataController {

    @Autowired
    private StoreService storeService;

    @AuditController
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public Data saveOrUpdate(@Valid @RequestBody Data data) {
      log.info("Request to store data: {}", data);
      data = storeService.saveOrUpdate(data);
      log.info("Data Stored: {}", data);
      return data;
    }
}
