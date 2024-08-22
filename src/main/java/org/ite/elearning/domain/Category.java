package org.ite.elearning.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "categories")
@Data
@NoArgsConstructor
public class Category {

    @Id
    private String id;

    private String name;

    private String icon;

    private Boolean isDeleted;
}
