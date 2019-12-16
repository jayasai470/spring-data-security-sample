package com.example.springdatasecurity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.Email;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "userprofiles")
public class UserProfile {

    @Id
    @Field("_id")
    private String id;

    @Email(message = "not a valid email")
    @Indexed(unique = true, name = "email_1", background = true)
    private String email;

    private String tenantId;
}