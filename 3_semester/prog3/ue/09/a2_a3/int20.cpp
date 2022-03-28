#include <iostream>
#include <string>
#include "int20.h"

Int20::Int20() : number{"00000000000000000000"} {}

Int20::Int20(const std::string val)
{
    number = {"00000000000000000000"};
    int cnt = 0;
    while (cnt <= (int)val.length() - 1)
    {
        number[LEN - val.length() + cnt] = val[cnt];
        cnt++;
    }
}

Int20::Int20(const Int20 &old)
{
    // number = nullptr;
    *this = old;
}

Int20 &Int20::operator=(const Int20 &other)
{
    if (this == &other)
        return *this;
    // delete[] number;
    number = {"00000000000000000000"};
    for (int i = 0; i < LEN; i++)
    {
        number[i] = other.number[i];
    }
    return *this;
}

Int20 Int20::operator+(const Int20 &other)
{
    Int20 result;

    int summandA;
    int summandB;
    int sum;
    int rest = 0;

    for (int i = LEN - 1; i >= 0; i--)
    {
        summandA = (this->number[i] - '0');
        summandB = (other.number[i] - '0');
        sum = summandA + summandB + rest;

        rest = sum / 10;

        result.number[i] = (sum % 10) + '0';
    }

    return result;
}

Int20 &Int20::operator+=(const Int20 &other)
{
    int summandA;
    int summandB;
    int sum;
    int rest = 0;

    for (int i = LEN - 1; i >= 0; i--)
    {
        summandA = (this->number[i] - '0');
        summandB = (other.number[i] - '0');
        sum = summandA + summandB + rest;

        rest = sum / 10;

        this->number[i] = (sum % 10) + '0';
    }

    return *this;
}

bool Int20::operator<(const Int20 &other)
{
    if ((this->number).length() < other.number.length())
    {
        return true;
    }
    else if ((this->number).length() == other.number.length())
    {
        for (int i = 0; i < (int)other.number.length(); i++)
        {
            if (this->number[i] > other.number[i])
            {
                return false;
            }
        }
        return true;
    }
    return false;
}

void Int20::print()
{

    int icnt = 0;

    // läuft bis zum ersten Index ab der die Zahl beginnt (!= 0 ist) und merkt sich diesen
    for (int i = 0; i < LEN; i++)
    {
        if (this->number[i] != '0')
        {
            icnt = i;
            break;
        }
    }

    // druckt ab dem gemerkten Index alle folgenden Zahlen aus
    for (int i = icnt; i < LEN; i++)
    {
        std::cout << this->number[i];
    }
}