package com.jpabook.jpashop.Service;

import com.jpabook.jpashop.domain.item.Book;
import jakarta.persistence.EntityManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemUpdateTest {
    @Autowired
    EntityManager em;

    @Test
    public void updateTest() throws Exception {
        //given
        Book book = em.find(Book.class,1L);

        //when
        book.setName("abcdefg");

        // 변경 감지 == dirty Checking -> 이걸로 JPA는 value Update 가능
        // Order : cancel() 함수 -> flush할 때 Dirty Checking

        //then
    }
}
