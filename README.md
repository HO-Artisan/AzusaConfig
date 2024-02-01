<div align="center">

<img height="200" width="200" src="./icon/400x400-icon.png" alt="AzusaConfig Icon"/>

# AzusaConfig

###### A library to bring the Quilt Loader's Config system into Fabric/Forge/NeoForge.

</div>

> [!NOTE]
> Quilt is not supported because the [Quilt Loader](https://github.com/QuiltMC/quilt-loader) contains these functions natively. you can think of AzusaConfig as a port of [Quilt's Config system (quilt-config)](https://github.com/QuiltMC/quilt-config) to the Fabric/Forge/NeoForge.

## Use In Your Project

```groovy
repositories {
    maven { url "https://jitpack.io" }
}

dependencies {
    modImplementation "com.github.HO-Artisan:AzusaConfig:Tag"
}
```