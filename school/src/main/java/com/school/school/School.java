package com.school.school;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class School {

    private String id;
    private String schoolName;
    private String location;
    private String principalName;
}
