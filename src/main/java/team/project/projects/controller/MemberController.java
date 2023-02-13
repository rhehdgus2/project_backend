package team.project.projects.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import team.project.projects.dto.IdResponseDto;
import team.project.projects.dto.MemberFindIdDto;
import team.project.projects.dto.MemberFindPasswordDto;
import team.project.projects.dto.MemberLoginDto;
import team.project.projects.dto.Memberdto;
import team.project.projects.dto.PasswordResponseDto;
import team.project.projects.dto.ResponseDto;
import team.project.projects.dto.ResultResponseDto;
import team.project.projects.dto.SignInResponseDto;
import team.project.projects.dto.UpdateDto;
import team.project.projects.service.MemberService;

@RestController
@RequestMapping("/member")
@CrossOrigin(originPatterns = "http://localhost:3000")
public class MemberController {
	
	@Autowired MemberService memberService;
	
	@PostMapping("/Sign")
	public ResultResponseDto SignUp(@RequestBody Memberdto memberdto) {
		System.out.println(memberdto);
		ResultResponseDto resultResponseDto = memberService.SignUp(memberdto);
		return resultResponseDto;
	}
	
	@PostMapping("/login")
	public ResponseDto<SignInResponseDto> logIn(@RequestBody MemberLoginDto login) {
		System.out.println(login);
		System.out.println("hi");
		ResponseDto responseDto = memberService.login(login);
		return responseDto;
	}
	
	@PostMapping("/findid")
	public ResponseDto<IdResponseDto> findId(@RequestBody MemberFindIdDto memberFindIdDto) {
		ResponseDto responseDto = memberService.findId(memberFindIdDto);
		return responseDto;
	}
	
	@PostMapping("/findpassword")
	public ResponseDto<PasswordResponseDto> findPassword(@RequestBody MemberFindPasswordDto memberfinddto) {
		ResponseDto responseDto = memberService.findPassword(memberfinddto);
		return responseDto;
	}
	
	@PostMapping("/update")
	public ResultResponseDto update(@RequestBody UpdateDto updateDto) {
		return memberService.update(updateDto);
	}
	
	@GetMapping("/delete/{id}")
	public ResultResponseDto deleteUser(@PathVariable ("id") String id) {
		return memberService.deleteUser(id);
	}
	
}
