package com.sample.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  private String designation;
  private int age;
  private String city;
}
