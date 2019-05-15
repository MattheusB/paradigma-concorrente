#include <stdio.h>
#include <assert.h>
#include <pthread.h>

long int counter = 0;
pthread_t mutex;

void* run (void* args){
    int my_id = (int) args;
    long int j;

    for(j = 0;j < 1e7; j++){
        pthread_mutex_lock(&mutex);
        counter = counter + 1;
        pthread_mutex_unlock(&mutex);
    }
    
    printf("my_id=%d j=%ld counter=%ld\n", my_id,j, counter);
}

int main (int argc, char *argv[]){

    int i;
    pthread_t pthreads[3];
    pthread_mutex_init(mutex, NULL);

    for (i = 0; i < 3; i++){
        pthread_create(pthreads[i], NULL, &run, (void*) i);
    }

    for(i = 0; i < 3; i++){
        pthread_join(pthreads[i], counter);
    }
}