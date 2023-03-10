package com.fullstack.mockinterviewservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contact {
    private Long id;
    private String emailF;
    private String nameF;
    private String iconF;
    private String emailS;
    private String nameS;
    private String iconS;
}
