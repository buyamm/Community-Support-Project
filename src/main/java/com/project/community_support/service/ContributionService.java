package com.project.community_support.service;

import com.project.community_support.dto.request.ContributionRequest;
import com.project.community_support.dto.response.ContributionResponse;
import com.project.community_support.entity.Contribution;
import com.project.community_support.entity.Form;
import com.project.community_support.entity.Images;
import com.project.community_support.exception.AppException;
import com.project.community_support.exception.ErrorCode;
import com.project.community_support.repository.ContributionRepository;
import com.project.community_support.repository.FormRepository;
import com.project.community_support.repository.ImageRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ContributionService {

    private final FormRepository formRepository;
    private final ContributionRepository contributionRepository;
    private final ImageRepository imageRepository;

    public ContributionService(FormRepository formRepository, ContributionRepository contributionRepository, ImageRepository imageRepository) {
        this.formRepository = formRepository;
        this.contributionRepository = contributionRepository;
        this.imageRepository = imageRepository;
    }

    public ContributionResponse createContribution(ContributionRequest contributionRequest) {
        Form form = formRepository.findById(contributionRequest.getFormId()).orElseThrow(
                () -> new AppException(ErrorCode.FORM_NOT_FOUND)
        );

        if (form.getOrganization() == null) {
            throw new AppException(ErrorCode.FORM_NOT_ACCEPTED);
        }
        Contribution contribution = new Contribution();
        contribution.setContent(contributionRequest.getContent());
        contribution.setAmount(contributionRequest.getAmount());
        contribution.setDate(contributionRequest.getDate());
        contribution.setForm(formRepository.findById(contributionRequest.getFormId()).orElseThrow());
        contributionRepository.save(contribution);

        contributionRequest.getImages().forEach(i -> {
            Images image = new Images();
            image.setContribution(contribution);
            image.setPath(i);
            imageRepository.save(image);
        });

        return ContributionResponse.builder()
                .id(contribution.getId())
                .content(contribution.getContent())
                .amount(contribution.getAmount())
                .date(contribution.getDate())
                .form(
                        Map.of(
                                "id", form.getId(),
                                "fullName", form.getFullName()
                        )
                )
                .images(contributionRequest.getImages())
                .build();
    }
}
