package com.studentinfo.models;

import lombok.*;

import java.util.List;
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor @ToString

public class NewsSummary {
    String status;
    int totalResults;
    List <Article> articles;
}
