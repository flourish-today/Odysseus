// SPDX-License-Identifier: CC0-1.0
package org.getflourish.odysseus

import android.app.Activity
import android.app.AlertDialog
import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowInsets
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {
    private lateinit var dpm: DevicePolicyManager
    private lateinit var admin: ComponentName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)
        dpm = getSystemService(DevicePolicyManager::class.java)
        admin = ComponentName(this, Receiver::class.java)
        // Android draws apps edge to edge, so keep the content clear of the system bars and keyboard.
        findViewById<View>(R.id.root).setOnApplyWindowInsetsListener { view, insets ->
            val types = WindowInsets.Type.systemBars() or WindowInsets.Type.displayCutout() or WindowInsets.Type.ime()
            val bars = insets.getInsets(types)
            view.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }
        findViewById<TextView>(R.id.title).text = applicationInfo.loadLabel(packageManager)
        findViewById<TextView>(R.id.adb_command).text = "adb shell dpm set-device-owner ${admin.flattenToShortString()}"
        findViewById<Button>(R.id.create_user).setOnClickListener { createUser() }
        findViewById<Button>(R.id.deactivate).setOnClickListener { confirmDeactivate() }
    }

    override fun onResume() {
        super.onResume()
        refresh()
    }

    private fun refresh() {
        val owner = dpm.isDeviceOwnerApp(packageName)
        findViewById<TextView>(R.id.status).setText(if (owner) R.string.status_device_owner else R.string.status_not_device_owner)
        findViewById<View>(R.id.adb_command).visibility = if (owner) View.GONE else View.VISIBLE
        findViewById<View>(R.id.owner_controls).visibility = if (owner) View.VISIBLE else View.GONE
        if (owner) {
            val backupsOn = try {
                dpm.setBackupServiceEnabled(admin, true)
                true
            } catch (e: Exception) {
                false
            }
            findViewById<View>(R.id.backups_failed).visibility = if (backupsOn) View.GONE else View.VISIBLE
        }
    }

    private fun createUser() {
        val field = findViewById<EditText>(R.id.user_name)
        val name = field.text.toString().trim()
        if (name.isEmpty()) return
        val button = findViewById<Button>(R.id.create_user)
        button.isEnabled = false
        // Creating a user can take a few seconds, so it runs off the main thread.
        Thread {
            val error = try {
                // Flags 0: don't enable all system apps, don't skip setup, don't make the user temporary.
                checkNotNull(dpm.createAndManageUser(admin, name, admin, null, 0))
                null
            } catch (e: Exception) {
                e.message ?: e.javaClass.simpleName
            }
            runOnUiThread {
                button.isEnabled = true
                if (error == null) {
                    field.text.clear()
                    Toast.makeText(this, R.string.user_created, Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, getString(R.string.user_create_failed, error), Toast.LENGTH_LONG).show()
                }
            }
        }.start()
    }

    @Suppress("DEPRECATION") // Still the only way for a device owner to remove itself.
    private fun confirmDeactivate() {
        AlertDialog.Builder(this)
            .setTitle(R.string.deactivate_confirm_title)
            .setMessage(R.string.deactivate_confirm_message)
            .setPositiveButton(R.string.deactivate) { _, _ ->
                try {
                    dpm.clearDeviceOwnerApp(packageName)
                } catch (e: Exception) {
                    val error = e.message ?: e.javaClass.simpleName
                    Toast.makeText(this, getString(R.string.deactivate_failed, error), Toast.LENGTH_LONG).show()
                }
                refresh()
            }
            .setNegativeButton(android.R.string.cancel, null)
            .show()
    }
}
