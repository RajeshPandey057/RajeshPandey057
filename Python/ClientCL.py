import socket


try:
    socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
except socket.error:
    print("Oops!:(\n something went wrong connecting the socket")
    exit()
while 1:
    message = input("> ")
    message = message.encode()
    try:
        socket.sendto(message, ("10.0.1.29", 9999))
        data, ip = socket.recvfrom(1024)
        print("{}: {}".format(ip, data.decode()))
    except socket.error:
        print("Error! {}".format(socket.error))
        exit()
