package dev.abidino.user;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
record UserController(UserService userService) {

    @PostMapping
    UserDto save(@RequestBody UserDto userDto) {
        User savedUser = userService.save(userDto.toUser());
        return savedUser.toUserDto();
    }

    @PutMapping("/{id}")
    UserDto update(@RequestBody UserDto userDto, Long id) {
        User updatedUser = userService.update(id, userDto.toUser());
        return updatedUser.toUserDto();
    }

    @GetMapping("/{id}")
    UserDto get(@PathVariable Long id) {
        User user = userService.findById(id);
        return user.toUserDto();
    }
}
