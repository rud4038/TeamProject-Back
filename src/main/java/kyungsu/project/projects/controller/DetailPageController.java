package kyungsu.project.projects.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kyungsu.project.projects.dto.DetailPageDto;
import kyungsu.project.projects.dto.DetailPageListDto;
import kyungsu.project.projects.dto.ResponseDto;
import kyungsu.project.projects.entity.DetailPageEntity;
import kyungsu.project.projects.service.DetailPageService;

@CrossOrigin(originPatterns = "http://localhost:3000")
@RestController
@RequestMapping("/detail")
public class DetailPageController {
	
	@Autowired DetailPageService detailPageService;

	@GetMapping("{productName}")
	public ResponseDto<DetailPageDto> pageLoad(@PathVariable("productName") String productName) {
		return detailPageService.detailLoad(productName);
	}
	@PostMapping("/detailUp")
	public ResponseDto<DetailPageEntity> detailUp(@RequestBody DetailPageListDto detailPageListDto) {
		return detailPageService.detailUp(detailPageListDto);
		
	}
	@GetMapping("/detailDelete/{productName}")
	public void detailDelete(@PathVariable("productName") String productName) {
		detailPageService.detailDelete(productName);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
