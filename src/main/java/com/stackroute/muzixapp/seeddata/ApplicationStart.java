package com.stackroute.muzixapp.seeddata;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.repository.MuzixRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;




@Component
public class ApplicationStart implements ApplicationListener<ApplicationReadyEvent>, CommandLineRunner {
    @Value("${track.1.trackName:default}")
    String name1;
    @Value("${track.1.trackComments:default}")
    String comments1;
    @Value("${track.2.trackName:default}")
    String name2;
    @Value("${track.2.trackComments:default}")
    String comments2;
    private static final Logger logger = LoggerFactory.getLogger(ApplicationStart.class);
    @Autowired
    private MuzixRepository repository;
    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        repository.save(new Track(1, name1,comments1 ));
        repository.save(new Track(2, name2,  comments2));
    }
    @Override
    public void run(String... args) throws Exception {
        final Log logger = LogFactory.getLog(getClass());
        logger.info("Application Started ..............!");

    }
}

