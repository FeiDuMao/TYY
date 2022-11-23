const ws = new WebSocket("ws://localhost:8000/websocket/")

ws.addEventListener('open', ev => {
    console.log(ev)
})
ws.addEventListener('close', ev => {
    console.log(ev)
})
ws.addEventListener('message', ev => {
    console.log(ev)
})


function f() {

    ws.send("req")
}

f()