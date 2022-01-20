#include <vector>
#include <iomanip>
#include <sstream>
#include "ShoppingCart.h"

ShoppingCart::ShoppingCart() { items = std::vector<CartItem *>{}; }

void ShoppingCart::add(CartItem *const &item) { items.push_back(item); }

double ShoppingCart::getTotalCost() const
{
    double sum = 0;
    for (auto &elem : items)
    {
        sum += elem->getPrice() * elem->getNumber();
    }
    return sum;
}

int ShoppingCart::getNumberOfItems() const
{
    return items.size();
}

CartItem &ShoppingCart::getItem(int index) // const geht nicht
{
    return *items.at(index);
}

int *ShoppingCart::getItemIds() const
{
    int *arr{new int[getNumberOfItems()]};
    for (int i = 0; i < getNumberOfItems(); ++i)
    {
        arr[i] = items[i]->getItemId();
    }
    return arr;
}

std::string ShoppingCart::toString() const
{
    std::ostringstream stream;
    for (auto &elem : items)
    {
        stream << elem->toString();
        stream << "\n";
    }

    stream << "\n";
    // width = 6
    stream << "Summe:";

    // 47 total length of toString from CartItem
    stream << std::setw(47 - 6);
    stream << std::right;
    stream.precision(2);
    stream << std::fixed;
    stream << getTotalCost();

    return stream.str();
}