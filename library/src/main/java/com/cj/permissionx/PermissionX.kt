package com.cj.permissionx

import androidx.fragment.app.FragmentActivity

object PermissionX {

    private const val TAG = "InvisibleFragment"

    fun request(activity: FragmentActivity, vararg permission: String, callback: PermissionCallback) {
        val fragmentmanager = activity.supportFragmentManager
        val exitedFragment = fragmentmanager.findFragmentByTag(TAG)
        val fragment = if (exitedFragment != null) {
            exitedFragment as InvisibleFragment
        } else {
            val invisibleFragment = InvisibleFragment()
            fragmentmanager.beginTransaction().add(invisibleFragment, TAG).commitNow()
            invisibleFragment
        }
        fragment.requestNow(callback, *permission)
    }
}