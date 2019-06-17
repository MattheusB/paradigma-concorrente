package lista2.questao3.go

import (
	"fmt"
)

func main(){
	channel := make(chan int)
	join_channel := make(chan int)

	go prod(channel, join_channel)
	go cons(channel)

	<-join_channel
}

func producer(aux_channel chan int, aux_join){
	var count int = 0

	for {
		fmt.Printf("Value produced: (%d) \n", n)
		aux_channel <- count
		count = count + 1
	}
}

func consumer (aux_channel chan int){
	for {
		aux_goroutine := aux_channel

		fmt.Printf("Value consumed: (%d) \n", aux_goroutine)
	}
}

