package com.launchacademy.javaspringvalidations.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;


@Entity
@Table(name="contractors")
@Getter
@Setter
public class Contractor {
  @Id
  @SequenceGenerator(name="contractor_generator", sequenceName="contractors_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="contractor_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @Column(name="first_name", nullable = false)
  @NotBlank(message = "Did ya forget your name son?")
  private String firstName;

  @Column(name="last_name", nullable = false)
  @NotBlank(message = "Even Madonna has a last name!")
  private String lastName;

  @Column(name="email_address", nullable = false)
  @Email
  @NotBlank(message = "Where does your internet live?")
  private String emailAddress;

  @Column(name="postal_code")
  @Length(min = 5, max = 5, message = "You're in America... That doesn't fly around here")
  private String postalCode;

  @Column(name="weekly_hours_available")
  @Range(min = 5, max = 80, message = "Too much pressure guys!")
  private Integer weeklyHoursAvailable;

  @Column
  @Length(max = 300, message = "Don't force it!")
  private String bio;
}
