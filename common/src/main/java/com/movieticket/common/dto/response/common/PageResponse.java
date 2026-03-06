package com.movieticket.common.dto.response.common;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageResponse<T> {

    private List<T> content;

    private int page;

    private int pageSize;

    private long totalElements;

    private int totalPages;

    private boolean last;
}