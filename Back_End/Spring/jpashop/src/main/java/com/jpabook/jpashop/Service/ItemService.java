package com.jpabook.jpashop.Service;

import com.jpabook.jpashop.domain.item.Book;
import com.jpabook.jpashop.domain.item.Item;
import com.jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// 단순하게 Repository에 위임해서 조회하는 과정 -> Controller에서 바로 접근하는 것은 어떨까??
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    @Transactional
    public void updateItem(Long itemId, String name, int price, int stockQuantity) { // 이 방법이 보통 더 나은 방법임
        Item findItem = itemRepository.findOne(itemId); // 이 친구는 영속상태 -> Commit됨 -> flush -> DB
        findItem.setName(name);
        findItem.setPrice(price);
        findItem.setStockQuantity(stockQuantity);
    }
    // set을 까는 것도 좋지 않다
    // 변경해주는 Method들을 따로 만드는 것이 유리하다 -> 의미있는 Method를 통한 역추적 용이

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}
