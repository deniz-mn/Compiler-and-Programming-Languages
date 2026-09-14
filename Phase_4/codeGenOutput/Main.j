.class public Main
.super java/lang/Object

.method public <init>()V
    .limit stack 128
    .limit locals 128
    aload_0
    invokespecial java/lang/Object/<init>()V
    return
.end method

.method public static main([Ljava/lang/String;)V
    .limit stack 128
    .limit locals 128
    new StructTest
    dup
    invokespecial StructTest/<init>()V
    invokevirtual StructTest/main()V
    return
.end method
