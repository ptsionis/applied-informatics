#include <stdio.h>
#include "simpio.h"
#include "genlib.h"

int main()
{
    double profit, saleAmount;
    long purchaseAmount;
    int rate;

    printf("Dose tin kathari aksia: ");
    purchaseAmount = GetLong();
    printf("Dose to pososto kerdous: ");
    rate = GetInteger();
    profit = purchaseAmount*rate/100.0;
    printf("To kerdos einai: %g\n", profit);
    saleAmount = purchaseAmount+profit;
    printf("To synoliko poso einai: %g\n", saleAmount);

    return 0;
}
