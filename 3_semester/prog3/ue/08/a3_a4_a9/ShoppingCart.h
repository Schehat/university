#include <vector>
#include "CartItem.h"

#ifndef SHOPPING_CART_H
#define SHOPPING_CART_H

class ShoppingCart
{
public:
    void add(const CartItem &item);
    double getTotalCost();
    int getNumberOfItems();
    CartItem &getItem(int index);
    int *getItemIds();
    std::string toString();

private:
    std::vector<CartItem> items;
};

#endif