package com.spring.todolist.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class TodoSearchOption {
    // private String searchType;
    private String keyword;
}
