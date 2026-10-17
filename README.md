<div align="center"><img src="downloads-images/icon.svg" alt="Odysseus icon" width="128" /></div>

<h1 align="center">Odysseus</h1>

<h3 align="center">Create a dumbphone on GrapheneOS</h3>

<p align="center">Odysseus sets up a secondary user on your phone with no browser and only the apps you choose.<br />Nothing new can be installed in it without the Owner profile's password.</p>

<p align="center">
  <a href="PRIVACY.md#features"><img alt="No network access" src="https://img.shields.io/badge/network-none-2EA043?style=for-the-badge&labelColor=1F4D2B" /></a>
  <a href="app/src/main/AndroidManifest.xml"><img alt="0 permissions" src="https://img.shields.io/badge/permissions-0-2EA043?style=for-the-badge&labelColor=1F4D2B" /></a>
  <a href="PRIVACY.md#reproducible-builds"><img alt="Reproducible builds" src="https://img.shields.io/badge/builds-reproducible-2EA043?style=for-the-badge&labelColor=1F4D2B" /></a>
</p>

<div align="center">
<table>
  <tr>
    <td align="center"><img src="downloads-images/user1.png" alt="The secondary user's App Store failing an install because the policy on this device prevents app installation" width="220" /><br /><sub>App installs blocked</sub></td>
    <td align="center"><img src="downloads-images/user2.png" alt="The secondary user's app list: searching for Vanadium finds only Vanadium Config and Vanadium System WebView, no browser" width="220" /><br /><sub>No browser</sub></td>
    <td align="center"><img src="downloads-images/user4.png" alt="Odysseus's app info in the secondary user: all the options, archive, disable, uninstall, and force stop are grayed out which shows the secondary user cannot uninstall Odysseus." width="220" /><br /><sub>No uninstalling</sub></td>
  </tr>
</table>
</div>

## Why Odysseus?

-   **No browser.** GrapheneOS can't otherwise create a user without Vanadium. Odysseus creates the secondary user without it.
-   **The apps you choose, none that you don't.** Once app installs are turned off from the Owner profile, the secondary user can't add apps.
-   **Hard to bypass.** The restrictions are enforced by Android and GrapheneOS's improved user profiles, and there is no Odysseus screen in the secondary user to turn them off. Only the Owner profile can change them, so the Owner profile's password is what keeps them in place.
-   **Tiny and private.** Under 200 lines of Kotlin, no permissions, no network access, and no telemetry, with reproducible builds.

   ## What you need

You need a GrapheneOS phone, a USB-C cable, and a computer with [ADB installed](https://developer.android.com/tools/adb). Android only allows a device owner on a phone with no accounts, no other users, and no Private Space, so you'll need to remove these if you have any of them. Alternatively a factory reset will always work but you lose all data in your owner profile compared to simply removing the accounts. **Back up all important data off your device before you start.**


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

## Setup

1. Install Odysseus and make it device owner with a single ADB command.
2. Create the restricted user and add your apps.
3. Turn off app installs from the Owner profile and switch over.

See the [setup guide](SETUP.md) for the full steps.

## Learn more

-   [How it works](SETUP.md#how-it-works)
-   [FAQ](FAQ.md)
-   [Privacy and security](PRIVACY.md)
-   [GrapheneOS forum thread](https://discuss.grapheneos.org/d/42598-odysseus-make-your-grapheneos-a-dumbphone)
-   [Issues](https://github.com/flourish-today/Odysseus/issues)

## Support

**Monero**

```
82omZG3aUU7gqJhR6dZGSReYvKD7kHFuxj5MGKMAGiJdcSYLnMb9Nky9UBxeuadSSzCNYpwfUueQBdQPEaTXmLH4Tkmbv39
```
## Contact

-   Email: flourish.today@protonmail.com
-   SimpleX: https://smp17.simplex.im/a#OYNzLgLMY-vsrI69LroxLrhc4xkyLGpT2Q5ygNvoaAc

## Public domain

Odysseus is dedicated to the public domain under CC0 1.0. See [LICENSE](LICENSE).
