package main

import (
	"fmt"
)

func main(){
	channel := make(chan int)
	join_channel := make(chan int)

	go producer(channel, join_channel)
	go consumer(channel)

	<-join_channel
}

func producer(aux_channel chan int, aux_join chan int){
	var count int = 0

	for {
		fmt.Printf("Value produced: (%d) \n", count)
		aux_channel <- count
		count = count + 1
	}
}

func consumer(aux_channel chan int){
	for {
		aux_goroutine := <-aux_channel

		fmt.Printf("Value consumed: (%d) \n", aux_goroutine)
	}
}

