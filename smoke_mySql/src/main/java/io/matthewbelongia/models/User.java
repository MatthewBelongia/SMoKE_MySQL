package io.matthewbelongia.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * An entity Item composed by five fields (id, email, firstname,lastname,password).
 * The Entity annotation indicates that this class is a JPA entity.
 * The Table annotation specifies the firstname for the table in the db.
 *
 * @author netgloo
 */
@Entity
@Table(name = "user")
public class User {

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------
  
  // An autogenerated id (unique for each user in the db)
  @Id
  //@GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  // The user's email
  @NotNull
  private String email;
  
  // The user's firstname
  @NotNull
  private String firstname;

  // The user's lastname
  @NotNull
  private String lastname;

  // The user's password
  @NotNull
  private String password;



  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  
  public User() { }

  public User(long id) { 
    this.id = id;
  }
  
  public User(String email, String firstname,String lastname,String password) {
    this.email = email;
    this.firstname = firstname;
    this.lastname = lastname;
    this.password = password;
  }

  // Getter and setter methods

  public long getId() {
    return id;
  }

  public void setId(long value) {
    this.id = value;
  }

  public String getEmail() {
    return email;
  }
  
  public void setEmail(String value) {
    this.email = value;
  }
  
  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String value) {
    this.firstname = value;
  }


  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

} // class User
