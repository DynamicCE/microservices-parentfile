package com.erkan.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "Cards", description = "Schema to hold Card information")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardsDto {

    private String cardNumber;
    private String cardType;
    private String mobileNumber;
    private int totalLimit;
    private int amountUsed;
    private int availableAmount;
}
