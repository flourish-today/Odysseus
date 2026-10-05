## Security and trust

### What Odysseus does with its device-owner powers

These are the device-management APIs Odysseus uses.

| What it does | Android API | When |
|---|---|---|
| Creates the daily user without the optional system apps, and becomes its profile owner | `DevicePolicyManager.createAndManageUser` | In Owner, when you tap Create |
| Blocks Private Space | `addUserRestriction` with `DISALLOW_ADD_PRIVATE_PROFILE` | In the daily user, when it first starts |
| Blocks debugging features | `addUserRestriction` with `DISALLOW_DEBUGGING_FEATURES` | In the daily user, when it first starts |
| Turns the backup service on | `DevicePolicyManager.setBackupServiceEnabled` | In the daily user when it first starts, and in Owner whenever you open Odysseus |
| Hides its own screen | `PackageManager.setComponentEnabledSetting` (its own screen only) | In the daily user, when it first starts |
| Removes itself as device owner | `DevicePolicyManager.clearDeviceOwnerApp` | In Owner, when you tap Deactivate |

### Risks to using Odysseus

-   Odysseus is a device-owner app, which gives it powers far beyond a normal app. Odysseus uses only a few of them as listed above, but a future update signed with the same key could, for example, give Odysseus the ability to wipe your device.
-   By using Odysseus, you're using GrapheneOS in a non-standard way. GrapheneOS does not recommend changing the default installed apps, and Odysseus does not install Vanadium into the daily user. GrapheneOS recognizes device owners as the standard way to manage devices, and ADB is currently the only way to enable them. They do not recommend using to, "disallow a bunch of functionality". [1]

### Features

-   Odysseus has no network access and no permissions, and other apps can't use its powers.
-   Odysseus has a clean and straightforward design, there's only one page of the app.
-   Odysseus is very small. It will take up effectively zero space on your device.

### Verifying a release

Odysseus 1.0 can be checked against its source: a fresh build matches the release in every file except one build-info record, which the next version will remove.

**Check the signature.** The recommended way to verify Odysseus is to use [verified-apps-android](https://github.com/privacyguides/verified-apps-android) by Privacy Guides. Odysseus has been [domain verified](https://github.com/privacyguides/verified-apps/issues/6777) and [submitted](https://github.com/privacyguides/verified-apps/issues/6778) to be added to the database.

Release signing certificate SHA-256: `febb57701990d136896aede8da8b3f9d62c13f0d20d2ad3be777682ab39663b0`

**Build it yourself.** You need JDK 21, Gradle 9.5.1, and the Android SDK with platform 37 and build-tools 37.0.0, with `ANDROID_HOME` set.

```
git clone https://github.com/flourish-today/odysseus.git
cd odysseus
git checkout v1.0
gradle --no-daemon :app:assembleRelease -Pandroid.aapt2FromMavenOverride="$ANDROID_HOME/build-tools/37.0.0/aapt2"
```

To check it against the signed release, compare their contents:

```
mkdir rel mine
unzip -q Odysseus-1.0.apk -d rel
unzip -q app/build/outputs/apk/release/app-release-unsigned.apk -d mine
diff -rq -x MANIFEST.MF -x '*.SF' -x '*.RSA' -x version-control-info.textproto rel mine && echo MATCH
```

If it prints `MATCH`, the release contains exactly what you built. The skipped files are the release's signature and a record of whether the build had git history, which differs between my build and a fresh clone.

[1] GrapheneOS relevant tweets

[Tweet 1](https://xxcancel.com/GrapheneOS/status/1422158415728627715)
> Device management APIs do work well already. You just need to grant those privileges to a device management app. It's possible Play supports it. We have no setup wizard integrating for setting a device policy manager as a device owner but that isn't an issue for work profiles.

[Tweet 2](https://xxcancel.com/GrapheneOS/status/2023608038637146442)
> MDM apps are still sandboxed and can only do what's allowed by specific device management apps. ADB shell gives far more access than the device policy owner privileges. Just don't install and activate an app using APIs which mainly exist to disallow a bunch of functionality.
