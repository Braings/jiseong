package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import java.util.List; // Test02
import java.util.Optional; // Test03

//import java.time.LocalDateTime; // Test01

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Test
	void testJpa() {
		Optional<Question> oq = this.questionRepository.findById(1);
		if(oq.isPresent()) {
			Question q = oq.get();
			assertEquals("What is Sbb?", q.getSubject());
		}
		
		/* Test 01 - upload
		Question q1 = new Question();
		q1.setSubject("What is Sbb?");
		q1.setContent("I want to learn about Sbb");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1);
		
		Question q2 = new Question();
		q2.setSubject("Question about SpringBoot Model?");
		q2.setContent("Is id generate automatically?");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2);
		*/
		
		/* Test 02 - confirm
		List<Question> all = this.questionRepository.findAll();
		assertEquals(2, all.size());
		
		Question q = all.get(0);
		assertEquals("What is Sbb?", q.getSubject());
		*/
	}

}
