package com.app.manager.domain;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class DeptDTO {
    @Min(value = 1)
    @Max(value = 99)
    @Positive // 양수값만
    private int deptno;

    @NotEmpty   // 문자열이 비어있지 않은 상태를 체크, List의 경우는 요소의 개수가 비어있지않은 걸 체크
    private String dname;

    @NotEmpty   // "" fail  " " pass
    private String loc;
}

// validation annotation
// @Future : 현재 시간보다 미래이어야 한다! -> 투두 리스트 입력할 때 dueDate 설정할 때 사용
// @Email : @ 유무만 체크
// @NotBlank : empty보다 타이트 함. 공백 문자열 체크. null이 아니어야 함. " " space도 안돼
// @NotNull