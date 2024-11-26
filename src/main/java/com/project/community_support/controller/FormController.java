package com.project.community_support.controller;


import com.project.community_support.dto.request.BankAccountRequest;
import com.project.community_support.dto.request.FormCreationRequest;
import com.project.community_support.dto.request.SpendingRequest;
import com.project.community_support.dto.response.ApiResponse;
import com.project.community_support.dto.response.FormResponse;
import com.project.community_support.dto.response.SpendingResponse;
import com.project.community_support.entity.BankAccount;
import com.project.community_support.service.FormService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/forms")
public class FormController {

    private final FormService formService;

    public FormController(FormService formService) {
        this.formService = formService;
    }

    @PostMapping()
    public ApiResponse<FormResponse> createForm(
            @RequestBody FormCreationRequest request
    ) {
        return ApiResponse.<FormResponse>builder()
                .result(formService.createForm(request))
                .build();
    }

    @GetMapping
    public ApiResponse<List<FormResponse>> getAllForms() {

        return ApiResponse.<List<FormResponse>>builder()
                .result(formService.getAllForms())
                .build();
    }

    @GetMapping("/{formId}")
    public ApiResponse<FormResponse> getForm(@PathVariable String formId) {
        return ApiResponse.<FormResponse>builder()
                .result(formService.getFormById(formId))
                .build();
    }

    @PostMapping("/{formId}/organization/{organizationId}")
    public ApiResponse<FormResponse> assignOrganization(
            @PathVariable String formId,
            @PathVariable String organizationId,
            @RequestBody BankAccountRequest bankAccountRequest

            ) {
        return ApiResponse.<FormResponse>builder()
                .result(formService.assignOrganization(formId, organizationId, bankAccountRequest))
                .build();
    }

    @GetMapping("/organization/{organizationId}")
    public ApiResponse<List<FormResponse>> getFormByOrganizationId(@PathVariable String organizationId){
        return ApiResponse.<List<FormResponse>>builder()
                .result(formService.getFormByOrganizationId(organizationId))
                .build();
    }

    @PostMapping("/spending/{formId}")
    public ApiResponse<FormResponse> spending(
            @PathVariable String formId,
            @RequestBody SpendingRequest spendingRequest
            ) {
        return ApiResponse.<FormResponse>builder()
                .result(formService.spending(formId, spendingRequest))
                .build();
    }

    @GetMapping("/spending/{formId}")
    public ApiResponse<SpendingResponse> getSpending(
            @PathVariable String formId
    ) {
        return ApiResponse.<SpendingResponse>builder()
                .result(formService.getSpending(formId))
                .build();
    }

}
