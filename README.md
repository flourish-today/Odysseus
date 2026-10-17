<div align="center"><img src="downloads-images/icon.svg" alt="Odysseus icon" width="128" /></div>

<h1 align="center">Odysseus</h1>

<br />

<p align="center">
  <a href="PRIVACY.md#features"><img alt="No network access" src="https://img.shields.io/badge/network-none-2EA043?style=for-the-badge&labelColor=1F4D2B" /></a>
  <a href="app/src/main/AndroidManifest.xml"><img alt="0 permissions" src="https://img.shields.io/badge/permissions-0-2EA043?style=for-the-badge&labelColor=1F4D2B" /></a>
  <a href="PRIVACY.md#reproducible-builds"><img alt="Reproducible builds" src="https://img.shields.io/badge/builds-reproducible-2EA043?style=for-the-badge&labelColor=1F4D2B" /></a>

<h3 align="center">Create a dumbphone on GrapheneOS</h3>

<p align="center">Odysseus sets up a secondary user on your phone with no browser and only the apps you choose.<br />Nothing new can be installed in it without Owner's password.</p>

<div align="center">
<table>
  <tr>
    <td align="center"><img src="downloads-images/user1.png" alt="The secondary user's App Store failing an install because the policy on this device prevents app installation" width="220" /><br /><sub>App installs blocked</sub></td>
    <td align="center"><img src="downloads-images/user2.png" alt="The secondary user's app list: searching for Vanadium finds only Vanadium Config and Vanadium System WebView, no browser" width="220" /><br /><sub>No browser</sub></td>
    <td align="center"><img src="downloads-images/user4.png" alt="Odysseus's app info in the secondary user: no permissions granted and no data used" width="220" /><br /><sub>No uninstalling</sub></td>
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

You need a GrapheneOS phone, a USB-C cable, and a computer with [ADB installed](https://developer.android.com/tools/adb). Android only allows a device owner on a phone with no accounts, no other users, and no Private Space. **Back up all important data off your device**—if you have profiles you must remove them so you need that data and there's always a risk when using an app that changes your system. 

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
