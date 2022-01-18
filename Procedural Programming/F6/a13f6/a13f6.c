#include <stdio.h>
#include "simpio.h"
#include "genlib.h"

void decompose(long num, int *pdigits, double *pavg, int *pmax);

int main()
{
    long num;
    int digits, max;
    double avg;

    printf("Please insert non-negative number:");
    num = GetLong();
    decompose(num, &digits, &avg, &max);
    printf("Digits: %d", digits);
    printf("\nAverage: %.3lf", avg);
    printf("\nMax: %d", max);

    return 0;

}

void decompose(long num, int *pdigits, double *pavg, int *pmax)
{
    *pdigits = 0;
    *pavg = 0;
    *pmax = 0;

    if (num==0)
    {
        *pdigits += 1;
    }

    while (num>0)
    {
        *pavg += num%10;
        *pdigits += 1;
        if (*pmax<num%10)
        {
            *pmax = num%10;
        }
        num -= num%10;
        num /= 10;
        if (num==0)
        {
            *pavg /= *pdigits;
        }
    }
}
