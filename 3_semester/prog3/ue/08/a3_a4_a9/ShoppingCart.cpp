#include <vector>
#include <iomanip>
#include <sstream>
#include "ShoppingCart.h"

void ShoppingCart::add(const CartItem &item) { items.push_back(item); }

double ShoppingCart::getTotalCost()
{
    double sum = 0;
    for (auto &elem : items)
    {
        sum += elem.getPrice() * elem.getNumber();
    }
    return sum;
}

int ShoppingCart::getNumberOfItems()
{
    return items.size();
}

CartItem &ShoppingCart::getItem(int index)
{
    return items.at(index);
}

int *ShoppingCart::getItemIds()
{
    int *arr{new int[getNumberOfItems()]};
    for (int i = 0; i < getNumberOfItems(); ++i)
    {
        arr[i] = items[i].getItemId();
    }
    return arr;
}

std::string ShoppingCart::toString()
{
    std::ostringstream stream;
    for (auto &elem : items)
    {
        stream << elem.toString();
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