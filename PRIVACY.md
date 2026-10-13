# Privacy and security

## Device management APIs used

| What it does | Android API | When |
|---|---|---|
| Creates the daily user without the optional system apps, and becomes its profile owner | `DevicePolicyManager.createAndManageUser` | In Owner, when you tap Create |
| Blocks Private Space | `DevicePolicyManager.addUserRestriction` with `DISALLOW_ADD_PRIVATE_PROFILE` | In the daily user, when it first starts |
| Blocks debugging features | `DevicePolicyManager.addUserRestriction` with `DISALLOW_DEBUGGING_FEATURES` | In the daily user, when it first starts |
| Turns the backup service on, which Android turns off when a device owner is set | `DevicePolicyManager.setBackupServiceEnabled` | In the daily user when it first starts, and in Owner whenever you open Odysseus |
| Hides its own screen | `PackageManager.setComponentEnabledSetting` (its own screen only) | In the daily user, when it first starts |
| Removes itself as device owner | `DevicePolicyManager.clearDeviceOwnerApp` | In Owner, when you tap Deactivate |

## Risks to using Odysseus

-   Odysseus is a device-owner app, which gives it powers far beyond a normal app. Odysseus uses only the few listed above, but a future update signed with the same key could, for example, give Odysseus the ability to wipe your device.
-   By using Odysseus, you're using GrapheneOS in a non-standard way. GrapheneOS does not recommend changing the default installed apps, and Odysseus does not install Vanadium into the daily user. GrapheneOS recognizes device owners as the standard way to manage devices, and ADB is currently the only way to set one up. However, GrapheneOS advises against apps that use these APIs to "disallow a bunch of functionality." [1]

## Features

-   Odysseus has no network access and no permissions, and other apps can't use its powers.
-   Its only exported component is its launcher screen, its only library is the Kotlin standard library, and it's under 200 lines of Kotlin. You can check the component and permissions in `app/src/main/AndroidManifest.xml`.
-   Odysseus has reproducible builds. See [Reproducible builds](#reproducible-builds).
-   Odysseus has a simple design with a single screen.
-   Odysseus is tiny: under 100 kB installed.

## Verifying a release

This confirms the Odysseus you installed was signed by its developer.

Use [AppVerifier](https://github.com/soupslurpr/AppVerifier) with the package name and hash below. Odysseus has also been [domain verified](https://github.com/privacyguides/verified-apps/issues/6777) and [submitted](https://github.com/privacyguides/verified-apps/issues/6778) to Privacy Guides' [verified-apps-android](https://github.com/privacyguides/verified-apps-android) database. Once it's added, that app can verify Odysseus too.

```
org.getflourish.odysseus
FE:BB:57:70:19:90:D1:36:89:6A:ED:E8:DA:8B:3F:9D:62:C1:3F:0D:20:D2:AD:3B:E7:77:68:2A:B3:96:63:B0
```

Release signing certificate SHA-256: `febb57701990d136896aede8da8b3f9d62c13f0d20d2ad3be777682ab39663b0`

## Reproducible builds

This confirms the released APK was built from the public source code. Your build will match the release in every file; only the signature differs. Being open source with reproducible builds doesn't mean a third party has checked that the code is safe or that the builds match.

You need a computer with JDK 21, Gradle 9.5.1, and the Android SDK with platform 37.0 and build-tools 37.0.0, with `ANDROID_HOME` set. With Google's command-line tools, you can install the SDK parts with `sdkmanager "platforms;android-37.0" "build-tools;37.0.0"`. Check that `java -version` shows 21 before building.

1. Get the source for the release and build it:

   ```
   git clone https://github.com/flourish-today/odysseus.git
   cd odysseus
   git checkout v1.01
   gradle --no-daemon :app:assembleRelease -Pandroid.aapt2FromMavenOverride="$ANDROID_HOME/build-tools/37.0.0/aapt2"
   ```

2. Download `Odysseus-1.01.apk` from the [v1.01 release](https://github.com/flourish-today/Odysseus/releases/tag/v1.01) into the `odysseus` folder.

3. Unpack both APKs and compare them:

   ```
   mkdir rel mine
   unzip -q Odysseus-1.01.apk -d rel
   unzip -q app/build/outputs/apk/release/app-release-unsigned.apk -d mine
   diff -rq rel mine && echo MATCH
   ```

If it prints `MATCH`, the release contains exactly what you built.

For a stricter check, compare the whole unsigned APK byte for byte with the "Unsigned build SHA-256" in the release notes. On macOS, use `shasum -a 256` instead of `sha256sum`:

```
sha256sum app/build/outputs/apk/release/app-release-unsigned.apk
```

## Notes

[1] Relevant GrapheneOS posts about apps like Odysseus

[Tweet 1 (August 2021)](https://xxcancel.com/GrapheneOS/status/1422158415728627715)

> Device management APIs do work well already. You just need to grant those privileges to a device management app. It's possible Play supports it. We have no setup wizard integrating for setting a device policy manager as a device owner but that isn't an issue for work profiles.

[Tweet 2 (February 2026)](https://xxcancel.com/GrapheneOS/status/2023608038637146442)

> MDM apps are still sandboxed and can only do what's allowed by specific device management apps. ADB shell gives far more access than the device policy owner privileges. Just don't install and activate an app using APIs which mainly exist to disallow a bunch of functionality.
