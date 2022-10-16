package dev.abidino.user;

public record UserDto(Long id,
                      String username,
                      String email) {

    User toUser() {
        User user = new User();
        user.email = this.email;
        user.username = this.username;
        user.id = this.id;
        return user;
    }
}
