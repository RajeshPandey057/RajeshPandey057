import socket

socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
socket.bind(("", 9999))

while 1:
    data, ip = socket.recvfrom(1024)
    print("{}: {}".format(ip, data.decode(encoding="utf-8").strip()))
    socket.sendto(data, ip)
