#include <stdio.h>
#include "genlib.h"
#include "simpio.h"

int main()
{
    int arithmos_kafe, resta, kermata;

    printf("Dose kafedes: ");
    arithmos_kafe = GetInteger();
    if ((arithmos_kafe*70)>500)
    {
        printf("Den ftanoun ta xrimata gia tosous kafedes!");
    }
    else
    {
        resta = 500-(arithmos_kafe*70);
        kermata = resta/200;
        resta -= 200*kermata;
        printf("\nKermata 2E: %d", kermata);
        kermata = resta/100;
        resta -= 100*kermata;
        printf("\nKermata 1E: %d", kermata);
        kermata = resta/50;
        resta -= 50*kermata;
        printf("\nKermata 50L: %d", kermata);
        kermata = resta/20;
        resta -= 20*kermata;
        printf("\nKermata 20L: %d", kermata);
        kermata = resta/10;
        resta -= 10*kermata;
        printf("\nKermata 10L: %d", kermata);
    }

    return 0;
}
