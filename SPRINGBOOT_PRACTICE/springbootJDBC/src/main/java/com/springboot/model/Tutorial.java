package com.springboot.model;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Tutorial {
    private long id;
    private String title;
    private String description;
    private boolean published;

    public Tutorial(String title, String description, boolean published) {
        this.title=title;
        this.description=description;
        this.published = published;
    }

}
