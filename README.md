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

<p align="center"><b>Create a dumbphone on GrapheneOS</b></p>

<div align="center">
<table>
  <tr>
    <td align="center"><img src="downloads-images/user1.png" alt="The secondary user's App Store failing an install because the policy on this device prevents app installation" width="220" /><br /><sub>App installs blocked</sub></td>
    <td align="center"><img src="downloads-images/user2.png" alt="The secondary user's app list: searching for Vanadium finds only Vanadium Config and Vanadium System WebView, no browser" width="220" /><br /><sub>No browser</sub></td>
    <td align="center"><img src="downloads-images/user4.png" alt="Odysseus's app info in the secondary user: no permissions granted and no data used" width="220" /><br /><sub>No permissions</sub></td>
  </tr>
</table>
</div>


## Why Odysseus?

-   **No Vanadium.** GrapheneOS can't otherwise create a user without a web browser. Odysseus creates the secondary user without it.
-   **The apps you choose, none that you don't.** Once app installs are turned off from Owner, the secondary user can't add apps.
-   **Hard to bypass.** The restrictions are enforced by Android and GrapheneOS's improved user profiles, and there is no Odysseus screen in the secondary user to turn them off. Only Owner can change them, so Owner's password is what keeps them in place.
-   **Tiny and private.** Under 200 lines of Kotlin, no permissions, no network access, and no telemetry, with reproducible builds.
-   **It can be undone.** Delete the secondary user, then deactivate and uninstall Odysseus.

## What you need

You need a GrapheneOS phone, a USB-C cable, and a computer with [ADB installed](https://developer.android.com/tools/adb). Android only allows a device owner on a phone with no accounts, no other users, and no Private Space. **Back up all important data off your device** first, just as you should do in normal operations as your phone could randomly fail at any time.

<h2 align="center">Download</h2>

<div align="center">
  <a href="https://apps.obtainium.imranr.dev/redirect?r=obtainium://add/https://github.com/flourish-today/Odysseus/releases"><img src="/downloads-images/badge_obtainium.png" alt="Get it on Obtainium" height="80" /></a>
  <a href="https://github.com/flourish-today/Odysseus/releases"><img src="/downloads-images/badge_github.png" alt="Get it on GitHub" height="80" /></a>
</div>
<p align="center">Verify your download with an app verifier:</p>

```
org.getflourish.odysseus
FE:BB:57:70:19:90:D1:36:89:6A:ED:E8:DA:8B:3F:9D:62:C1:3F:0D:20:D2:AD:3B:E7:77:68:2A:B3:96:63:B0
```

## Setup

Follow the [setup guide](SETUP.md). It also includes [adding apps](SETUP.md#adding-apps), [how to undo it](SETUP.md#to-undo-it), and [limitations](SETUP.md#usability-limitations).

## Learn more

-   [How it works](SETUP.md#how-it-works)
-   [FAQ](FAQ.md)
-   [Privacy and security](PRIVACY.md)

## Disclaimer

Use at your own risk. Support will be provided on a best-effort basis. Feel free to open an [issue](https://github.com/flourish-today/Odysseus/issues), discuss on the [GrapheneOS forum](https://discuss.grapheneos.org/d/42598-odysseus-make-your-grapheneos-a-dumbphone) thread, or [contact me](https://github.com/flourish-today).

## Support

**Monero**

```
82omZG3aUU7gqJhR6dZGSReYvKD7kHFuxj5MGKMAGiJdcSYLnMb9Nky9UBxeuadSSzCNYpwfUueQBdQPEaTXmLH4Tkmbv39
```

## Public domain

Odysseus is dedicated to the public domain under CC0 1.0. See [LICENSE](LICENSE).
