#include <stdio.h>
#include "genlib.h"
#include "simpio.h"

int main()
{
    int age, min, max;
    max = 0;
    min = 999;
    printf("Dose ilikia: ");
    age = GetInteger();
    while (age != -1)
    {
        if (age < min)
        {
            min = age;
        }
        if (age > max)
        {
            max = age;
        }
        printf("Dose ilikia: ");
        age = GetInteger();
    }
    printf("H megalyteri ilikia einai: %d", max);
    printf("\nH mikroteri ilikia einai: %d", min);
}
