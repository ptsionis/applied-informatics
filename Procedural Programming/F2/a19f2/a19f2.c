#include <stdio.h>
#include "genlib.h"
#include "simpio.h"

int main()
{
    float teli_kik;
    int cogr;

    printf("Dwse gram CO2/kmh: ");
    cogr = GetInteger();
    if (cogr<=120)
    {
        teli_kik = cogr*0.9;
    }
    else if (cogr<=140)
    {
        teli_kik = cogr*1.1;
    }
    else
    {
        teli_kik = cogr*1.7;
    }
    printf("To poso pliromis einai: %0.1f", teli_kik);

    return 0;
}
