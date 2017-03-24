package poc.logging.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import poc.logging.models.Data;

/**
 * Created by 310280812 on 3/17/2017.
 */
@Slf4j
@Service
public class StoreService {


    public Data saveOrUpdate(Data data) {
      log.info("[StoreService] Saving the data: {}",data);
      data.setId(10L);
      log.info("[StoreService]Data stored: {}", data);
      return data;
    }

}
