package main
import (
	"fmt"
	"math/rand"
	"time"
)

func gateway(num_replicas int, channel chan int) int{

	for index := 0; index < num_replicas; index++ {
		go request(channel, index)
	}
	return <-channel
}

func request(channel chan int, id int) int{
	startTime := time.Now()
	n := 1+rand.Intn(30)
	//fmt.Printf("My id: %d, n: %d \n", id, n) //Para visualizar as go routines e os números sorteados
	time.Sleep(time.Duration(n) * time.Second)
	endTime := time.Since(startTime)
	if (endTime > 8*time.Second) { //Demorou mais de 8 sec
		n = -1
	} 
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
