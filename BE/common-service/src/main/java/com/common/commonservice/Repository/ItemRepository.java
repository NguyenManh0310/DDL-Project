package com.common.commonservice.Repository;

import com.common.commonservice.Entity.Department;
import com.common.commonservice.Entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Item getByItemId(Long id);

    @Query("select i from Item i")
    List<Item> getAllItem();

    Item getByItemCode(String code);

    @Query("select i from Item i join Category c on i.categoryId=c.categoryId where c.categoryCode =: code")
    List<Item> getListItemByCategoryCode(String code);

    @Query("SELECT i FROM Item i join Category c on i.categoryId=c.categoryId " +
            "WHERE (:itemCode IS NULL OR LOWER(i.itemCode) LIKE LOWER(CONCAT('%', :itemCode, '%')) OR :itemCode = '') " +
            "AND (:itemName IS NULL OR LOWER(i.itemName) LIKE LOWER(CONCAT('%', :itemName, '%')) OR :itemName = '') " +
            "AND (:categoryName IS NULL OR LOWER(c.categoryName) LIKE LOWER(CONCAT('%', :categoryName, '%')) OR :categoryName = '')")
    Page<Item> getAllItemPaging(@Param("itemCode") String itemCode,
                                @Param("itemName") String itemName,
                                @Param("categoryName") String categoryName,
                                Pageable pageable);
}
