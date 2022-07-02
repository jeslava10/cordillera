package com.cordillera.domain.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table
public class User {

  @Id
  private Long id;

  private String name;

  private String address;

}
