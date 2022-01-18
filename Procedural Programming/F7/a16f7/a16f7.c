#include <stdio.h>
#include <string.h>

int main()
{
    char message[100];
    int i=0;
    int sum, exists, isFirst;

    printf("Insert a string: ");
    gets(message);

    sum = 0;
    exists = 0;
    isFirst = 0;
    while(message[i]!='\0') {
        if (message[i]>=48 && message[i]<=57) {
            if (isFirst!=0) {
                printf(" + ");
            }
            else {
                isFirst = 1;
            }
            exists = 1;
            sum += (message[i]-48);
            printf("%c", message[i]);
        }
        i++;
    }

    if (exists==0) {
        printf("No digits in input.");
    }
    else {
        printf(" = %d", sum);
    }

    return 0;
}
