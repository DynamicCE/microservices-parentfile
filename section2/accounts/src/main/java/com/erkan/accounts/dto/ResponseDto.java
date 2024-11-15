package com.erkan.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(name = "Response", description = "Schema to hold API response information")
@Data
@AllArgsConstructor
public class ResponseDto {

    @Schema(description = "Status code of the API response")
    private String statusCode;

    @Schema(description = "Status message of the API response")
    private String statusMsg;
}
