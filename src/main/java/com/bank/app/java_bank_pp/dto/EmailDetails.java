package com.bank.app.java_bank_pp.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetails {
    private String recipient;
    private String msgBody;
    private String subject;
    private String attachment;
}
