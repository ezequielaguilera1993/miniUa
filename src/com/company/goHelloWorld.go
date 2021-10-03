package main

import (
"fmt"
"net/http"
)

func main() {
http.HandleFunc("/", SimpleServer)
}

func SimpleServer(w http.ResponseWriter, r *http.Request){
fmt.Fprint(w, "Hello %s", r.URL.Path)
}