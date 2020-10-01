#include <stdio.h>

int main()
{

    int minLen, maxLen, minWid, maxWid;
    int ans, counter, remi;
    int i, j, k, l;
    scanf("%d", &minLen);
    scanf("%d", &maxLen);
    scanf("%d", &minWid);
    scanf("%d", &maxWid);
    ans = 0;
    for (i = minLen; i <= maxLen; i++)
    {
        for (j = minWid; j <= maxWid; j++)
        {
            k = i;
            l = j;
            counter = 1;
            while (counter != 0)
            {
                if (k < l)
                {
                    remi = (int)(l / k);
                    ans += remi;
                    counter = l % k;
                    l = counter;
                }
                else
                {
                    remi = (int)(k / l);
                    ans += remi;
                    counter = k % l;
                    k = counter;
                }
            }
        }
    }
    printf("%d", ans);
    return 0;
}
