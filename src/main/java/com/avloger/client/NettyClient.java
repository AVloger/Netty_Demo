package com.avloger.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;


/**
 * @author : avloger
 * @date : 2021/11/25 15:25
 */
public class NettyClient {
    public static void main(String[] args) throws InterruptedException {
        //创建线程组
        EventLoopGroup group = new NioEventLoopGroup();
        //创建启动助手
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new StringDecoder());
                        socketChannel.pipeline().addLast(new StringEncoder());
                        socketChannel.pipeline().addLast(new NettyClientHandler());
                    }
                });
        final ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 8090).sync();
        channelFuture.channel().closeFuture().sync();
        group.shutdownGracefully();
    }
}
