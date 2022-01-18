#include <stdio.h>
#include "simpio.h"
#include "genlib.h"

#define WORKS 100

typedef struct
{
    char name[60];
    int start_month;
    int month_dur;
} workT;

workT ReadWorkpackages(int total);
workT FindFirstWp(int total, workT pin[]);
int FindMakespan(int total, workT pin[]);

int main()
{
    int total, total_dur;
    workT all_works[WORKS];
    workT first_work;

    printf("Total work packages: ");
    total = GetInteger();
    for (int i=0; i<total; i++) {
        all_works[i] = ReadWorkpackages(total);
    }
    first_work = FindFirstWp(total, all_works);
    printf("FIRST WP: %s start: %d duration: %d", first_work.name, first_work.start_month, first_work.month_dur);
    total_dur = FindMakespan(total, all_works);
    printf("\nTotal duration = %d", total_dur);

    return 0;
}

workT ReadWorkpackages(int total)
{
    workT pin;
    printf("WP Name:");
    gets(pin.name);
    printf("WP Start Month:");
    pin.start_month = GetInteger();
    printf("WP Duration:");
    pin.month_dur = GetInteger();

    return (pin);
}

workT FindFirstWp(int total, workT pin[])
{
    workT firstpin = pin[0];
    for (int i=1; i<total; i++) {
        if (firstpin.start_month > pin[i].start_month) {
            firstpin = pin[i];
        }
    }

    return firstpin;
}

int FindMakespan(int total, workT pin[])
{
    int maxdur, k;

    maxdur = pin[0].month_dur;
    k = 0;
    for (int i=1; i<total; i++) {
        if (pin[i].month_dur > maxdur) {
            maxdur = pin[i].month_dur;
            k = i;
        }
    }

    maxdur += pin[k].start_month;

    return maxdur;
}
