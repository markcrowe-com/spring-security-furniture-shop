package io.gitlab.markcrowe.furniture.shop.app.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SimpleUser {
    private String password;
    private String roles;
    private String username;
}
