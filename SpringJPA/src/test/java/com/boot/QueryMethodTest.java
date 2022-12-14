package com.boot;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.boot.domain.Board;
import com.boot.persistence.BoardRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class QueryMethodTest {

	@Autowired
	private BoardRepository boardRepo;
	
	//데이터 200개 저장
	//@BeforeEach은 테스트 메소드가 실행되기 전에 동작
	/*@BeforeEach
	public void dataPrepare() {
		for(int i=1; i<=200; i++) {
			Board board = new Board();
			board.setTitle("테스트 제목 " + i);
			board.setWriter("테스터");
			board.setContent("테스트 내용 " + i);
			board.setCreateDate(new Date());
			board.setCnt(0L);
			
			boardRepo.save(board);
		}
	}*/
	
	/*@Test
	public void testFindByTitle() {
		List<Board> boardList = boardRepo.findByTitle("테스트 제목 130");
		log.info("검색 결과");
		for(Board board : boardList) {
			log.info("--->" + board.toString());
		}
	}*/
	
	/*@Test
	public void testFindByContentContaining() {
		List<Board> boardList = boardRepo.findByContentContaining("17");
		for(Board board : boardList) {
			log.info("--->" + board.toString());
		}
	}*/
	
	/*@Test
	public void testFindByTitleContainingOrContentContaining() {
		List<Board> boardList = boardRepo.findByTitleContainingOrContentContaining("테스트 제목 139", "테스트 내용 131");
		for(Board board : boardList) {
			log.info("--->" + board.toString());
		}
	}*/
	
	/*@Test
	public void testFindByTitleContainingOrderBySeqDesc() {
		List<Board> boardList = boardRepo.findByTitleContainingOrderBySeqDesc("18");
		for(Board board : boardList) {
			log.info("--->" + board.toString());
		}
	}*/
	
	@Test
	public void testFindTitleContaining() {
		//0은 페이지번호(1페이지) - 글번호를 기준으로 내림차순 정렬
		Pageable paging = PageRequest.of(0, 10, Sort.Direction.DESC, "seq");
		
		//List<Board> boardList = boardRepo.findByTitleContaining("제목", paging);
		Page<Board> pageInfo = boardRepo.findByTitleContaining("제목", paging);
		
		System.out.println("PAGE SIZE: " + pageInfo.getSize());	//페이지당 게시글 수
		System.out.println("TOTAL PAGES: " + pageInfo.getTotalPages());	//전체 페이지 수
		System.out.println("PAGE COUNT: " + pageInfo.getTotalElements());	//전체 게시글 수
		System.out.println("NEXT: " + pageInfo.nextPageable());	//다음페이지 관련 정보
		
		List<Board> boardList = pageInfo.getContent();
		
		log.info("검색 결과");
		for(Board board : boardList) {
			log.info("--->" + board.toString());
		}
	}
}
