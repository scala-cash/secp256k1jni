[ ![Download](https://api.bintray.com/packages/scala-cash/io/secp256k1jni/images/download.svg) ](https://bintray.com/scala-cash/io/secp256k1jni/_latestVersion)
 
## BCH Secp256k1jni

This project gives people a convenient way to use BCH's [libsecp256k1](https://github.com/Bitcoin-ABC/bitcoin-abc/tree/master/src/secp256k1) on the JVM without compiling natives themselves. 

Currently we have support for natives on

1. [linux 32 bit](natives/linux_32)
2. [linux 64 bit](natives/linux_64)

This uses a zero depdency library called [`native-lib-loader`](https://github.com/scijava/native-lib-loader).It does the appropriate loading of the library onto your classpath to be accessed. To tell if you have access to libsecp256k1 you can do the following

## Verifying you are connected to the library
```scala
import org.bitcoin.Secp256k1Context;

Secp256k1Context.isEnabled()
```

## Using secp256k1

The file [NativeSecp256k1.java](src/main/java/org/bitcoin/NativeSecp256k1.java) contains all the functionality for 

1. Verifying digital signatures
2. Producing digital signatures (Schnorr and ECDSA)
3. Computing a public key from a private key
4. Tweaking keys
5. Checking public key validity


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

