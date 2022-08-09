package com.sha.springboottaxapplication.service;

import com.sha.springboottaxapplication.model.Purchase;
import com.sha.springboottaxapplication.repository.projection.PurchaseItem;

import java.util.List;

/**
 * @author sa
 * @date 18.12.2021
 * @time 12:37
 */
public interface PurchaseService
{
    Purchase savePurchase(Purchase purchase);

    List<PurchaseItem> findPurchaseItemsOfUser(Long userId);
}
