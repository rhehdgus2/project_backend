package team.project.projects.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import team.project.projects.dto.DetailPageDto;
import team.project.projects.dto.DetailPageListDto;
import team.project.projects.dto.ResponseDto;
import team.project.projects.entity.DetailPageEntity;
import team.project.projects.repository.DetailPageRepository;

@Service
public class DetailPageService {

	@Autowired DetailPageRepository detailPage;
	
	public ResponseDto<DetailPageDto> detailLoad(String productName) {
		DetailPageEntity pageEntity;
		
		try {
			pageEntity = detailPage.findById(productName).get();
		} catch (Exception e) {
			return ResponseDto.setFailed();
		}
		
		return ResponseDto.setSuccess(new DetailPageDto(pageEntity));
	}
	
	public ResponseDto<DetailPageEntity> detailUp(DetailPageListDto detailPageListDto) {
		boolean result;
		result = detailPage.existsById(detailPageListDto.getProductName()); 
		if(result) {
			ResponseDto.setFailed();
		}
		DetailPageEntity detailPageEntity = new DetailPageEntity(detailPageListDto);
		
		detailPage.save(detailPageEntity);
		return ResponseDto.setSuccess(detailPageEntity);
		
	}
	public void detailDelete(String productName) {
		detailPage.deleteById(productName);
	}
}
