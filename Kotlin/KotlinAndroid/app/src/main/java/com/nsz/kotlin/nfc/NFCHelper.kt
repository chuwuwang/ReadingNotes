package com.nsz.kotlin.nfc

import android.content.Context
import android.content.Intent
import android.nfc.NfcAdapter
import android.provider.Settings

object NFCHelper {

    /**
     * 判断手机是否具备NFC功能
     */
    fun hasNFCFunction(context: Context): Boolean {
        val adapter = NfcAdapter.getDefaultAdapter(context)
        return adapter != null
    }

    fun isNFCFunctionEnable(context: Context): Boolean {
        val adapter = NfcAdapter.getDefaultAdapter(context)
        return adapter != null && adapter.isEnabled
    }

    fun gotoNFCSettings(context: Context) {
        val intent = Intent(Settings.ACTION_NFC_SETTINGS)
        context.startActivity(intent)
    }

}