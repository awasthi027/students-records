package com.studentinfo.models;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class TodoInfo {
    private String firstName;
    private String lastName;
    private String message;

}
