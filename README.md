<div align="center"><img src="downloads-images/icon.svg" alt="Odysseus icon" width="128" /></div>

<h1 align="center">Odysseus</h1>

<br />

<p align="center">
  <a href="app/build.gradle.kts"><img alt="API 35+" src="https://img.shields.io/badge/API_35%2B-3DDC84?style=for-the-badge&logo=android&logoColor=black" /></a>
  <a href="app/src/main/java/org/getflourish/odysseus"><img alt="Kotlin" src="https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white" /></a>
  <img alt="Built For GrapheneOS" src="https://img.shields.io/badge/Built_For_GrapheneOS-1E88E5?style=for-the-badge" />
  <br />
  <a href="PRIVACY.md#features"><img alt="No network access" src="https://img.shields.io/badge/network-none-2EA043?style=for-the-badge&labelColor=1F4D2B" /></a>
  <a href="app/src/main/AndroidManifest.xml"><img alt="0 permissions" src="https://img.shields.io/badge/permissions-0-2EA043?style=for-the-badge&labelColor=1F4D2B" /></a>
  <a href="PRIVACY.md#reproducible-builds"><img alt="Reproducible builds" src="https://img.shields.io/badge/builds-reproducible-2EA043?style=for-the-badge&labelColor=1F4D2B" /></a>
  <br />
  <a href="LICENSE"><img alt="License: CC0 1.0" src="https://img.shields.io/badge/license-CC0_1.0-FF9100?style=for-the-badge&labelColor=BF360C" /></a>
  <img alt="Code size" src="https://img.shields.io/github/languages/code-size/flourish-today/odysseus?style=for-the-badge&color=40C4FF&labelColor=0D47A1" />
  <a href="https://github.com/flourish-today/odysseus/releases/latest"><img alt="Latest release" src="https://img.shields.io/github/v/release/flourish-today/odysseus?style=for-the-badge&color=FF5252&labelColor=8F1D21&logo=github" /></a>
</p>

<p align="center"><b>Make a GrapheneOS daily user with no browser and no app installs, just the apps you choose. Odysseus lets you turn your GrapheneOS phone into a dumbphone, but with all the benefits of a powerful smartphone (maps, messaging, password manager, etc), and none of the <a href="https://xxcancel.com/GrapheneOS/search?f=tweets&q=dumb%20phone&since=&until=&min_faves=">drawbacks</a> of a dumbphone.</b></p>

<h2 align="center">Download</h2>

<div align="center">
  <a href="https://apps.obtainium.imranr.dev/redirect?r=obtainium://add/https://github.com/flourish-today/Odysseus/releases"><img src="/downloads-images/badge_obtainium.png" alt="Get it on Obtainium" height="80" /></a>
  <a href="https://github.com/flourish-today/Odysseus/releases"><img src="/downloads-images/badge_github.png" alt="Get it on GitHub" height="80" /></a>
</div>
<p align="center">Verify your download with <a href="https://github.com/soupslurpr/AppVerifier">AppVerifier</a>:</p>

```
org.getflourish.odysseus
FE:BB:57:70:19:90:D1:36:89:6A:ED:E8:DA:8B:3F:9D:62:C1:3F:0D:20:D2:AD:3B:E7:77:68:2A:B3:96:63:B0
```
## How it works

<details>
<summary><b>Click here to see how it works</b></summary>
<br>

- **Owner is the manager.** You use Owner to set up the daily user and to add or update its apps. Owner remains unrestricted to manage the device. Much of the setup Odysseus lets you create is based around GrapheneOS's [improved user profiles](https://grapheneos.org/features#improved-user-profiles).
- **The daily user is a restricted user for everyday use.** Odysseus creates it without the optional system apps, so on GrapheneOS it starts without the browser (Vanadium). It starts with a basic set: App Store, Contacts, Files, Settings, and Phone. You add the apps you want from Owner, then turn off app installs for the daily user. Once app installs are off, there's no way to add more from inside it.
- **No off switch in the daily user.** When the daily user starts for the first time, Odysseus blocks Private Space and debugging features in it, and hides its own icon. There is no Odysseus screen in the daily user to turn the restrictions off.

</details>

## Setup

### Before you start

-   You need a GrapheneOS phone, a USB-C cable, and a computer with [ADB installed](https://developer.android.com/tools/adb).
-   **Back up all important data off your device.** You should do this even if you weren't using Odysseus, in case your phone gets lost or breaks.
-   Android only allows a device owner on a phone with no accounts, no other users, and no Private Space. The most reliable way is a factory reset. Otherwise, remove every account, every other user, and Owner's Private Space. If you only use Owner, removing all accounts in Settings and your Private Space is enough.
-   Owner's password is what keeps the daily user restricted. Pick one you can't easily get to yourself. For example, have someone you trust set it, or split it so you each know only half. You can also use a long password stored somewhere inconvenient or a long password you have memorized. Whatever method you pick, consider memorizing part of it and not sharing that part, so only you can get into the phone. If the password is lost, the only way back is a factory reset.
-   You may want to keep the owner password simple until setup is finished.
-   Consider setting the auto reboot timer longer than you usually go without using your phone. After each automatic restart, you have to unlock Owner before you can switch to the daily user.

### Instructions

1.  Install Odysseus in Owner.
2.  Enable Developer options: open Settings → About phone, tap Build number seven times, and enter your PIN or password.
3.  In Settings → System → Developer options, turn on USB debugging.
4.  Connect the phone to your computer. When the phone asks whether to allow USB debugging, tap Allow.
5.  On your computer, open a terminal (Command Prompt on Windows) and run the command Odysseus shows on its screen:
    `adb shell dpm set-device-owner org.getflourish.odysseus/.Receiver`
    Odysseus should now say "Device owner: active."
6.  Turn off Developer options in Settings → System → Developer options (this will also turn off USB debugging.
7.  In Odysseus, under Create user, type a name like "user" and tap Create.
8.  In Owner, go to Settings → System → Users → (the daily user) → Install available apps, and choose the apps you want. It's recommended to install all GrapheneOS default apps besides Vanadium to avoid breakage. Without Camera, for example, you can't take photos in Signal. App installs are already enabled for a new user, so you don't need to turn them on here. You can add more apps later (see [Adding apps](#adding-apps)).
9.  Switch to the daily user (swipe down twice from the top of the screen and tap the user icon) and finish its setup. In its App Store, check that Vanadium Config and Vanadium System WebView are installed, and install them if not. Apps that use WebView need them (see [Usability limitations](#usability-limitations)).
10. Go back to Owner, open Settings → System → Users → (the daily user), and set App installs and updates to Disabled.
11. In the daily user, check that Odysseus's icon is gone from the home screen, that Odysseus can't be uninstalled in Settings → Apps, and that Private Space can't be set up.

### Troubleshooting

-   **The `set-device-owner` command fails with an error about accounts or users.** An account, another user, or Private Space still exists. Remove it and run the command again. A reliable way to set up Odysseus is after a factory reset.
-   **ADB says no devices were found, or that the device is unauthorized.** Check that the cable is connected and USB debugging is on, then unplug and reconnect the phone and tap Allow when it asks.

## Adding apps

To add an app to the daily user:

1.  Install the app in Owner.
2.  In Owner, go to Settings → System → Users → (the daily user) and set App installs and updates to Enabled.
3.  Tap Install available apps and choose the app.
4.  Set App installs and updates back to Disabled before you switch to the daily user.

To update an app, simply update it in Owner. Both users share the same installed copy of an app, so the daily user gets the update too. You don't need to enable App installs and updates to get updates to your apps. That setting only stops the daily user itself from starting an install or update.

## To undo it

1.  In Owner, delete the daily user: Settings → System → Users → (the daily user) → Delete user.
2.  Open Odysseus and tap Deactivate.
3. You can now uninstall Odysseus.

If you tap Deactivate without deleting the daily user, the daily user stays restricted: Odysseus remains its profile owner and can't be uninstalled there. Deleting the daily user is what removes its restrictions.

## Usability limitations

-   Leaving system apps out of the daily user can break apps. Links that would normally open in a browser won't open, because there is none.
-   WebView:
    -   **With Vanadium Config and Vanadium System WebView installed** (setup step 7), apps that need WebView work, but any app with a built-in browser may still let you browse the web. Choose the daily user's apps with that in mind. If an app lets you browse sites beyond the ones it needs, consider asking its developer to follow [Android security best practices](https://developer.android.com/privacy-and-security/security-best-practices#webview).
    -   **Without them**, built-in browsers can't load pages, but apps that need WebView break.
-   Private Space is unavailable in all users.

## FAQ

-   **Does Odysseus use AI?** Yes. This app was developed with Claude Opus 5.5. Its code was reviewed by GPT-6 Astra. AI security reviews of Odysseus found no way for other apps to use its device-owner powers and no network access. They found minor reliability issues, most of which have been fixed or found inconsequential. More reviews are welcome.
-   **Is Odysseus secure?** Odysseus uses the intended way to restrict devices on Android. It's tiny, requests no permissions, and only does what it says. See more info in [PRIVACY.md](PRIVACY.md). You can verify you got the real Odysseus APK using the [SHA256 Signing Certificate](PRIVACY.md#verifying-a-release), and verify that its source code matches the released APK through [reproducible builds](PRIVACY.md#reproducible-builds).
-   **Is Odysseus privacy respecting?** Yes. There's no telemetry, no permissions, and no network access.
-   **What are the risks?** One risk with Odysseus, and device-owner apps in general, is the amount of trust you have to put in them. Device-owner apps are given a huge amount of permissions by Android. Odysseus uses only the few listed in [PRIVACY.md](PRIVACY.md), and they can be undone.
-   **Will I always need ADB?** In the future, depending on GrapheneOS, Odysseus may be updated so you can install it and make it the device owner without ADB, through QR code provisioning during initial device setup ([issue](https://github.com/GrapheneOS/platform_packages_apps_SetupWizard2/issues/35) / [earlier attempt, closed](https://github.com/GrapheneOS/platform_packages_apps_SetupWizard2/pull/40)). You can add reactions to the issue to show support, but please only comment if you have something meaningful to add.
-   **What if I have an iPhone or iPad that I want to achieve the same result on?** You should use Apple Configurator ([guide1](https://redlib.catsarch.com/r/nosurf/comments/1731ozp/how_to_turn_your_your_iphone_into_dumb_phone/) / [guide2](https://stopa.io/post/297)) to manage your devices, remove the browser and prevent new app installs. A macOS device and a factory reset of your iPhone/iPad are required for the initial setup.
-   **There's been no activity recently, is it still safe?** This is a simple app which will not require many updates. Odysseus works on Android 17-based GrapheneOS. If something breaks after an update, please open an [issue](https://github.com/flourish-today/Odysseus/issues).


## Screenshots

<details> <summary><b>Click here to see screenshots</b></summary> <br>

### Owner

<div align="center"> <img src="downloads-images/Screenshot_20261004-174600.png" alt="Owner's home screen with Odysseus installed alongside the default GrapheneOS apps" style="width: 250px" /> <img src="downloads-images/Screenshot_20261004-174606.png" alt="Odysseus before setup, showing the ADB command that makes it the device owner" style="width: 250px" /> <img src="downloads-images/Screenshot_20261004-175932.png" alt="Odysseus as device owner, with a user name typed under Create user" style="width: 250px" /> <img src="downloads-images/Screenshot_20261004-175938.png" alt="Odysseus after creating the daily user, showing a User created message" style="width: 250px" /> </div>

### User

<div align="center"> <img src="downloads-images/user1.png" alt="The daily user's App Store failing an install because the policy on this device prevents app installation" style="width: 250px" /> <img src="downloads-images/user2.png" alt="The daily user's app list: searching for Vanadium finds only Vanadium Config and Vanadium System WebView, no browser" style="width: 250px" /> <img src="downloads-images/user3.png" alt="The daily user's app list showing Odysseus" style="width: 250px" /> <img src="downloads-images/user4.png" alt="Odysseus's app info in the daily user: no permissions granted and no data used" style="width: 250px" /> </div> </details>

## Disclaimer

The developer accepts no responsibility for any issues you run into while using Odysseus. Support will be provided on a best-effort basis. Feel free to open an [issue](https://github.com/flourish-today/Odysseus/issues), discuss on the [GrapheneOS forum](https://discuss.grapheneos.org/d/42598-odysseus-make-your-grapheneos-a-dumbphone) thread, or [contact me](https://github.com/flourish-today/Odysseus/blob/main/SECURITY.md).

## Support

**Monero**

```
82omZG3aUU7gqJhR6dZGSReYvKD7kHFuxj5MGKMAGiJdcSYLnMb9Nky9UBxeuadSSzCNYpwfUueQBdQPEaTXmLH4Tkmbv39
```

## Public domain

Odysseus is dedicated to the public domain under CC0 1.0. See [LICENSE](LICENSE).
