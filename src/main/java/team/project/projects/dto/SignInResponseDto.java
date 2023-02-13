package team.project.projects.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import team.project.projects.entity.MemberEntity;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignInResponseDto {
	private String token;
	private int exprTime;
	private MemberEntity memberEntity;
}
