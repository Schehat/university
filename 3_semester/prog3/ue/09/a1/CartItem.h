#include <string>

#ifndef CARTITEM_H
#define CARTITEM_H

class CartItem
{
public:
    CartItem(const std::string &name, int number, double price);
    CartItem(const CartItem &old);
    double getCost() const;
    const std::string &getName() const;
    int getNumber() const;
    double getPrice() const;
    int getItemId() const;
    void setName(const std::string &name);
    void setNumber(int number);
    void setPrice(double price);
    std::string toString() const;

private:
    static int lastId;
    const int itemId;
    std::string name;
    int number;
    double price;
};

#endif
