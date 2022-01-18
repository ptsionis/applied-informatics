#include <stdio.h>
#include "genlib.h"
#include "simpio.h"

#define N 100

int getNumber(int pin[N], int *minp1, int *maxp1);
void minMax(int *minp2, int *maxp2, int num);

int main()
{
    int pin[N], min, max;
    getNumber(pin, &min, &max);
    printf("The range of values is %d-%d", min, max);
}

int getNumber(int pin[N], int *minp1, int *maxp1)
{
    int i=0;
    int num;
    printf("Enter the elements of the array, one per line.");
    printf("\nUse -1 to signal the end of the list.\n");
    do
    {
        printf("? ");
        pin[i] = GetInteger();
        if (pin[i]!=-1)
        {
            if (i==0)
            {
                *minp1 = pin[i];
                *maxp1 = pin[i];
                i++;
            }
            else
            {
                num = pin[i];
                minMax(minp1, maxp1, num);
                i++;
            }
        }
    } while (pin[i]!=-1);

    return i;
}

void minMax(int *minp2, int *maxp2, int num)
{
    if (num>*maxp2)
    {
        *maxp2 = num;
    }
    if (num<*minp2)
    {
        *minp2 = num;
    }
}
