package com.bank.app.java_bank_pp.entity; 

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;  
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter // Lombok sayesinde get ve set metotlarını otomatik oluşturur
@Setter // Dolayısıyla aşağıdaki kodları yazmaya gerek yoktur. 
// FAKAT @Builder varken gerek kalmıyor.
//public String getFirstName() {
//     return firstName;
// }

// public void setFirstName(String firstName) {
//     this.firstName = firstName;
// }

@NoArgsConstructor // Parametresiz constructor oluşturur. Olmazsa object oluşturulamaz.
// public User () {
        
// }

@AllArgsConstructor // Bütün parametreleri alan constructor oluşturur.
@Builder // Builder sayesinde obje oluştururken set metodlarını kullanmaya gerek yoktur. Object oluştururken field'ları setleyebiliriz.
@Entity // ORM yapısı için gereklidir sanırım. (Tablo oluştururken kullanılıyor)
@Table(name = "users") // Tablo adını belirtiriz. // AMA ŞİMDİLİK COMMENT YAPICAM BAKALIM NE OLACAK
public class User {

    @Id // Primary key olduğunu belirtir.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String otherName;
    private String gender;
    private String address;
    private String stateOfOrigin;
    private String accountNumber;
    private BigDecimal accountBalance;
    private String email;
    private String phoneNumber;
    private String alternativePhoneNumber;
    private String status;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime dateUpdated;
}

