# Setup

## How it works

<details>
<summary><b>Click here to see how it works</b></summary>
<br>

-   **Owner is the manager.** You use Owner to set up the secondary user and to add or update its apps. Owner remains unrestricted to manage the device. Much of the setup Odysseus lets you create is based around GrapheneOS's [improved user profiles](https://grapheneos.org/features#improved-user-profiles).
-   **The secondary user is a restricted user for everyday use.** Odysseus creates it without the optional system apps, so on GrapheneOS it starts without the browser (Vanadium). It starts with a basic set: App Store, Contacts, Files, Settings, and Phone. You add the apps you want from Owner, then turn off app installs for the secondary user. Once app installs are off, there's no way to add more from inside it.
-   **No off switch in the secondary user.** When the secondary user starts for the first time, Odysseus blocks Private Space and debugging features in it, and hides its own icon. There is no Odysseus screen in the secondary user to turn the restrictions off.

</details>

## Before you start

-   You need a GrapheneOS phone, a USB-C cable, and a computer with [ADB installed](https://developer.android.com/tools/adb).
-   **Back up all important data off your device.** You should do this even if you weren't using Odysseus, in case your phone gets lost or breaks.
-   Android only allows a device owner on a phone with no accounts, no other users, and no Private Space. The most reliable way is a factory reset. Otherwise, remove every account, every other user, and Owner's Private Space. If you only use Owner, removing all accounts in Settings and your Private Space is enough.
-   Owner's password is what keeps the secondary user restricted. Pick one you can't easily get to yourself. For example, have someone you trust set it, or split it so you each know only half. You can also use a long password stored somewhere inconvenient or a long password you have memorized. Whatever method you pick, consider memorizing part of it and not sharing that part, so only you can get into the phone. If the password is lost, the only way back is a factory reset.
-   You may want to keep Owner's password simple until setup is finished.
-   Consider setting the auto reboot timer longer than you usually go without using your phone. After each automatic restart, you have to unlock Owner before you can switch to the secondary user.

## Instructions

1.  Install Odysseus in Owner.
2.  Enable Developer options: open Settings → About phone, tap Build number seven times, and enter your PIN or password.
3.  In Settings → System → Developer options, turn on USB debugging.
4.  Connect the phone to your computer. When the phone asks whether to allow USB debugging, tap Allow.
5.  On your computer, open a terminal (Command Prompt on Windows) and run the command Odysseus shows on its screen:
    `adb shell dpm set-device-owner org.getflourish.odysseus/.Receiver`
    Odysseus should now say "Device owner: active."
6.  Turn off Developer options in Settings → System → Developer options (this will also turn off USB debugging).
7.  In Odysseus, under Create user, type a name like "user" and tap Create.
8.  In Owner, go to Settings → System → Users → (the secondary user) → Install available apps, and choose the apps you want. It's recommended to install all GrapheneOS default apps besides Vanadium to avoid breakage. Without Camera, for example, you can't take photos in Signal. App installs are already enabled for a new user, so you don't need to turn them on here. You can add more apps later (see [Adding apps](#adding-apps)).
9.  Switch to the secondary user (swipe down twice from the top of the screen and tap the user icon) and finish its setup. In its App Store, check that Vanadium Config and Vanadium System WebView are installed, and install them if not. Apps that use WebView need them (see [Usability limitations](#usability-limitations)).
10. Go back to Owner, open Settings → System → Users → (the secondary user), and set App installs and updates to Disabled.
11. In the secondary user, check that Odysseus's icon is gone from the home screen, that Odysseus can't be uninstalled in Settings → Apps, and that Private Space can't be set up. If any of these checks fails, go back to Owner, delete the secondary user, and create it again.

## Troubleshooting

-   **The `set-device-owner` command fails with an error about accounts or users.** An account, another user, or Private Space still exists. Remove it and run the command again. A reliable way to set up Odysseus is after a factory reset.
-   **ADB says no devices were found, or that the device is unauthorized.** Check that the cable is connected and USB debugging is on, then unplug and reconnect the phone and tap Allow when it asks.

## Adding apps

To add an app to the secondary user:

1.  Install the app in Owner.
2.  In Owner, go to Settings → System → Users → (the secondary user) and set App installs and updates to Enabled.
3.  Tap Install available apps and choose the app.
4.  Set App installs and updates back to Disabled before you switch to the secondary user.

To update an app, simply update it in Owner. Both users share the same installed copy of an app, so the secondary user gets the update too. You don't need to enable App installs and updates to get updates to your apps. That setting only stops the secondary user itself from starting an install or update.

## To undo it

1.  In Owner, delete the secondary user: Settings → System → Users → (the secondary user) → Delete user.
2.  Open Odysseus and tap Deactivate.
3.  You can now uninstall Odysseus.

If you tap Deactivate without deleting the secondary user, the secondary user stays restricted: Odysseus remains its profile owner and can't be uninstalled there. Deleting the secondary user is what removes its restrictions.

## Usability limitations

-   Leaving system apps out of the secondary user can break apps. Links that would normally open in a browser won't open, because there is none.
-   WebView:
    -   **With Vanadium Config and Vanadium System WebView installed** (setup step 9), apps that need WebView work, but any app with a built-in browser may still let you browse the web. Choose the secondary user's apps with that in mind. If an app lets you browse sites beyond the ones it needs, consider asking its developer to follow [Android security best practices](https://developer.android.com/privacy-and-security/security-best-practices#webview).
    -   **Without them**, built-in browsers can't load pages, but apps that need WebView break.
-   Private Space is unavailable in all users.

## Screenshots

### Owner

<div align="center">
<table>
  <tr>
    <td><img src="downloads-images/Screenshot_20261004-174600.png" alt="Owner's home screen with Odysseus installed alongside the default GrapheneOS apps" width="250" /></td>
    <td><img src="downloads-images/Screenshot_20261004-174606.png" alt="Odysseus before setup, showing the ADB command that makes it the device owner" width="250" /></td>
  </tr>
  <tr>
    <td align="center">Odysseus installed in Owner</td>
    <td align="center">The ADB command</td>
  </tr>
  <tr>
    <td><img src="downloads-images/Screenshot_20261004-175932.png" alt="Odysseus as device owner, with a user name typed under Create user" width="250" /></td>
    <td><img src="downloads-images/Screenshot_20261004-175938.png" alt="Odysseus after creating the secondary user, showing a User created message" width="250" /></td>
  </tr>
  <tr>
    <td align="center">Creating the secondary user</td>
    <td align="center">User created</td>
  </tr>
</table>
</div>

### Secondary user

<div align="center">
<table>
  <tr>
    <td><img src="downloads-images/user1.png" alt="The secondary user's App Store failing an install because the policy on this device prevents app installation" width="250" /></td>
    <td><img src="downloads-images/user2.png" alt="The secondary user's app list: searching for Vanadium finds only Vanadium Config and Vanadium System WebView, no browser" width="250" /></td>
  </tr>
  <tr>
    <td align="center">App installs blocked</td>
    <td align="center">No browser</td>
  </tr>
  <tr>
    <td><img src="downloads-images/user3.png" alt="The secondary user's app list showing Odysseus" width="250" /></td>
    <td><img src="downloads-images/user4.png" alt="Odysseus's app info in the secondary user: no permissions granted and no data used" width="250" /></td>
  </tr>
  <tr>
    <td align="center">Odysseus in the app list</td>
    <td align="center">No permissions or data used</td>
  </tr>
</table>
</div>
