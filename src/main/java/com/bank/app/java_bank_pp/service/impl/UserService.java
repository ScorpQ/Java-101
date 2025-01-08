package com.bank.app.java_bank_pp.service.impl;

import com.bank.app.java_bank_pp.dto.UserRequest;
import com.bank.app.java_bank_pp.dto.BankResponse;
import com.bank.app.java_bank_pp.dto.EnquiryRequest;

public interface UserService {
    BankResponse createAccount(UserRequest request);
    BankResponse balanceEnquiry(EnquiryRequest request);
    String nameEnquiry(EnquiryRequest request);
}
 