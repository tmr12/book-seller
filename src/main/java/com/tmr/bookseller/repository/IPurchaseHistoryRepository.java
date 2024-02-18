package com.tmr.bookseller.repository;

import com.tmr.bookseller.model.PurchaseHistory;
import com.tmr.bookseller.repository.projections.IPurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPurchaseHistoryRepository extends JpaRepository<PurchaseHistory, Long> {
    @Query("select b.title as title , ph.price as price, ph.purchaseTime as PurchaseTime from PurchaseHistory ph left join " +
            "Book b on b.id = ph.id " +
            "where userId = :userId")
    List<IPurchaseItem> findAllPurchasesOfUser(@Param("userId") Long userId);
}
