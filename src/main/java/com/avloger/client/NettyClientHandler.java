package com.avloger.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 客户端自定义处理
 * @author : avloger
 * @date : 2021/11/25 15:38
 */
public class NettyClientHandler extends SimpleChannelInboundHandler<String> {
    /**
     * 通道读取事件
     * @param channelHandlerContext
     * @param s
     * @throws Exception
     */
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        System.out.println("客户端接收的消息："+s);
    }

    /**
     * 与服务端建立连接
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush("你好，我是Netty客户端");
    }
}
