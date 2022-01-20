#include <string>
#include <iostream>
#include <iomanip>
#include <sstream>
#include "CartItem.h"

int CartItem::lastId{0};

CartItem::CartItem(const std::string &name, int number, double price) : itemId{++lastId}, name{name}, number{number}, price{price} {}
CartItem::CartItem(const CartItem &old) : itemId{++lastId}, name{old.name}, number{old.number}, price{old.price} {}

double CartItem::getCost() const { return number * price; }
const std::string &CartItem::getName() const { return name; }
int CartItem::getNumber() const { return number; }
double CartItem::getPrice() const { return price; }
int CartItem::getItemId() const { return itemId; }
void CartItem::setName(const std::string &name) { this->name = name; }
void CartItem::setNumber(int number) { this->number = number; }
void CartItem::setPrice(double price) { this->price = price; }

std::string CartItem::toString() const
{
    std::ostringstream stream;
    stream << std::setw(2) << std::left << std::to_string(number);

    // width = 3
    stream << " x ";

    stream << std::setw(30) << std::left << name;

    stream << std::setw(6) << std::left << std::setprecision(2); // gilt für alle danach
    stream << std::fixed << price;

    stream << std::setw(6) << std::right << getCost();

    return stream.str();
}