// SPDX-License-Identifier: CC0-1.0
package org.getflourish.odysseus

import android.app.admin.DeviceAdminReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.UserManager

// Applied once, when a created user first starts. Changing this list doesn't affect existing users.
private val RESTRICTIONS = listOf(UserManager.DISALLOW_ADD_PRIVATE_PROFILE, UserManager.DISALLOW_DEBUGGING_FEATURES)

class Receiver : DeviceAdminReceiver() {
    // In a user made by createAndManageUser, this app is profile owner and Android calls this on the
    // user's first start. In Owner, where this app is device owner, it does nothing.
    override fun onEnabled(context: Context, intent: Intent) {
        val dpm = getManager(context)
        if (!dpm.isProfileOwnerApp(context.packageName) || dpm.isDeviceOwnerApp(context.packageName)) return
        val admin = getWho(context)
        for (restriction in RESTRICTIONS) dpm.addUserRestriction(admin, restriction)
        // Leave the restricted user with no screen to open.
        context.packageManager.setComponentEnabledSetting(
            ComponentName(context, MainActivity::class.java),
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP,
        )
        try {
            dpm.setBackupServiceEnabled(admin, true)
        } catch (e: Exception) {
            // Backups stay off; the restrictions above are already in place.
        }
    }
}
