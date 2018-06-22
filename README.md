# SIT CS521 TCP Sockets

### Example client-server app:
1. client reads line from standard input (inFromUser stream) , sends to server via socket (outToServer stream)
2. server reads line from socket
3. server converts line to uppercase, sends back to client
4. client reads, prints  modified line from socket (inFromServer stream)
