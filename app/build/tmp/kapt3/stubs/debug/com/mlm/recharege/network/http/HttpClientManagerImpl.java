package com.mlm.recharege.network.http;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001c\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/mlm/recharege/network/http/HttpClientManagerImpl;", "Lcom/mlm/recharege/network/http/HttpClientManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "okHttpClient$delegate", "Lkotlin/Lazy;", "retrofit", "Lretrofit2/Retrofit;", "kotlin.jvm.PlatformType", "getRetrofit", "()Lretrofit2/Retrofit;", "app_debug"})
final class HttpClientManagerImpl implements com.mlm.recharege.network.http.HttpClientManager {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy okHttpClient$delegate = null;
    private final retrofit2.Retrofit retrofit = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public okhttp3.OkHttpClient getOkHttpClient() {
        return null;
    }
    
    @java.lang.Override()
    public retrofit2.Retrofit getRetrofit() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    public HttpClientManagerImpl(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
}