#include <iostream>
#include "CartItem.h"
#include "ShoppingCart.h"

#define SIZE 1

using namespace std;

int main(void)
{
    CartItem Hundefutter{"Hundefutter", 6, 3.20};
    CartItem Kekse{"Kekse", 4, 1.59};
    CartItem Milch{"Milch", 1, 0.69};
    CartItem Erdbeermarmelade{"Erdbeermarmelade ", 3, 2.19};
    CartItem Milch2{CartItem{"Milch", 1, 0.69}};

    ShoppingCart sc;
    sc.add(&Hundefutter); // reference paramter geht nicht, weil auf const geht nicht Adressoperator
    sc.add(&Kekse);
    sc.add(&Milch);
    sc.add(&Erdbeermarmelade);

    sc.add(&Milch2);

    std::cout << sc.toString();

    std::cout << "\n\n";

    for (int i = 0; i < sc.getNumberOfItems(); i++)
    {
        std::cout << sc.getItem(i).getItemId() << "\t" << sc.getItem(i).getName() << "\n";
    }

    delete[] sc.getItemIds();
}