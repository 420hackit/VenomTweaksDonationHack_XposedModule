package com.fourtwentyhackit.venomtweaksdonationhack; 

import android.util.Log;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;
import de.robv.android.xposed.XC_MethodHook;
import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class VenomDonationHack implements IXposedHookLoadPackage {
	@Override
	 public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {
		if (!lpparam.packageName.equals("com.m0narx.tweaks"))
            return;
		
		Log.i("Xposed","Venom Tweaks has loaded");
		
		findAndHookMethod("com.m0narx.tweaks.Donation", lpparam.classLoader, "createDonationDialog", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
            	Log.i("Xposed","Hooked onto the createDonationDialog() method, returning null...");
            	param.setResult(null);
            	return;
            }
		});
	 }
}