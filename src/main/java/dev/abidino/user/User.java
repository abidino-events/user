package dev.abidino.user;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique = true)
    String username;

    @Column(unique = true)
    String email;


    UserDto toUserDto() {
        return new UserDto(this.id, this.email, this.email);
    }

}
