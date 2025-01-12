package com.bank.app.java_bank_pp.service.impl;

import com.bank.app.java_bank_pp.dto.UserRequest;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import com.bank.app.java_bank_pp.entity.User;
import com.bank.app.java_bank_pp.dto.AccountInfo;
import com.bank.app.java_bank_pp.dto.BankResponse;
import com.bank.app.java_bank_pp.repository.UserRepository;
import com.bank.app.java_bank_pp.utils.AccountUtils;
import com.bank.app.java_bank_pp.dto.EmailDetails;
import com.bank.app.java_bank_pp.dto.EnquiryRequest;
 
public class UserServiceImpl implements UserService {

    //@Autowired kullanmazsak interface'i bu şekilde ekleriz.
    private final EmailService emailService; 
    public UserServiceImpl(EmailService emailService){
        this.emailService = emailService;
    }

    //@Autowired kullanırsak interface'i bu şekilde ekleriz.
    @Autowired
    private UserRepository userRepository;

    @Override
    public BankResponse createAccount(UserRequest userRequest){

        if(userRepository.existsByEmail(userRequest.getEmail())){
            return BankResponse.builder()
            .responseCode(AccountUtils.ACCOUNT_EXISTS_CODE)
            .responseMessage(AccountUtils.ACCOUNT_EXISTS_MESSAGE)
            .accountInfo(null)
            .build();
        }

        User newUser = User.builder()
        .firstName(userRequest.getFirstName())
        .lastName(userRequest.getLastName())
        .otherName(userRequest.getOtherName())
        .gender(userRequest.getGender())
        .address(userRequest.getAddress())
        .email(userRequest.getEmail())
        .phoneNumber(userRequest.getPhoneNumber())
        .alternativePhoneNumber(userRequest.getAlternativePhoneNumber())
        .status("ACTIVE")
        .stateOfOrigin(userRequest.getStateOfOrigin())
        .accountNumber(AccountUtils.generateAccountNumber())
        .accountBalance(BigDecimal.ZERO)
        .build();

        User savedUser = userRepository.save(newUser);

        AccountInfo accountInfo = AccountInfo.builder()
        .accountBalance(savedUser.getAccountBalance())
        .accountNumber(savedUser.getAccountNumber())
        .accountName(savedUser.getFirstName() + " " + savedUser.getLastName())
        .build();

        EmailDetails emailDetails = EmailDetails.builder()
        .recipient(savedUser.getEmail())
        .msgBody(AccountUtils.ACCOUNT_CREATION_SUCCESS_MESSAGE)
        .subject("Account Creation")
        .build();

        emailService.sendEmail(emailDetails);
        
        return BankResponse.builder()
        .responseCode(AccountUtils.ACCOUNT_CREATION_SUCCESS_CODE)
        .responseMessage(AccountUtils.ACCOUNT_CREATION_SUCCESS_MESSAGE)
        .accountInfo(accountInfo)
        .build();
    }

    @Override
    public BankResponse balanceEnquiry(EnquiryRequest request){
        boolean isAccountExist = userRepository.existsByAccountNumber(request.getAccountNumber());
        if(!isAccountExist){
            return BankResponse.builder()
            .responseCode(AccountUtils.ACCOUNT_NOT_EXISTS_CODE)
            .responseMessage(AccountUtils.ACCOUNT_NOT_EXISTS_MESSAGE)
            .accountInfo(null)
            .build();
        }

        User foundUser = userRepository.findByAccountNumber(request.getAccountNumber());
        return null;
    }

    @Override
    public String nameEnquiry(EnquiryRequest request){
        return "er";
    }
    
}

