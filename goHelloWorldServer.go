package main

import (
	"fmt"
	"net/http"
)

func main() {

http.HandleFunc("/", SimpleServer)
http.ListenAndServe(":8000", nil)

}

func SimpleServer(w http.ResponseWriter, r *http.Request){
fmt.Fprint(w, "<h1>Hello Mundo</h1>")
}