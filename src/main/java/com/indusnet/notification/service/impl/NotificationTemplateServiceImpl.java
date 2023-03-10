package com.indusnet.notification.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.indusnet.notification.converter.ModelConverter;
import com.indusnet.notification.dto.NotificationTemplateRequest;
import com.indusnet.notification.dto.NotificationTemplateResponse;
import com.indusnet.notification.dto.SuccessResponse;
import com.indusnet.notification.dto.TemplateListResponse;
import com.indusnet.notification.entity.NotificationTemplateEntity;
import com.indusnet.notification.exception.TemplateNotFound;
import com.indusnet.notification.repository.NotificationTemplateRepository;
import com.indusnet.notification.service.NotificationTemplateService;

@Service
public class NotificationTemplateServiceImpl implements NotificationTemplateService {

	@Autowired
	private NotificationTemplateRepository templateRepository;

	@Override
	public SuccessResponse saveNotificationTemplate(NotificationTemplateRequest templateRequest)
			throws TemplateNotFound {

		SuccessResponse successResponse = new SuccessResponse();

		try {
			NotificationTemplateEntity dtoToEntity = ModelConverter.dtoToEntity(templateRequest);
			NotificationTemplateEntity dataEntity = templateRepository.save(dtoToEntity);
			successResponse.setStatus(200);
			successResponse.setMessage("Notification Template Save Successfully");
			successResponse.setTemplateId(dataEntity.getId());
		} catch (Exception e) {
			throw new TemplateNotFound("Notification Template Save Unsuccessfully");
		}
		return successResponse;
	}

	@Override
	public NotificationTemplateEntity getTemplate(Long id) {
		return templateRepository.getTemplateById(id);
	}

	@Override
	public SuccessResponse updateNotificationTemplate(NotificationTemplateRequest templateRequest, Long id)
			throws TemplateNotFound {

		SuccessResponse successResponse = new SuccessResponse();

		try {
			Optional<NotificationTemplateEntity> findById = templateRepository.findById(id);

			if (findById.isPresent()) {
				NotificationTemplateEntity dtoToEntity = ModelConverter.dtoToEntity(templateRequest);
				dtoToEntity.setId(id);
				templateRepository.save(dtoToEntity);
				successResponse.setStatus(200);
				successResponse.setMessage("Notification Template Update Successfully");
				successResponse.setTemplateId(dtoToEntity.getId());
			} else {
				throw new TemplateNotFound("Not Found Id= " + id);
			}
		} catch (Exception e) {
			throw new TemplateNotFound("Not Found Id= " + id);
		}
		return successResponse;
	}

	@Override
	public TemplateListResponse getAllList() {
		List<NotificationTemplateResponse> templateResponse = new ArrayList<>();
		try {
			List<NotificationTemplateEntity> findAll = templateRepository.findAll();
			if (findAll.isEmpty()) {
				throw new TemplateNotFound("List Is Empty");
			} else {
				for (NotificationTemplateEntity emailDataEntity : findAll) {
					NotificationTemplateResponse entityToDTO = ModelConverter.entityToDTO(emailDataEntity);
					templateResponse.add(entityToDTO);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return TemplateListResponse.builder().status(200).message("Template List Fetched Successfully").templateList(templateResponse).build();
	}

	@Override
	public SuccessResponse deleteNotificationTemplate(Long id) throws TemplateNotFound {

		SuccessResponse successResponse = new SuccessResponse();

		try {
			Optional<NotificationTemplateEntity> findById = templateRepository.findById(id);
			if (findById.isPresent()) {
				templateRepository.deleteById(id);
				successResponse.setStatus(200);
				successResponse.setMessage("Notification Template Delete Successfully");
				successResponse.setTemplateId(id);
			} else {
				throw new TemplateNotFound("Id Not Found = " + id);
			}
		} catch (Exception e) {
			throw new TemplateNotFound("Id Not Found = " + id);
		}
		return successResponse;
	}

}
