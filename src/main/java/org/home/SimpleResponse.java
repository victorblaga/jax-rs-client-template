package org.home;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class SimpleResponse {
    private String key;
    private ZonedDateTime date;
}
