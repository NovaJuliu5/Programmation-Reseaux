#include <iostream>
#include <winsock2.h>
#include <ws2tcpip.h>

#pragma comment(lib, "ws2_32.lib")

using namespace std;

int main(int argc, char *argv[]) {

    if (argc < 3) {

        cout << "Usage : "
             << argv[0]
             << " <multicast_ip> <port>"
             << endl;

        return 1;
    }

    WSADATA wsa;

    WSAStartup(MAKEWORD(2, 2), &wsa);

    char *multicastIP = argv[1];

    int port = atoi(argv[2]);

    SOCKET sockfd =
            socket(AF_INET, SOCK_DGRAM, 0);

    sockaddr_in addr;

    addr.sin_family = AF_INET;
    addr.sin_port = htons(port);

    addr.sin_addr.s_addr =
            inet_addr(multicastIP);

    int ttl = 1;

    setsockopt(sockfd,
               IPPROTO_IP,
               IP_MULTICAST_TTL,
               (char *)&ttl,
               sizeof(ttl));

    cout << "Begin typing..." << endl;

    string message;

    while (true) {

        getline(cin, message);

        sendto(sockfd,
               message.c_str(),
               message.length(),
               0,
               (sockaddr *)&addr,
               sizeof(addr));
    }

    closesocket(sockfd);

    WSACleanup();

    return 0;
}