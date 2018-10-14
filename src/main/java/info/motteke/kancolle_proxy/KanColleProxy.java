package info.motteke.kancolle_proxy;

import lombok.RequiredArgsConstructor;

import info.motteke.kancolle_proxy.support.org.littleshoot.proxy.HttpFiltersSource;
import info.motteke.kancolle_proxy.support.org.littleshoot.proxy.HttpProxyServer;
import info.motteke.kancolle_proxy.support.org.littleshoot.proxy.impl.DefaultHttpProxyServer;

@RequiredArgsConstructor
public class KanColleProxy {
    private final int port;

    private final boolean localOnly;

    private final HttpFiltersSource filtersSource;

    private HttpProxyServer server;

    public void start() {
        server = DefaultHttpProxyServer.bootstrap()
                                       .withPort(port)
                                       .withAllowLocalOnly(localOnly)
                                       .withName("kancolle-proxy")
                                       .withFiltersSource(filtersSource)
                                       .start();
    }

    public void stop() {
        server.stop();
    }
}
