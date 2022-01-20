#include <iostream>
#include "CartItem.h"
#include "ShoppingCart.h"

#define SIZE 1

using namespace std;

int main(void)
{
    ShoppingCart sc;
    sc.add(CartItem{"Hundefutter", 6, 3.20});
    sc.add(CartItem{"Kekse", 4, 1.59});
    sc.add(CartItem{"Milch", 1, 0.69});
    sc.add(CartItem{"Erdbeermarmelade ", 3, 2.19});
    // sc.add(CartItem{sc.getItem(2)});

    cout << sc.toString();

    cout << "\n\n";

    for (int i = 0; i < sc.getNumberOfItems(); i++)
    {
        std::cout << sc.getItem(i).getItemId() << "\t" << sc.getItem(i).getName() << "\n";
    }

    delete[] sc.getItemIds();
}