package com.shaping.shaping;

import com.shaping.shaping.domain.Item;
import com.shaping.shaping.enums.ItemStatus;
import com.shaping.shaping.mapper.MemberMapper;
import com.shaping.shaping.repository.ItemRepository;
import com.shaping.shaping.repository.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;

@SpringBootTest
class ShapingApplicationTests {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberMapper memberMapper;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

//    @AfterEach
//    public void tearDown() {
//        // 데이터베이스 초기화 코드
//        jdbcTemplate.execute("DELETE FROM item");
//    }
    @Test
    void 아이템생성() {
        Item item = new Item();
        item.setItemName("테스트");
        item.setItemStatus(ItemStatus.SELL);
        item.setPrice(1000);
        item.setStock(2);
        itemRepository.save(item);
        System.out.println("item.toString() = " + item.toString());


    }

}
