package com.example.tmf629.model.contactmedium;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class PhoneContactMedium extends ContactMedium {
    private String phoneNumber;
}
