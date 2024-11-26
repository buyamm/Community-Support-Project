package com.project.community_support.controller;

import com.project.community_support.dto.request.ContributionRequest;
import com.project.community_support.dto.response.ApiResponse;
import com.project.community_support.dto.response.ContributionResponse;
import com.project.community_support.service.ContributionService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/contributions")
public class ContributionController {

    private final ContributionService contributionService;

    public ContributionController(ContributionService contributionService) {
        this.contributionService = contributionService;
    }

    @PostMapping()
    public ApiResponse<ContributionResponse> createContribution(@RequestBody ContributionRequest contributionRequest) {
        return ApiResponse.<ContributionResponse>builder()
                .result(contributionService.createContribution(contributionRequest))
                .build();
    }
}
