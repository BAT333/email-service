package com.example.email.domain;


import com.example.email.model.DataEmailDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "emails")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class EmailEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(name = "owner_Ref",nullable = false)
    private String ownerRef;
    @Column(name = "email_from",nullable = false)
    private String emailFrom;
    @Column(name = "email_to",nullable = false)
    private String emailTo;
    @Column(name = "subject")
    private String subject;
    @Column(name = "sendDate",nullable = false)
    private LocalDateTime sendDateEmail;
    @Column(name = "texts", columnDefinition = "TEXT",nullable = false)
    private String text;
    @Column(name = "status",nullable = false)
    private StatusEmail statusEmail;

    public EmailEntity(DataEmailDTO dto, String from) {
        this.emailFrom =from;
        this.ownerRef = dto.ownerRef();
        this.emailTo = dto.emailTo();
        this.subject = dto.subject();
        this.sendDateEmail = LocalDateTime.now();
        this.text = dto.text();
    }
    public EmailEntity(DataEmailDTO dto, StatusEmail statusEmail,String from) {
        this.emailFrom =from;
        this.ownerRef = dto.ownerRef();
        this.emailTo = dto.emailTo();
        this.subject = dto.subject();
        this.sendDateEmail = LocalDateTime.now();
        this.text = dto.text();
        this.statusEmail = statusEmail;
    }

    public EmailEntity(String from, String emailTO, String validEmail, String user) {
        this.emailFrom =from;
        this.ownerRef = emailTO;
        this.emailTo = emailTO;
        this.subject =validEmail ;
        this.sendDateEmail = LocalDateTime.now();
        this.text = user;
    }
}
