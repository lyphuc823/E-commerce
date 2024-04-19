package com.lyphuc.eCommerce.registration;

import com.lyphuc.eCommerce.user.UserEntity;
import lombok.*;
import org.springframework.context.ApplicationEvent;
@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent {
    private UserEntity userEntity;
    private String confirmationUrl;
    public RegistrationCompleteEvent(UserEntity userEntity, String confirmationUrl) {
        super(userEntity);
        this.userEntity = userEntity;
        this.confirmationUrl = confirmationUrl;
    }
}
