package com.cordillera.domain.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "usercodillera")
@Builder
@AllArgsConstructor()
@NoArgsConstructor
@Getter
@Setter
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String address;

}
