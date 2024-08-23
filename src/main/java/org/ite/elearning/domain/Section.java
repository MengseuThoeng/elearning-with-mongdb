package org.ite.elearning.domain;

import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Section {

    private String title;

    private Integer orderNo;

    private List<Video> videos;
}
