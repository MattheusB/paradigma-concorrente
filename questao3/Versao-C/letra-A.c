#include <stdio.h>
#include <pthread.h>
#include <time.h>
#include <stdlib.h>
#include <unistd.h>

int superValue = -1;
pthread_mutex_t mutex;
pthread_cond_t cond;

int request(void *args){

    int myId = (int) args;
    int value = (rand() % 30);
    sleep(value);
    
    pthread_mutex_lock(&mutex);
    superValue = value;
    pthread_cond_signal(&cond);
    printf("myId = %d, value = %d\n", myId, value);
    pthread_mutex_unlock(&mutex);

    pthread_exit(NULL);
    return value;
}

int gateway(int numreplicas){
    pthread_t pthreads[numreplicas];
    int i;

    for (i = 0; i < numreplicas; i++){
        pthread_create(&pthreads[i], NULL, &request, (void*) i);
    }

    pthread_mutex_lock(&mutex);
    while(superValue == -1) pthread_cond_wait(&cond,&mutex);
    pthread_mutex_unlock(&mutex);
    return superValue;
}

int main(int argc, char *args[]){

    pthread_mutex_init(&mutex, NULL);
    pthread_cond_init(&cond,NULL);

    struct timespec tv;
    gettimeofday(&tv, NULL);
    srand(tv.tv_nsec);
    int n;
    printf("Digite o numero de threads: ");
    scanf("%d", &n);
    printf("superValue = %d\n", gateway(n));
}