#include <stdio.h>
#include "genlib.h"
#include "simpio.h"

int main()
{
    int baros, ypsos, ilikia;
    double bmr;

    printf("Dwse baros se kila: ");
    baros = GetInteger();
    printf("Dwse ypsos se cm: ");
    ypsos = GetInteger();
    printf("Dwse ilikia se xronia: ");
    ilikia = GetInteger();
    bmr = 655+(9.6*baros)+(1.8*ypsos)-(4.7*ilikia);
    printf("To BMR einai: %g", bmr);

    return 0;
}
