package com.tmr.bookseller.service;

import com.tmr.bookseller.model.PurchaseHistory;
import com.tmr.bookseller.repository.IPurchaseHistoryRepository;
import com.tmr.bookseller.repository.projections.IPurchaseItem;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchaseHistoryService implements  IPurchaseHistory{

    private IPurchaseHistoryRepository purchaseHistoryRepository;

    public PurchaseHistoryService(IPurchaseHistoryRepository purchaseHistoryRepository) {
        this.purchaseHistoryRepository = purchaseHistoryRepository;
    }
    @Override
    public PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory) {
        purchaseHistory.setPurchaseTime(LocalDateTime.now());
        return purchaseHistoryRepository.save(purchaseHistory);
    }
    @Override
    public List<IPurchaseItem> findPurchaseItemsOfUser(Long userId) {
        return purchaseHistoryRepository.findAllPurchasesOfUser(userId);
    }
}
