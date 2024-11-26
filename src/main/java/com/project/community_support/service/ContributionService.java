package com.project.community_support.service;

import com.project.community_support.dto.request.ContributionRequest;
import com.project.community_support.dto.response.ContributionResponse;
import com.project.community_support.entity.Contribution;
import com.project.community_support.entity.Form;
import com.project.community_support.entity.User;
import com.project.community_support.exception.AppException;
import com.project.community_support.exception.ErrorCode;
import com.project.community_support.mapper.UserMapper;
import com.project.community_support.repository.ContributionRepository;
import com.project.community_support.repository.FormRepository;
import com.project.community_support.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ContributionService {

    private final FormRepository formRepository;
    private final ContributionRepository contributionRepository;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public ContributionService(FormRepository formRepository, ContributionRepository contributionRepository,
                               UserRepository userRepository, UserMapper userMapper) {
        this.formRepository = formRepository;
        this.contributionRepository = contributionRepository;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public ContributionResponse createContribution(ContributionRequest contributionRequest) {
        Form form = formRepository.findById(contributionRequest.getFormId()).orElseThrow(
                () -> new AppException(ErrorCode.FORM_NOT_FOUND)
        );

        User user = userRepository.findById(contributionRequest.getUserId()).orElseThrow(
                () -> new AppException(ErrorCode.USER_NOT_FOUND)
        );

        if (form.getOrganization() == null) {
            throw new AppException(ErrorCode.FORM_NOT_ACCEPTED);
        }
        Contribution contribution = new Contribution();
        contribution.setContent(contributionRequest.getContent());
        contribution.setAmount(contributionRequest.getAmount());
        contribution.setDate(contributionRequest.getDate());
        contribution.setForm(formRepository.findById(contributionRequest.getFormId()).orElseThrow());
        contribution.setUser(user);
        contributionRepository.save(contribution);

//        contributionRequest.getImages().forEach(i -> {
//            Images image = new Images();
//            image.setContribution(contribution);
//            image.setPath(i);
//            imageRepository.save(image);
//        });

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
                .userResponse(userMapper.toUserResponse(contribution.getUser()))
//                .images(contributionRequest.getImages())
                .build();
    }

    public List<ContributionResponse> getContributionByFormId(String formId) {
        List<Contribution> contributions = contributionRepository.findByFormId(formId);

        return contributions.stream().map(contribution -> {
                    return ContributionResponse.builder()
                            .id(contribution.getId())
                            .content(contribution.getContent())
                            .amount(contribution.getAmount())
                            .date(contribution.getDate())
                            .form(
                                    Map.of(
                                            "id", contribution.getForm().getId(),
                                            "name", contribution.getForm().getFullName()
                                    )
                            )
                            .userResponse(userMapper.toUserResponse(contribution.getUser()))
                            .build();
                }
        ).toList();
    }
}
