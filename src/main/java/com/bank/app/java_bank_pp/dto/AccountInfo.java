package com.bank.app.java_bank_pp.dto;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;

@Data // Get ve Set metotlarını otomatik oluşturur ve ekstra methodlar da ekler. toString, equals, hashCode gibi.
@Builder // Builder sayesinde obje oluştururken set metodlarını kullanmaya gerek yoktur. Object oluştururken field'ları setleyebiliriz.
@AllArgsConstructor // Tüm field'ları constructor ile set edebiliriz.
@NoArgsConstructor // Parametresiz constructor oluşturur. Olmazsa object oluşturulamaz.

public class AccountInfo {
    private String accountName;
    private BigDecimal accountBalance;
    private String accountNumber;
    
}
