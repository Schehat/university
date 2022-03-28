#include <vector>
#include "CartItem.h"

#ifndef SHOPPING_CART_H
#define SHOPPING_CART_H

class ShoppingCart
{
public:
    void add(CartItem *const &item); // kein const CartItem
    double getTotalCost() const;
    int getNumberOfItems() const;
    CartItem &getItem(int index); // const geht nicht
    int *getItemIds() const;
    std::string toString() const;

private:
    std::vector<CartItem *> items;
};

#endif