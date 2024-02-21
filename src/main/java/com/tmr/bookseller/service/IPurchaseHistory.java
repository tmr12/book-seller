package com.tmr.bookseller.service;

import com.tmr.bookseller.model.PurchaseHistory;
import com.tmr.bookseller.repository.projections.IPurchaseItem;

import java.util.List;

public interface IPurchaseHistory {
    PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory);

    List<IPurchaseItem> findPurchaseItemsOfUser(Long userId);
}
