#include <vector>
#include "CartItem.h"

#ifndef SHOPPING_CART_H
#define SHOPPING_CART_H

class ShoppingCart
{
public:
    ShoppingCart();
    void add(CartItem *const &item); // kein const, da auf Adresse zugreifen notwendig, aber geht nicht
    double getTotalCost() const;
    int getNumberOfItems() const;
    CartItem &getItem(int index); // const geht nicht
    int *getItemIds() const;
    std::string toString() const;

private:
    std::vector<CartItem *> items;
};

#endif