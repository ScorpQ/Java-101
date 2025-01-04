package com.bank.app.java_bank_pp.dto;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


// DTO: Data Transfer Object
// Veri transferi için kullanılan bir yapıdır.

@Data // Get ve Set metotlarını otomatik oluşturur ve ekstra methodlar da ekler. toString, equals, hashCode gibi.
@Builder // Builder sayesinde obje oluştururken set metodlarını kullanmaya gerek yoktur. Object oluştururken field'ları setleyebiliriz.
@AllArgsConstructor // Tüm field'ları constructor ile set edebiliriz.
@NoArgsConstructor // Parametresiz constructor oluşturur. Olmazsa object oluşturulamaz.
    
public class BankResponse {
    private String responseCode;
    private String responseMessage;
    private AccountInfo accountInfo;
}
