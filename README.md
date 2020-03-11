[ ![Download](https://api.bintray.com/packages/scala-cash/io/secp256k1jni/images/download.svg) ](https://bintray.com/scala-cash/io/secp256k1jni/_latestVersion)

This project gives people a convenient way to use BCH's [libsecp256k1](https://github.com/scala-cash/secp256k1) on the JVM without compiling natives themselves. 

### Adding secp256k1jni to your project

To add `secp256k1jni` to your project you add it like this 

Add this to your build.sbt file

```
resolvers ++= Seq(
  Resolver.bintrayRepo("scala-cash", "io"),
  Resolver.sonatypeRepo("public")
)

libraryDependencies += "org.scash" %% "secp256k1jni" % <latestVersion>
```

Replace `<latestVersion>` with the version mentioned above in the badge

### Using secp256k1

The file [NativeSecp256k1.java](src/main/java/org/bitcoin/NativeSecp256k1.java) contains all the functionality for 

1. Verifying digital signatures
2. Producing digital signatures (Schnorr and ECDSA)
3. Computing a public key from a private key
4. Tweaking keys
5. Checking public key validity
 

Currently we have support for natives on

1. [windows 64 bit](natives/windows_64)
2. [linux 64 bit](natives/linux_64)
3. osx TODO

This uses a zero depdency library called [`native-lib-loader`](https://github.com/scijava/native-lib-loader).It does the appropriate loading of the library onto your classpath to be accessed. To tell if you have access to libsecp256k1 you can do the following

### Verifying you are connected to the library
```scala
import org.bitcoin.Secp256k1Context;

Secp256k1Context.isEnabled()
```

## How to generate binaries for each platform
- All libraries have to be compiled in a linux environment
- Clone [secp256k1](https://github.com/scala-cash/secp256k1) into your local machine

```
cd secp256k1
mkdir build
cd build
```

### Linux

```
cmake -GNinja .. -DSECP256K1_ENABLE_MODULE_ECDH=ON -DSECP256K1_ENABLE_JNI=ON
ninja
cp libsecp256k1_jni.so <target_dir>
```

### Windows 64
You need to have `mingw` installed
```
sudo apt install g++-mingw-w64-x86-64
sudo update-alternatives --config x86_64-w64-mingw32-g++ # Set the default mingw g++ compiler option to posix
```

```
cmake -GNinja .. -DSECP256K1_ENABLE_MODULE_ECDH=ON -DSECP256K1_ENABLE_JNI=ON -DCMAKE_C_COMPILER=x86_64-w64-mingw32-gcc -DCMAKE_SYSTEM_NAME=Windows -DJAVA_AWT_LIBRARY=NO_USE -DJAVA_JVM_LIBRARY=NO_USE -DCMAKE_BUILD_WITH_INSTALL_RPATH=ON -DSECP256K1_OPENSSL_TESTS=OFF
ninja
cp libsecp256k1_jni-0.dll <target_dir>
```

### OSX

TODO