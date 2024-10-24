package com.project.community_support.service;

import com.project.community_support.dto.request.FormCreationRequest;
import com.project.community_support.dto.response.FormResponse;
import com.project.community_support.entity.Form;
import com.project.community_support.entity.Images;
import com.project.community_support.entity.User;
import com.project.community_support.exception.AppException;
import com.project.community_support.exception.ErrorCode;
import com.project.community_support.repository.FormRepository;
import com.project.community_support.repository.ImageRepository;
import com.project.community_support.repository.OrganizationRepository;
import com.project.community_support.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FormService {

    private final FormRepository formRepository;
    private final ImageRepository imageRepository;
    private final UserRepository userRepository;
    private final OrganizationRepository organizationRepository;

    public FormService(FormRepository formRepository, ImageRepository imageRepository,
                       UserRepository userRepository, OrganizationRepository organizationRepository) {
        this.formRepository = formRepository;
        this.imageRepository = imageRepository;
        this.userRepository = userRepository;
        this.organizationRepository = organizationRepository;
    }

    public FormResponse createForm(FormCreationRequest request) {
        Form form = new Form();
        User user = userRepository.findById(request.getUserId()).orElseThrow(
                () -> new AppException(ErrorCode.USER_NOT_FOUND)
        );
//        Organization organization = organizationRepository.findById(request.getOrganizationId()).orElseThrow(
//                () -> new AppException(ErrorCode.ORGANIZATION_NOT_FOUND)
//        );
        form.setAddress(request.getAddress());
        form.setDescription(request.getDescription());
        form.setPhoneNumber(request.getPhoneNumber());
        form.setDeadline(request.getDeadline());
        form.setTarget(request.getTarget());
        form.setUser(user);
//        form.setOrganization(organization);
        form.setTemp(request.isTemp());
        formRepository.save(form);

        request.getImages().forEach(i -> {
            Images image = new Images();
            image.setForm(form);
            image.setPath(i);
            imageRepository.save(image);
        });

        new FormResponse();
        return FormResponse.builder()
                .address(form.getAddress())
                .description(form.getDescription())
                .isTemp(form.isTemp())
                .phoneNumber(form.getPhoneNumber())
                .target(form.getTarget())
                .deadline(form.getDeadline())
                .dateOfApplication(form.getDateOfApplication())
                .images(request.getImages())
//                .organization(
//                        Map.of(
//                                "id", organization.getId(),
//                                "name", organization.getOrganizationName()
//                        )
//                )
                .user(
                        Map.of(
                                "id", user.getId(),
                                "name", user.getFullName()
                        )
                )
                .build();

    }

    public FormResponse getFormById(String formId) {
        Form form = formRepository.findById(formId).orElseThrow(
                () -> new AppException(ErrorCode.FORM_NOT_FOUND)
        );

        return FormResponse.builder()
                .address(form.getAddress())
                .description(form.getDescription())
                .isTemp(form.isTemp())
                .phoneNumber(form.getPhoneNumber())
                .target(form.getTarget())
                .deadline(form.getDeadline())
                .dateOfApplication(form.getDateOfApplication())
                .images(imageRepository.findAllByFormId(formId).stream().map(Images::getPath).toList())
                .organization(
                        form.getOrganization() != null ?
                                Map.of(
                                        "id", form.getOrganization().getId(),
                                        "name", form.getOrganization().getOrganizationName()
                                ) : null
                )
                .user(
                        Map.of(
                                "id", form.getUser().getId(),
                                "name", form.getUser().getFullName()
                        )
                )
                .build();
    }

    public List<FormResponse> getAllForms() {
        return formRepository.findAll().stream().map(form -> {
            return FormResponse.builder()
                    .address(form.getAddress())
                    .description(form.getDescription())
                    .isTemp(form.isTemp())
                    .phoneNumber(form.getPhoneNumber())
                    .target(form.getTarget())
                    .deadline(form.getDeadline())
                    .dateOfApplication(form.getDateOfApplication())
                    .images(imageRepository.findAllByFormId(form.getId()).stream().map(Images::getPath).toList())
                    .organization(
                            form.getOrganization() != null ?
                                    Map.of(
                                            "id", form.getOrganization().getId(),
                                            "name", form.getOrganization().getOrganizationName()
                                    ) : null
                    )
                    .user(
                            Map.of(
                                    "id", form.getUser().getId(),
                                    "name", form.getUser().getFullName()
                            )
                    )
                    .build();
        }).toList();
    }


}
