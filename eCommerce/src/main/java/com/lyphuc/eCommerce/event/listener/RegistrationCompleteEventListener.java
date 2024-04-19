package com.lyphuc.eCommerce.event.listener;

import com.lyphuc.eCommerce.registration.RegistrationCompleteEvent;
import com.lyphuc.eCommerce.registration.token.VerificationTokenService;
import com.lyphuc.eCommerce.user.UserEntity;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {
    private final VerificationTokenService verificationTokenService;
    private final JavaMailSender javaMailSender;
    private UserEntity user;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //1. get user
        user = event.getUserEntity();
        //2. generate a token for the user
        String vToken = UUID.randomUUID().toString();
        //3. save token
        verificationTokenService.saveVerificationTokenForUser(user, vToken);
        //4. build the verification url
        String url = event.getConfirmationUrl()+"/registration/verifyEmail?token"+vToken;
        //5. send email for user
        try {
            sendVerificationEmail(url);
        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    public void sendVerificationEmail(String url) throws MessagingException, UnsupportedEncodingException{
        String subject = "Email Verification";
        String senderName = "User Verification Service";
        String mailContent = "<p> Hi, "+user.getFirstName() + ", </p>"+
                "<p>Thank you for registering with us,"+""+
                "Please, follow the link below to complete your registration. </p>"+
                "<a href=\""+url+"\">Verify your email to activate your account</a>"+
                "<p> Thank you <br> Users Registration Portal Service";
        emailmessage(subject,senderName,mailContent,javaMailSender,user);
    }

    private static void emailmessage(String subject, String senderName, String mailContent, JavaMailSender javaMailSender, UserEntity user) throws MessagingException,UnsupportedEncodingException{
        MimeMessage message = javaMailSender.createMimeMessage();
        var messageHelper = new MimeMessageHelper(message);
        messageHelper.setFrom("lyphuc823@gmail.com",senderName);
        messageHelper.setTo(user.getEmail());
        messageHelper.setSubject(subject);
        messageHelper.setText(mailContent,true);
        javaMailSender.send(message);
    }
}
