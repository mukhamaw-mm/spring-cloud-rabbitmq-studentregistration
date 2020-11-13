package com.mukham.springcloudrabbitmq.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;


public interface StudentRegistrationSource {
    @Output("studentRegistrationChannel")
    MessageChannel studentRegistration();
}
