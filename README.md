## Secp256k1jni

This project gives people a convenient way to use BCH's [libsecp256k1](https://github.com/Bitcoin-ABC/bitcoin-abc/tree/master/src/secp256k1) on the JVM without compiling natives themselves. 

Currently we have support for natives on

1. [linux 32 bit](natives/linux_32)
2. [linux 64 bit](natives/linux_64)
3. [mac osx 64 bit](natives/osx_64)


This uses a zero depdency library called [`native-lib-loader`](https://github.com/scijava/native-lib-loader).It does the appropriate loading of the library onto your classpath to be accessed. To tell if you have access to libsecp256k1 you can do the following

```scala
sbt:root> project secp256k1jni
[info] Set current project to secp256k1jni (in build file:/home/user/dev/)
sbt:secp256k1jni> console
[info] Starting scala interpreter...
Welcome to Scala 2.12.7 (Java HotSpot(TM) 64-Bit Server VM, Java 1.8.0_191).
Type in expressions for evaluation. Or try :help.

scala> import org.bitcoin.Secp256k1Context;

scala> Secp256k1Context.isEnabled()
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
res0: Boolean = true
```

## Adding secp256k1jni to your project

To add `secp256k1jni` to your project you add it like this 

First you add the following plugin to your project/plugins.sbt file

```
addSbtPlugin("com.codecommit" % "sbt-github-packages" % "0.2.1")
```

then this line to the build.sbt file

```
resolvers += Resolver.githubPackagesRepo("org.scash", "secp256k1jni")
```

## Using secp256k1

The file [NativeSecp256k1.java](src/main/java/org/bitcoin/NativeSecp256k1.java) contains basic functionality for 

1. Verifying digital signatures
2. Producing digital signatures
3. Computing a public key from a private key
4. tweaking keys
5. Checking public key validity

## Binaries
TODO

### Linux 32 bit

TODO

### Linux 64 bit

TODO


### Windows 64 bit

To build binaries for windows, you need to cross compile them from a linux machine. This can be done with the following commands. The origin of these commands [comes from ACINQ](https://github.com/ACINQ/bitcoin-lib/blob/bf115a442e17e1522eba98a362473fddd9b1ffe6/BUILDING.md#for-windows-64-bits)


```
$ sudo apt install g++-mingw-w64-x86-64
$ sudo update-alternatives --config x86_64-w64-mingw32-g++ # Set the default mingw32 g++ compiler option to posix.
```

```
# this is needed to compile shared libraries, otherwise you'll get:
# libtool: warning: undefined symbols not allowed in x86_64-w64-mingw32 shared libraries; building static only
$ echo "LDFLAGS = -no-undefined" >> Makefile.am
$ ./configure --host=x86_64-w64-mingw32 --enable-experimental --enable-module_ecdh --enable-jni && make clean && make CFLAGS="-std=c99"
cp ./.libs/libsecp256k1-0.dll ../src/main/resources/fr/acinq/native/Windows/x86_64/secp256k1.dll
```


#### Windows 64 bit signature

TODO
