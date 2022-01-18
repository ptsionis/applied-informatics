#include <stdio.h>
#include "simpio.h"
#include "genlib.h"

int main()
{
    int pin[5], temp;
    for (int i=0; i<5; i++)
    {
        printf("Enter number: ");
        pin[i] = GetInteger();
    }

    temp = pin[4];
    for (int i=3; i>=0; i--)
    {
        pin[i+1] = pin[i];
    }
    pin[0] = temp;

    for (int i=0; i<5; i++)
    {
        printf("%d ", pin[i]);
    }

    return 0;
}
