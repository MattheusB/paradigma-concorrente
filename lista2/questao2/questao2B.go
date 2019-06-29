package main
import (
	"fmt"
	"math/rand"
	"time"
)

func gateway(num_replicas int, channel chan int) int{
	soma := 0
	start := time.Now()

	for index := 0; index < num_replicas; index++ {
		go request(channel, index)
	}

	for index := 0; index < num_replicas; index++ {
		endt := time.Since(start)
		if (endt >= 16 * time.Second) { //Se estiver executando depois de 16 sec finaliza
			return -1
		}

		soma = soma + <-channel
	}

	return soma
}

func request(channel chan int, id int) int{
	n := 1+rand.Intn(30)
	fmt.Printf("My id: %d, n: %d \n", id, n) //Para visualizar as go routines e os números sorteados
	time.Sleep(time.Duration(n) * time.Second)
	channel <- n
	return n
}

func makeTimestamp() int64 {
	return time.Now().UnixNano() / int64(time.Millisecond)
}

func main(){
	var num_replicas int
	channel := make(chan int)
	rand.Seed(makeTimestamp())

	fmt.Println("Informe o numero de goroutines: ")
	fmt.Scanln(&num_replicas)

	fmt.Println(gateway(num_replicas, channel))

}
