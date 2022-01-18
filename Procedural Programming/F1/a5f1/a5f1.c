#include <stdio.h>
#include "genlib.h"
#include "simpio.h"

int main()
{
    int wresErgasias;
    long wriaiaAntimisthia;
    double pososto, akatharistes, kratisi, kathares;

    printf("Dwse ton arithmo ton wrwn: ");
    wresErgasias = GetInteger();
    printf("Dwse wriaia antimisthia: ");
    wriaiaAntimisthia = GetLong();
    printf("Dwse pososto twn kratisewn: ");
    pososto = GetReal();
    kathares = wresErgasias*wriaiaAntimisthia;
    kratisi = kathares*pososto;
    akatharistes = kathares+kratisi;
    printf("Oi akatharistes apodoxes einai: %g", akatharistes);
    printf("\nOi kratiseis einai: %g", kratisi);
    printf("\nOi kathares apodoxes einai: %g", kathares);

    return 0;
}
