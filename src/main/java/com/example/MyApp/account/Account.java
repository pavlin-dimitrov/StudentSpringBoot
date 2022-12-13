//package com.example.MyApp.account;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@ToString
//@Entity
////@Table
//public class Account {
//
//  @Id
//  @SequenceGenerator(
//      name = "account_sequence",
//      sequenceName = "account_sequence",
//      allocationSize = 1)
//  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_sequence")
//  private Long id;
//  @NotNull(message = "must be NOT empty!")
//  @NotBlank(message = "must be NOT empty!")
//  private String name;
//
//  private String email;
//
//  @NotNull @NotBlank
//  private String password;
//
//
//  public Account(String name, String email, String password) {
//    this.name = name;
//    this.email = email;
//    this.password = password;
//  }
//}
