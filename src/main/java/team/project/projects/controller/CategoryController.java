package team.project.projects.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import team.project.projects.dto.CategoryDto;
import team.project.projects.dto.CategoryListDto;
import team.project.projects.dto.CategoryResponseDto;
import team.project.projects.entity.CategoryEntity;
import team.project.projects.service.CategoryService;

@CrossOrigin(originPatterns = "http://localhost:3000")
@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired CategoryService categoryService;
	
	@GetMapping("/list")
	public CategoryResponseDto<List<CategoryDto>> categoryUpload() {
		return categoryService.getAllCategory();
	}
	@PostMapping("/listUp")
	public CategoryResponseDto<CategoryEntity> listUp(@RequestBody CategoryListDto categoryListDto) {
		System.out.println(categoryListDto);
		return categoryService.listUp(categoryListDto);
	}
	@GetMapping("/delete/{productName}")
	public void delete(@PathVariable("productName") String productName) {
		categoryService.delete(productName);
	}
}
