package com.project.community_support.service;

import com.project.community_support.dto.request.FormCreationRequest;
import com.project.community_support.entity.Form;
import com.project.community_support.entity.Images;
import com.project.community_support.repository.FormRepository;
import com.project.community_support.repository.ImageRepository;
import com.project.community_support.repository.OrganizationRepository;
import com.project.community_support.repository.UserRepository;
import org.springframework.stereotype.Service;

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

    public void createForm(FormCreationRequest request) {
        Form form = new Form();
        form.setAddress(request.getAddress());
        form.setDescription(request.getDescription());
        form.setPhoneNumber(request.getPhoneNumber());
        form.setDeadline(request.getDeadline());
        form.setTarget(request.getTarget());
        form.setUser(userRepository.findById(request.getUserId()).orElseThrow());
        form.setOrganization(organizationRepository.findById(request.getOrganizationId()).orElseThrow());
        form.setTemp(request.isTemp());
        formRepository.save(form);

        request.getImages().forEach(i -> {
            Images image = new Images();
            image.setForm(form);
            image.setPath(i);
            imageRepository.save(image);
        });
    }


}
