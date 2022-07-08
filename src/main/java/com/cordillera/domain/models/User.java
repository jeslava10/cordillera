package com.cordillera.domain.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
@Builder
@AllArgsConstructor()
@NoArgsConstructor
@Getter
@Setter
public class User {

  @Id
  private Long id;

  private String name;

  private String address;

}
