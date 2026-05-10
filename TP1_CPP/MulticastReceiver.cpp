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

    if (sockfd == INVALID_SOCKET) {

        cout << "Erreur socket" << endl;
        return 1;
    }

    BOOL reuse = TRUE;

    setsockopt(sockfd,
               SOL_SOCKET,
               SO_REUSEADDR,
               (char *)&reuse,
               sizeof(reuse));

    sockaddr_in addr;

    addr.sin_family = AF_INET;
    addr.sin_port = htons(port);
    addr.sin_addr.s_addr = INADDR_ANY;

    bind(sockfd,
         (sockaddr *)&addr,
         sizeof(addr));

    ip_mreq group;

    group.imr_multiaddr.s_addr =
            inet_addr(multicastIP);

    group.imr_interface.s_addr =
            INADDR_ANY;

    setsockopt(sockfd,
               IPPROTO_IP,
               IP_ADD_MEMBERSHIP,
               (char *)&group,
               sizeof(group));

    cout << "Joined multicast group "
         << multicastIP << endl;

    char buffer[1024];

    while (true) {

        int addrlen = sizeof(addr);

        int n = recvfrom(sockfd,
                         buffer,
                         sizeof(buffer),
                         0,
                         (sockaddr *)&addr,
                         &addrlen);

        if (n > 0) {

            buffer[n] = '\0';

            cout << "Received : "
                 << buffer
                 << endl;
        }
    }

    closesocket(sockfd);

    WSACleanup();

    return 0;
}