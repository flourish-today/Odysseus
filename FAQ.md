# FAQ

## Does Odysseus use AI?

Yes. This app was developed with Claude Opus 5.5. Its code was reviewed by GPT-6 Astra and Opus 5.5. AI security reviews of Odysseus found no way for other apps to use its device-owner powers and no other security or privacy issues. They found minor reliability issues, most of which have been fixed or found inconsequential. More reviews are welcome.

## Is Odysseus secure?

Odysseus uses the intended way to restrict devices on Android. It's tiny, requests no permissions, and only does what it says. See more info in [PRIVACY.md](PRIVACY.md). You can verify you got the real Odysseus APK using the [SHA256 Signing Certificate](PRIVACY.md#verifying-a-release), and verify that its source code matches the released APK through [reproducible builds](PRIVACY.md#reproducible-builds).

## Is Odysseus privacy respecting?

Yes. There's no telemetry, no permissions, and no network access.

## What are the risks?

One risk with Odysseus, and device-owner apps in general, is the amount of trust you have to put in them. Device-owner apps are given a huge amount of permissions by Android. Odysseus uses only the few listed in [PRIVACY.md](PRIVACY.md#device-management-apis-used), and they can be undone. See [Risks to using Odysseus](PRIVACY.md#risks-to-using-odysseus) for more.

## Will I always need ADB?

In the future, depending on GrapheneOS, Odysseus may be updated so you can install it and make it the device owner without ADB, through QR code provisioning during initial device setup ([issue](https://github.com/GrapheneOS/platform_packages_apps_SetupWizard2/issues/35) / [earlier attempt, closed](https://github.com/GrapheneOS/platform_packages_apps_SetupWizard2/pull/40)). You can add reactions to the issue to show support, but please only comment if you have something meaningful to add.

## What if I have an iPhone or iPad that I want to achieve the same result on?

You should use Apple Configurator ([guide1](https://redlib.catsarch.com/r/nosurf/comments/1731ozp/how_to_turn_your_your_iphone_into_dumb_phone/) / [guide2](https://stopa.io/post/297)) to manage your devices, remove the browser and prevent new app installs. A macOS device and a factory reset of your iPhone/iPad are required for the initial setup. A [new app](https://news.ycombinator.com/item?id=49982974) that claims to allow this setup without a factory reset has been released but I have not looked into it at all and this is not a recommendation.

## There's been no activity recently, is it still safe?

This is a simple app which will not require many updates. Odysseus works on Android 17-based GrapheneOS. If something breaks after an update, please open an [issue](https://github.com/flourish-today/Odysseus/issues).
