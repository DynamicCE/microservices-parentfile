package com.erkan.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "Response", description = "Schema to hold API response information")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {

    @Schema(description = "Status code of the API response")
    private String statusCode;

    @Schema(description = "Status message of the API response")
    private String statusMsg;
}
