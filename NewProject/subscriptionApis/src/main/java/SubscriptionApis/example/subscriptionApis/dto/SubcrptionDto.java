package SubscriptionApis.example.subscriptionApis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubcrptionDto {
    private Long id ;
    private String SubscriptionType;
    private Boolean isActive;
    private LocalDate StartingDate;
    private LocalDate EndDate;
}
