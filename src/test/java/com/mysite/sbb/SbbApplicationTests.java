package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;  //use assertEquals
import static org.junit.jupiter.api.Assertions.assertTrue;    //use assertTrue

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

//To use below Types
//import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	//private AnswerRepository answerRepository;
	
	@Transactional
	@Test
	void testJpa() {
		// Test 11 - confirm Question's Answer
		Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		
		List<Answer> answerList = q.getAnswerList();
		
		assertEquals(1, answerList.size());
		assertEquals("Yes. It Generates Automatically.", answerList.get(0).getContent());
		
		
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
		
		/* Test 03 - findAll, find Id
				Optional<Question> oq = this.questionRepository.findById(1);
				if(oq.isPresent()) {
					Question q = oq.get();
					assertEquals("What is Sbb?", q.getSubject());
				}
		*/
				
		/* Test 04 - find Subject
		Question q = this.questionRepository.findBySubject("What is Sbb?");
		assertEquals(1, q.getId());
		*/
		
		/* Test 05 - find Subject and Content
		Question q = this.questionRepository.findBySubjectAndContent("What is Sbb?", "I want to learn about Sbb");
		assertEquals(1, q.getId());
		*/
		
		/* Test 06 - find Subject(Like)
				List<Question> qList = this.questionRepository.findBySubjectLike("Sbb%");
				Question q = qList.get(0);
				assertEquals("What is Sbb?", q.getSubject());
		*/
		
		/* Test 07 - modify subject
				Optional<Question> oq = this.questionRepository.findById(1);
				assertTrue(oq.isPresent());
				Question q = oq.get();
				q.setSubject("modified Subject");
				
				this.questionRepository.save(q);
		*/
		
		/* Test 08 - delect
				assertEquals(2, this.questionRepository.count());
				Optional<Question> oq = this.questionRepository.findById(1);
				assertTrue(oq.isPresent());
				Question q = oq.get();
				this.questionRepository.delete(q);
				assertEquals(1, this.questionRepository.count());
		*/
		
		/* Test 09 - Add Answer
				Optional<Question> oq = this.questionRepository.findById(2);
				assertTrue(oq.isPresent());
				Question q = oq.get();
				
				Answer a = new Answer();
				a.setContent("Yes. It Generates Automatically.");
				a.setQuestion(q);
				a.setCreateDate(LocalDateTime.now());
				this.answerRepository.save(a);
		*/
		
		/* Test 10 - confirm Answer's question
				Optional<Answer> oa = this.answerRepository.findById(1);
				assertTrue(oa.isPresent());
				Answer a = oa.get();
				assertEquals(2, a.getQuestion().getId());
		*/
	}

}
