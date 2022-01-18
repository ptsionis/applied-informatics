#include <stdio.h>
#include "genlib.h"
#include "simpio.h"

int main()
{
    long kodikos_arithmos;
    double etisios_misthos, ebdomadiaia_amoibi, oriaia_amoibi;
    int ores_ergasias;

    printf("Dwse ton kwdiko: ");
    kodikos_arithmos = GetLong();
    if (kodikos_arithmos>=1000)
    {
        printf("Dwse ton ethsio mistho: ");
        etisios_misthos = GetReal();
        ebdomadiaia_amoibi = etisios_misthos/52;
    }
    else
    {
        printf("Dwse tis wres ebdomadiaias ergasias: ");
        ores_ergasias = GetInteger();
        printf("Dwse thn amoibh ana wra: ");
        oriaia_amoibi = GetReal();
        if (ores_ergasias>40)
        {
            ebdomadiaia_amoibi = (40*oriaia_amoibi)+((ores_ergasias-40)*(oriaia_amoibi+(0.5*oriaia_amoibi)));
        }
        else
        {
            ebdomadiaia_amoibi = ores_ergasias*oriaia_amoibi;
        }
    }
    printf("H ebdomadiaia amoibh einai: %g", ebdomadiaia_amoibi);

    return 0;
}
