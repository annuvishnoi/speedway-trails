package com.galvanize.speedway.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SpeedWayResponse {
    private String status;
    private int status_code;
    private Object data;
}
