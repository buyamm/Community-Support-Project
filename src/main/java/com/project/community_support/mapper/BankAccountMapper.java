package com.project.community_support.mapper;

import com.project.community_support.dto.request.BankAccountRequest;
import com.project.community_support.dto.response.BankAccountResponse;
import com.project.community_support.dto.response.OrganizationResponse;
import com.project.community_support.entity.BankAccount;
import com.project.community_support.entity.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface BankAccountMapper {

    @Mapping(target = "form", ignore = true)
    BankAccount toBankAccount(BankAccountRequest request);

    BankAccountResponse toBankAccountResponse(BankAccount bankAccount);

}
