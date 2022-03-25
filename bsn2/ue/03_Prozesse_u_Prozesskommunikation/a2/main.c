#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>

int createChild(int counter)
{
    int wait_status;
    pid_t pid;
    if (counter < 3)
    {
        pid = fork();
        if (pid == -1)
        {
            printf("%s", "Fehler beim forken!");
            exit(EXIT_FAILURE);
        }
        else if (pid == 0)
        {
            pid_t tmp_pid;
            tmp_pid = createChild(++counter);
            waitpid(tmp_pid, &wait_status, 0);
            printf("%s %i\t %s %i\t %s %i\n", "Kind: fork() =", pid, "PID =", getpid(), " PPID =", getppid());
        }
        else
        {
            waitpid(pid, &wait_status, 0);
            if (counter == 0)
            {
                printf("%s %i\t %s %i\t %s %i\n", "Eltern: fork() =", pid, "PID =", getpid(), " PPID =", getppid());
            }
        }
    }
    return pid;
}

int main(void)
{
    int counter = 0;
    createChild(counter);
    return EXIT_SUCCESS;
}