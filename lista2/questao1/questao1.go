package main
import (
	"fmt"
	"math/rand"
	"time"
)

func gateway(num_replicas int) int{
	value := -1
	for index := 0; index < num_replicas; index++ {
		fmt.Println(go request()) // Faltando ajustar aqui pra dar certo
	}							  // posição do go e set do value não estão dando certo :p
	return value
}

func request() int{
	n := 1+rand.Intn(29)
	time.Sleep(time.Duration(n) * time.Second)
	return n
}

func makeTimestamp() int64 {
    return time.Now().UnixNano() / int64(time.Millisecond)
}

func main(){
	rand.Seed(makeTimestamp())
	fmt.Println(gateway(4))
}