#include <stdio.h>
#include "simpio.h"
#include "genlib.h"

bool Valid_Time(int Hours, int Minutes, int Seconds);

int main()
{
    int hours, minutes, seconds;
    bool time;

    printf("Dose tis ores: ");
    hours = GetInteger();
    printf("Dose ta lepta: ");
    minutes = GetInteger();
    printf("Dose ta deyterolepta: ");
    seconds = GetInteger();
    time = Valid_Time(hours, minutes, seconds);
    if (time == TRUE)
    {
        printf("WRA EGKYRH");
    }
    else
    {
        printf("WRA MH EGKYRH");
    }
}

bool Valid_Time(int Hours, int Minutes, int Seconds)
{
    if ((Hours>=0 && Hours<24) && (Minutes>=0 && Minutes<60) && (Seconds>=0 && Seconds<60))
    {
        return TRUE;
    }
    else
    {
        return FALSE;
    }
}
