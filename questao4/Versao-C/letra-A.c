#include <stdio.h>
#include <pthread.h>
#include <time.h>
#include <stdlib.h>
#include <unistd.h>
#include <semaphore.h>

int superValue = -1;
pthread_mutex_t mutex;
pthread_cond_t cond;
sem_t sema;

int request(void *args){

    int myId = (int) args;
    int value = (1+rand() % 30);
    sleep(value);
    
    pthread_mutex_lock(&mutex);
    if(superValue != -1) sem_wait(&sema);
    superValue = value;
    sem_post(&sema);
    printf("myId = %d, value = %d\n", myId, value);
    pthread_mutex_unlock(&mutex);

    pthread_exit(NULL);
    return value;
}

void contaOito(){
    
    sleep(8);
    sem_post(&sema);
}

int gateway(int numreplicas){
    pthread_t pthreads[numreplicas],contaoito;
    int i;
    //coloquei o lock na criação e na execução das threads para elas só passarem a executar o código da rc depois que todas forem criadas
    pthread_mutex_lock(&mutex);
    for (i = 0; i < numreplicas; i++){
        pthread_create(&pthreads[i], NULL, &request, (void*) i);
    }
    pthread_create(&contaoito,NULL,&contaOito,NULL);
    pthread_mutex_unlock(&mutex);
    
    sem_wait(&sema);  
    return superValue;
}

int main(int argc, char *args[]){

    pthread_mutex_init(&mutex, NULL);
    sem_init(&sema,0,0);
    pthread_cond_init(&cond,NULL);

    struct timespec tv;
    gettimeofday(&tv, NULL);
    srand(tv.tv_nsec);
    int n;
    printf("Digite o numero de threads: ");
    scanf("%d", &n);
    printf("superValue = %d\n", gateway(n));
}