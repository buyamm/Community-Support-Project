package com.project.community_support.controller;


import com.project.community_support.dto.request.FormCreationRequest;
import com.project.community_support.dto.response.ApiResponse;
import com.project.community_support.service.FormService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/forms")
public class FormController {

    private final FormService formService;

    public FormController(FormService formService) {
        this.formService = formService;
    }

    @PostMapping()
    public ApiResponse<String> createForm(
            @RequestBody FormCreationRequest request
    ) {
        formService.createForm(request);
        return ApiResponse.<String>builder()
                .result("Form has been created")
                .build();
    }

    @GetMapping
    public void getAllForms() {

    }

    @GetMapping("/{formId}")
    public void getForm(@PathVariable String formId) {

    }
}
