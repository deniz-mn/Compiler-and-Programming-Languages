.class public StructTest
.super java/lang/Object

.method public <init>()V
    .limit stack 128
    .limit locals 128
    aload_0
    invokespecial java/lang/Object/<init>()V
    return
.end method

.method public main()V
    .limit stack 128
    .limit locals 128
    new Point
    dup
    ldc 3
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    ldc 4
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    invokespecial Point/<init>(Ljava/lang/Integer;Ljava/lang/Integer;)V
    astore 1
    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 1
    invokevirtual Point/sum()Ljava/lang/Integer;
    invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
    ldc 10
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    astore 2
    aload 1
    aload 2
    putfield Point/x Ljava/lang/Integer;
    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 1
    invokevirtual Point/sum()Ljava/lang/Integer;
    invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
    return
.end method

