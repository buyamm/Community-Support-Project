package com.project.community_support.mapper;

import com.project.community_support.dto.request.BankAccountRequest;
import com.project.community_support.dto.request.SpendingRequest;
import com.project.community_support.dto.response.BankAccountResponse;
import com.project.community_support.dto.response.SpendingResponse;
import com.project.community_support.entity.BankAccount;
import com.project.community_support.entity.Spending;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface SpendingMapper {

    @Mapping(target = "form", ignore = true)
    Spending toSpending(SpendingRequest request);

    @Mapping(target = "form", ignore = true)
    SpendingResponse toSpendingResponse(Spending spending);

}
