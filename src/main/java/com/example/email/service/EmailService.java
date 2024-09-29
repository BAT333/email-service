package com.example.email.service;

import com.example.email.domain.EmailEntity;
import com.example.email.domain.StatusEmail;
import com.example.email.model.DataEmailDTO;
import com.example.email.model.EmailValidDTO;
import com.example.email.repository.EmailRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailService {
    @Autowired
    private EmailRepository repository;
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    public DataEmailDTO sendEmailSave(DataEmailDTO dto) {
        log.info("Sending email saving email");
        EmailEntity email = new EmailEntity(dto,from);
        try {
            var emailDTO =this.sendEmail(dto);
            email.setStatusEmail(StatusEmail.SEND);
        }catch (Exception e){
            email.setStatusEmail(StatusEmail.ERRO);
        }finally {
            email = repository.save(email);
        }
        return new DataEmailDTO(email);
    }

    public DataEmailDTO sendEmail(DataEmailDTO dto) {
        log.info("Sending email");
        SimpleMailMessage message =new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(dto.emailTo());
        message.setSubject(dto.subject());
        message.setText(dto.text());
        mailSender.send(message);
        return dto;
    }
    public DataEmailDTO sendEmailValid(EmailValidDTO dto) {
        log.info("Validating email to see if it's real");
       /* var instant = Instant.now().plusMillis(900000L);
        var user = this.userValidRepository.save(new UserValid(UUID.randomUUID(),dto.emailTo(),instant));
        return this.sendEmailSave(new DataEmailDTO(from,dto.emailTo(),"VALID EMAIL","valid: "+user.getUuid()));

        */
        return null;
    }
    public Boolean validEmail(String uuid) {
        log.info("email being validated: {}", uuid);
        /*var user =  this.userValidRepository.findByUuid(UUID.fromString(uuid));

        if(user.isEmpty()){
        log.error("error if user does not exist");
            throw new EmailException();
        }else {
            if(user.get().getInstant().compareTo(Instant.now())<0){
                //ativa user
                System.out.println(user.get().getInstant().isBefore(Instant.now()));
                System.out.println(user.get().getInstant().compareTo(Instant.now())>=0);
                return true;
            }else {
            log.error("timed out");
                this.userValidRepository.delete(user.get());
                return false;
            }

         */
        return null;
    }


}

