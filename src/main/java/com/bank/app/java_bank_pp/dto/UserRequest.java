package com.bank.app.java_bank_pp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

// DTO: Data Transfer Object
// Veri transferi için kullanılan bir yapıdır.

@Data // Get ve Set metotlarını otomatik oluşturur ve ekstra methodlar da ekler. toString, equals, hashCode gibi.
@Builder // Builder sayesinde obje oluştururken set metodlarını kullanmaya gerek yoktur. Object oluştururken field'ları setleyebiliriz.
@AllArgsConstructor // Tüm field'ları constructor ile set edebiliriz.
@NoArgsConstructor // Parametresiz constructor oluşturur. Olmazsa object oluşturulamaz.
    
public class UserRequest {
    private String firstName;
    private String lastName;
    private String otherName;
    private String gender;
    private String address;
    private String stateOfOrigin;
    
    private String email;
    private String phoneNumber;
    private String alternativePhoneNumber;
    private String status;
}
