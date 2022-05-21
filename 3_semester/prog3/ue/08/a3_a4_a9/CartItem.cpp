#include <string>
#include <iomanip>
#include <sstream>
#include "CartItem.h"

int CartItem::lastId{0};

CartItem::CartItem(const std::string &name, int number, double price) : itemId{++lastId}, name{name}, number{number}, price{price} {}
// CartItem::CartItem(const CartItem &old) : itemId{++lastId}, name{old.name}, number{old.number}, price{old.price} {}

double CartItem::getCost() { return number * price; }
const std::string &CartItem::getName() { return name; }
int CartItem::getNumber() { return number; }
double CartItem::getPrice() { return price; }
int CartItem::getItemId() { return itemId; }
void CartItem::setName(const std::string &name) { this->name = name; }
void CartItem::setNumber(int number) { this->number = number; }
void CartItem::setPrice(double price) { this->price = price; }

std::string CartItem::toString()
{
    std::ostringstream stream;
    stream << std::setw(2);
    stream << std::left;
    stream << std::to_string(number);

    // width = 3
    stream << " x ";

    stream << std::setw(30);
    stream << std::left;
    stream << name;

    stream << std::setw(6);
    stream << std::left;
    stream.precision(2); // gilt für alle danach
    stream << std::fixed;
    stream << price;

    stream << std::setw(6);
    stream << std::right;
    stream << getCost();

    return stream.str();
}