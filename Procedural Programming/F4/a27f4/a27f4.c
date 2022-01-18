#include <stdio.h>
#include "simpio.h"
#include "genlib.h"

long encode(long Code);
bool check(long Final_code);

int main()
{
    long lower_limit, upper_limit, code, i;
    bool final_code;

    printf("Lower limit: ");
    lower_limit = GetLong();
    printf("Upper limit: ");
    upper_limit = GetLong();
    for (i=lower_limit; i<=upper_limit; i++)
    {
        code = encode(i);
        final_code = check(code);
        if (final_code==TRUE)
        {
            printf("Code: %ld Encoding: %ld isValid:yes\n", i, code, final_code);
        }
        else
        {
            printf("Code: %ld Encoding: %ld isValid:no\n", i, code, final_code);
        }

    }

    return 0;
}

long encode(long Code)
{
    long digits;
    digits = ((98-(Code*100)%97)%97);
    Code *= 100;
    Code += digits;
    return Code;
}

bool check(long Final_code)
{
    if ((Final_code%97)==1)
    {
        return TRUE;
    }
    else
    {
        return FALSE;
    }
}
