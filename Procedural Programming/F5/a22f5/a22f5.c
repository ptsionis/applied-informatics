#include <stdio.h>
#include "simpio.h"
#include "genlib.h"

long long GetLongLong(void);

int main()
{
    int i, sum;
    long long card, digits[16];

    //Insert data
    printf("Insert card number:");
    card = GetLongLong();
    printf("%lld is ", card);

    //Checking if card number has 16 digits
    if (card<1000000000000000 || card>9999999999999999)
    {
        printf("invalid.");

    }
    else
    {
        i=15;
        while (card>=10)
        {
            digits[i] = card%10;
            card -= card%10;
            card /= 10;
            i--;
            if (card<10)
            {
                digits[0] = card;
                card = 0;
            }
        }

        if (digits[0]<4 || digits[0]>7)
        {
            printf("invalid.");
        }
        else
        {
            for (i=0; i<16; i+=2)
            {
                digits[i] *= 2;
                if (digits[i]>=10)
                {
                    digits[i] = (digits[i]%10) + (digits[i]/10);
                }
            }
            sum = 0;
            for (i=0; i<16; i++)
            {
                sum += digits[i];
            }
            if (sum%10==0)
            {
                printf("VALID.");
            }
            else
            {
                printf("invalid.");
            }
        }
    }

    return 0;
}

long long GetLongLong(void)
{
    string line;
    long long value;
    char termch;

    while (TRUE) {
        line = GetLine();
        switch (sscanf(line, " %lld %c", &value, &termch)) {
          case 1:
            FreeBlock(line);
            return (value);
          case 2:
            printf("Unexpected character: '%c'\n", termch);
            break;
          default:
            printf("Please enter an integer\n");
            break;
        }
        FreeBlock(line);
        printf("Retry: ");
    }
}
