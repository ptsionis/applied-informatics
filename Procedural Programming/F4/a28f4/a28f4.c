#include <stdio.h>
#include <math.h>
#include "simpio.h"
#include "genlib.h"

int get_code();
float discount_percentage(int Code);
int product_points(int code, float total);

int main()
{
    int code, points;
    float price, total, discountSum, discount;
    total = discountSum = 0;
    points = 0;
    printf("Enter code: ");
    code = get_code();
    while (code)
    {
        printf("Enter price: ");
        price = GetReal();
        discount = discount_percentage(code)*price;
        discountSum += discount;
        total += (price - discount);
        points += product_points(code, total);
        printf("Enter code: ");
        code = get_code();
    }
    printf("----------------\n");
    printf("Final price: %0.2f", total);
    printf("\nDiscount: %0.2f", discountSum);
    printf("\nPoints: %d", points);


    return 0;
}

int get_code()
{
    int Code;
    Code = GetInteger();
    while((Code<0) || (Code>2000))
    {
        printf("Wrong code (0-2000)\nEnter code: ");
        Code = GetInteger();
    }

    return Code;
}

float discount_percentage(int Code)
{
    if (Code<301)
    {
        return 0.05;
    }
    else if (Code<501)
    {
        return 0.1;
    }
    else if (Code<1001)
    {
        return 0.15;
    }
    else
    {
        return 0.2;
    }
}

int product_points(int code, float total)
{
    int Points = 1;
    if ((code>=1000) && (code<=1500))
    {
        Points += ceil(total/5);
    }

    return Points;
}
