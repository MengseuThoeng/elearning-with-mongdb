package org.ite.elearning.domain;


import lombok.*;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
public class Video {

    private Integer orderNo;

    private String lectureNo;

    private String title;

    private String fileName;
}
