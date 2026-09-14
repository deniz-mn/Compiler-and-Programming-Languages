.class public Point
.super java/lang/Object

.field public x Ljava/lang/Integer;
.field public y Ljava/lang/Integer;

.method public <init>()V
    .limit stack 128
    .limit locals 128
    aload_0
    invokespecial java/lang/Object/<init>()V
    aload_0
    ldc 0
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    putfield Point/x Ljava/lang/Integer;
    aload_0
    ldc 0
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    putfield Point/y Ljava/lang/Integer;
    return
.end method

.method public <init>(Ljava/lang/Integer;Ljava/lang/Integer;)V
    .limit stack 128
    .limit locals 128
    aload_0
    invokespecial java/lang/Object/<init>()V
    aload_0
    aload 1
    putfield Point/x Ljava/lang/Integer;
    aload_0
    aload 2
    putfield Point/y Ljava/lang/Integer;
    return
.end method

.method public sum()Ljava/lang/Integer;
    .limit stack 128
    .limit locals 128
    aload_0
    getfield Point/x Ljava/lang/Integer;
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer/intValue()I
    aload_0
    getfield Point/y Ljava/lang/Integer;
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer/intValue()I
    iadd
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    areturn
    aconst_null
    areturn
.end method

