package com.example.demo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Todo;
import com.example.demo.model.Todo.TodoStatus;
import com.example.demo.repository.TodoRepository;

@SpringBootApplication
public class TodoVueVuexRouterApplication {

	@Autowired
	TodoRepository todoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TodoVueVuexRouterApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner insertSampleTodo(TodoRepository todoRepository) {
		return args -> {
			todoRepository.save(Todo.builder().title("부서별 구매물품 확인").description("부서별 물품신청 내용 확인 및 주문하기").dueDate(LocalDate.of(2021, 2, 26)).status(TodoStatus.REGISTERED).username("홍길동").build());
			todoRepository.save(Todo.builder().title("신입사원 교육 준비").description("신입사원 교육환경 준비 및 강사 섭외하기, 교육일정 결정하기").dueDate(LocalDate.of(2021, 2, 20)).status(TodoStatus.REGISTERED).username("홍길동").build());
			todoRepository.save(Todo.builder().title("인사발령").description("홍길동 사원을 대리로 보임합니다.").dueDate(LocalDate.of(2021, 2, 19)).status(TodoStatus.REGISTERED).username("홍길동").build());
			todoRepository.save(Todo.builder().title("신입사원 교육").description("신입사원 교육과정 기획 및 개발내용 개발하기").dueDate(LocalDate.of(2021, 2, 15)).status(TodoStatus.DELAYED).username("홍길동").build());
			todoRepository.save(Todo.builder().title("유지보수 일정 잡기").description("서버장비 정기 유지보수 일정 공지 및 유수보수 업체 협의").dueDate(LocalDate.of(2021, 2, 10)).status(TodoStatus.COMPLETED).completedDate(LocalDate.of(2021, 2, 9)).username("홍길동").build());
			todoRepository.save(Todo.builder().title("신규 사업 보고").description("2021년 신규 내용 발표 및 타당성 점검").dueDate(LocalDate.of(2021, 2, 6)).status(TodoStatus.DELETED).deletedDate(LocalDate.of(2021, 2, 5)).username("홍길동").build());
			todoRepository.save(Todo.builder().title("팀별 회의 참석").description("2월 정기 팀별 월간회의 참석 ").dueDate(LocalDate.of(2021, 2, 4)).status(TodoStatus.COMPLETED).completedDate(LocalDate.of(2021, 2, 4)).username("홍길동").build());
			todoRepository.save(Todo.builder().title("외주인력 계약연장건").description("개발, 디자인, 기획 담당 외부 인력 계약 연장 협의하기").dueDate(LocalDate.of(2021, 1, 31)).status(TodoStatus.DELETED).deletedDate(LocalDate.of(2021, 1, 18)).username("홍길동").build());
			todoRepository.save(Todo.builder().title("전산용품 구매").description("부서별 전산 소모품 구매 계획서 취합 및 구매예산 결정").dueDate(LocalDate.of(2021, 1, 25)).status(TodoStatus.COMPLETED).completedDate(LocalDate.of(2021, 1, 17)).username("홍길동").build());
			todoRepository.save(Todo.builder().title("프로젝트 회의").description("인트라넷 프로젝트 일정 확인 및 진행상황 체크").dueDate(LocalDate.of(2021, 1, 15)).status(TodoStatus.COMPLETED).completedDate(LocalDate.of(2021, 1, 14)).username("홍길동").build());
		};
	}

}
